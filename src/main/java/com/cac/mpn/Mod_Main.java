package com.cac.mpn;

import com.cac.mpn.handler.GuiHandler;
import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.core.DefaultPowerSystem;
import com.cac.mpn.power.core.PowerSystemManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = Mod_Main.MODID, name = Mod_Main.NAME, version = Mod_Main.VERSION)
public class Mod_Main {
    public static final String MODID = "mpn";
    public static final String NAME = "Minecraft Project Nexus";
    public static final String VERSION = "Test-0.1";

    @Mod.Instance(MODID)
    public static Mod_Main instance;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        // 初始化电力系统
        PowerSystemManager.initialize(DefaultPowerSystem.class, 2);

        // 注册GUI处理器
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        logger.info("Power system initialized");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // 可以在这里添加合成配方
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // 后期初始化
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