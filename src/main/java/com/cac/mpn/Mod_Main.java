package com.cac.mpn;

import com.cac.mpn.power.SimplePowerRegistry;
import com.cac.mpn.power.devices.ContainerSteamGenerator;
import com.cac.mpn.power.devices.GuiSteamGenerator;
import com.cac.mpn.power.devices.SteamGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.apache.logging.log4j.Logger;

@Mod(modid = Mod_Main.MODID, name = Mod_Main.NAME, version = Mod_Main.VERSION)
public class Mod_Main implements IGuiHandler {
    public static final String MODID = "mpn";
    public static final String NAME = "Minecraft Project Nexus";
    public static final String VERSION = "Test-0.1";

    @Mod.Instance(MODID)
    public static Mod_Main instance;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        SimplePowerRegistry.initialize();
        net.minecraftforge.fml.common.network.NetworkRegistry.INSTANCE.registerGuiHandler(this, this);
        logger.info("Power system initialized");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        logger.info("Active power networks: {}",
                com.cac.mpn.power.core.SimplePowerSystem.getInstance().getNetworkCount());
    }

    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event) {
        logger.info("Power system shutdown");
    }

    public static Logger getLogger() {
        return logger;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof SteamGenerator) {
            return new ContainerSteamGenerator(player.inventory, (SteamGenerator) te);
        }
        return null;
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof SteamGenerator) {
            return new GuiSteamGenerator(player.inventory, (SteamGenerator) te);
        }
        return null;
    }
}