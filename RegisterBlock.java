package com.cac.mpn.Block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;


@Mod.EventBusSubscriber
public class RegisterBlock {

    public static final Spectral_solar SPECTRAL_SOLAR= new Spectral_solar();
    public static final Electronic_solar ELECTRONIC_SOLAR= new Electronic_solar();


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(ELECTRONIC_SOLAR);
        registry.register(SPECTRAL_SOLAR);
    }


}