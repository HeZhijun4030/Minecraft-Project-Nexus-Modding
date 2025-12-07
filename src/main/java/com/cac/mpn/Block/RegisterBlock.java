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
    public static final Singular_solar SINGULAR_SOLAR= new Singular_solar();
    public static final II_solar II_SOLAR = new II_solar();
    public static final III_solar III_SOLAR = new III_solar();
    public static final IV_solar IV_SOLAR = new IV_solar();
    public static final V_solar V_SOLAR = new V_solar();
    public static final VI_solar VI_SOLAR = new VI_solar();
    public static final VII_solar VII_SOLAR = new VII_solar();
    public static final Atomic_solar ATOMIC_SOLAR = new Atomic_solar();
    public static final Proton_solar PROTON_SOLAR = new Proton_solar();
    public static final Neutron_solar NEUTRON_SOLAR = new Neutron_solar();
    public static final Quark_solar QUARK_SOLAR = new Quark_solar();
    public static final Planck_solar PLANCK_SOLAR = new Planck_solar();
    public static final Void_solar VOID_SOLAR = new Void_solar();
    public static final Titanium TITANIUM= new Titanium();
    public static final Copper_ore COPPER_ORE = new Copper_ore();
    public static final Zinc_ore ZINC_ORE = new Zinc_ore();
    public static final Tin_ore TIN_ORE = new Tin_ore();
    public static final I_solar I_SOLAR = new I_solar();
    public static final Electrolyzer ELECTROLYZER = new Electrolyzer();



    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(ELECTROLYZER);
        registry.register(ELECTRONIC_SOLAR);
        registry.register(SPECTRAL_SOLAR);
        registry.register(SINGULAR_SOLAR);
        registry.register(II_SOLAR);
        registry.register(III_SOLAR);
        registry.register(IV_SOLAR);
        registry.register(V_SOLAR);
        registry.register(VI_SOLAR);
        registry.register(VII_SOLAR);
        registry.register(ATOMIC_SOLAR);
        registry.register(PROTON_SOLAR);
        registry.register(NEUTRON_SOLAR);
        registry.register(QUARK_SOLAR);
        registry.register(PLANCK_SOLAR);
        registry.register(VOID_SOLAR);
        registry.register(TITANIUM);
        registry.register(COPPER_ORE);
        registry.register(ZINC_ORE);
        registry.register(TIN_ORE);
        registry.register(I_SOLAR);
    }


}