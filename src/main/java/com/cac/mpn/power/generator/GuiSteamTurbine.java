// com/cac/mpn/power/generator/GuiSteamTurbine.java
package com.cac.mpn.power.generator;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSteamTurbine extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mpn", "textures/gui/steam_turbine.png");
    private final TileSteamTurbine tileEntity;
    private final InventoryPlayer playerInventory;

    public GuiSteamTurbine(InventoryPlayer playerInventory, TileSteamTurbine tileEntity) {
        super(new ContainerSteamTurbine(playerInventory, tileEntity));
        this.tileEntity = tileEntity;
        this.playerInventory = playerInventory;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = tileEntity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        // 绘制燃烧进度
        if (tileEntity.isBurning()) {
            int k = tileEntity.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        // 绘制水量
        int l = tileEntity.getWaterScaled(60);
        this.drawTexturedModalRect(i + 26, j + 15 + 60 - l, 176, 74 - l, 16, l);

        // 绘制能量条
        int m = tileEntity.getEnergyScaled(60);
        this.drawTexturedModalRect(i + 134, j + 15 + 60 - m, 176, 134 - m, 16, m);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);

        // 添加提示信息
        if (isPointInRegion(26, 15, 16, 60, mouseX, mouseY)) {
            this.drawHoveringText("Water: " + tileEntity.getWaterAmount() + "mB", mouseX, mouseY);
        }
        if (isPointInRegion(134, 15, 16, 60, mouseX, mouseY)) {
            this.drawHoveringText("Energy: " + tileEntity.getStoredPower() + " ZF", mouseX, mouseY);
        }
    }
}