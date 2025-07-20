package com.cac.mpn.Block;

import com.cac.mpn.power.generator.BlockSteamTurbine;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RegisterBlock {
    public static final Spectral_solar SPECTRAL_SOLAR = new Spectral_solar();
    public static final Electronic_solar ELECTRONIC_SOLAR = new Electronic_solar();
    public static final Singular_solar SINGULAR_SOLAR = new Singular_solar();
    public static final Titanium TITANIUM = new Titanium();
    public static final BlockSteamTurbine STEAM_TURBINE = new BlockSteamTurbine();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(ELECTRONIC_SOLAR);
        registry.register(SPECTRAL_SOLAR);
        registry.register(SINGULAR_SOLAR);
        registry.register(TITANIUM);
        registry.register(STEAM_TURBINE);
    }
}