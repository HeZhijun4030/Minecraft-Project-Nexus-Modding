package com.cac.mpn.power;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class SimplePowerRegistry {
    
    private static boolean initialized = false;
    
    public static void initialize() {
        if (initialized) return;
        

        com.cac.mpn.power.core.SimplePowerSystem.getInstance();
        // 删除重复的TileEntity注册，全部交由Mod_Main.java注册
        initialized = true;
    }
    

    public static void registerPowerDevice(Class<? extends TileEntity> tileClass, String registryName) {
        GameRegistry.registerTileEntity(tileClass, registryName);
    }
    
    /**
     * 批量注册电力设备
     */
    public static void registerPowerDevices(Class<? extends TileEntity>... tileClasses) {
        for (Class<? extends TileEntity> tileClass : tileClasses) {
            String registryName = "mpn:" + tileClass.getSimpleName().toLowerCase();
            registerPowerDevice(tileClass, registryName);
        }
    }
} 