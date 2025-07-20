package com.cac.mpn.power.devices;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiSteamGenerator extends GuiContainer {
    private static final net.minecraft.util.ResourceLocation BG = new net.minecraft.util.ResourceLocation("minecraft:textures/gui/container/furnace.png");
    private final SteamGenerator tile;
    private final InventoryPlayer playerInv;

    public GuiSteamGenerator(InventoryPlayer playerInv, SteamGenerator tile) {
        super(new ContainerSteamGenerator(playerInv, tile));
        this.tile = tile;
        this.playerInv = playerInv;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = new TextComponentTranslation("container.steam_generator").getUnformattedText();
        this.fontRenderer.drawString(name, 8, 6, 4210752);
        this.fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
        FluidTank tank = tile.getWaterTank();
        net.minecraftforge.fluids.FluidStack fluid = tank.getFluid();
        int water = fluid == null ? 0 : fluid.amount;
        this.fontRenderer.drawString("水: " + water + "/" + tank.getCapacity() + " mL", 8, 20, Color.BLUE.getRGB());

        this.fontRenderer.drawString("燃料: " + tile.getBurnTime() + "/" + tile.getBurnTimeTotal(), 8, 32, Color.ORANGE.getRGB());

        this.fontRenderer.drawString("电量: " + tile.getStoredPower() + "/" + tile.getMaxPower() + " ZF", 8, 44, Color.GREEN.getRGB());

        String status = tile.getBurnTime() > 0 ? (water > 0 ? "发电中" : "缺水") : "待机/缺燃料";
        this.fontRenderer.drawString("状态: " + status, 8, 56, Color.DARK_GRAY.getRGB());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(BG);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        // 可在此处绘制进度条等
    }
} 