package com.cac.mpn.gui;

import com.cac.mpn.Block.Electrolyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public static final int GUI_ELECTROLYZER = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_ELECTROLYZER) {
            return new ContainerElectrolyzer(player.inventory, (com.cac.mpn.power.TileEntityPower) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_ELECTROLYZER) {
            return new GuiElectrolyzer(player.inventory, (com.cac.mpn.power.TileEntityPower) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }
}
