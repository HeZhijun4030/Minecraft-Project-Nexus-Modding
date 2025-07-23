package com.cac.mpn.power.devices;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import org.lwjgl.opengl.GL11;
import java.awt.*;

public class GuiAlloyMachine extends GuiContainer {
    private static final ResourceLocation BG = new ResourceLocation("minecraft:textures/gui/container/furnace.png");
    private final AlloyMachineTileEntity tile;
    private final InventoryPlayer playerInv;

    public GuiAlloyMachine(InventoryPlayer playerInv, AlloyMachineTileEntity tile) {
        super(new ContainerAlloyMachine(playerInv, tile));
        this.tile = tile;
        this.playerInv = playerInv;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = new TextComponentTranslation("container.alloy_machine").getUnformattedText();
        this.fontRenderer.drawString(name, 8, 6, 4210752);
        this.fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
        float powerK = tile.getStoredPower() / 1000.0f;
        float capK = tile.getCapacity() / 1000.0f;
        this.fontRenderer.drawString(String.format("电量: %.1fk/%.1fk ZF", powerK, capK), 8, 20, Color.GREEN.getRGB());
        int work = tile.getWorkTime();
        int workTotal = tile.getWorkTimeTotal();
        this.fontRenderer.drawString(String.format("进度: %d/%d", work, workTotal), 8, 32, Color.BLUE.getRGB());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(BG);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        // 进度条
        int work = tile.getWorkTime();
        int workTotal = tile.getWorkTimeTotal();
        int bar = work * 24 / workTotal;
        this.drawTexturedModalRect(x + 79, y + 34, 176, 14, bar + 1, 16);
    }
} 