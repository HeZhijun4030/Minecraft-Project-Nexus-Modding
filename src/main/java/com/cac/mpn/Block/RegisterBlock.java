package com.cac.mpn.Block;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;


@Mod.EventBusSubscriber
public class RegisterBlock {




    public static final Spectral_solar SPECTRAL_SOLAR = new Spectral_solar();
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(SPECTRAL_SOLAR);

    }

}