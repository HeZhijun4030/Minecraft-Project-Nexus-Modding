// com/cac/mpn/Mod_Main.java
package com.cac.mpn;

import com.cac.mpn.power.PowerRegistry;
import com.cac.mpn.power.core.DefaultPowerSystem;
import com.cac.mpn.power.core.PowerSystemManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Mod_Main.MODID, name = Mod_Main.NAME, version = Mod_Main.VERSION)
public class Mod_Main {
    public static final String MODID = "mpn";
    public static final String NAME = "Minecraft Project Nexus";
    public static final String VERSION = "Test-0.1";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        PowerSystemManager.initialize(DefaultPowerSystem.class, 2);
        PowerRegistry.initialize();
        logger.info("Power system initialized");
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        logger.info("Active power networks: {}",
                PowerSystemManager.getInstance().getNetworkCount());
    }

    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event) {
        PowerSystemManager.getInstance().shutdown();
    }

    public static Logger getLogger() {
        return logger;
    }
}