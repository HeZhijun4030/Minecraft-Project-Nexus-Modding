package com.cac.mpn.handler;

import com.cac.mpn.power.generator.ContainerSteamTurbine;
import com.cac.mpn.power.generator.GuiSteamTurbine;
import com.cac.mpn.power.generator.TileSteamTurbine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public static final int STEAM_TURBINE_GUI_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == STEAM_TURBINE_GUI_ID) {
            TileSteamTurbine tile = (TileSteamTurbine) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerSteamTurbine(player.inventory, tile);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == STEAM_TURBINE_GUI_ID) {
            TileSteamTurbine tile = (TileSteamTurbine) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiSteamTurbine(player.inventory, tile);
        }
        return null;
    }
}