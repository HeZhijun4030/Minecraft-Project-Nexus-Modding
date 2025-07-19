// com/cac/mpn/power/PowerRegistry.java
package com.cac.mpn.power;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PowerRegistry {
    private static boolean initialized = false;

    public static void initialize() {
        if (initialized) return;

        registerGenerators();
        registerWires();
        registerMachines();

        initialized = true;
    }

    private static void registerGenerators() {

    }

    private static void registerWires() {

    }

    private static void registerMachines() {

    }

    public static void registerCustomPowerDevice(Class<? extends TileEntity> tileClass, String registryName) {
        GameRegistry.registerTileEntity(tileClass, registryName);
    }
}