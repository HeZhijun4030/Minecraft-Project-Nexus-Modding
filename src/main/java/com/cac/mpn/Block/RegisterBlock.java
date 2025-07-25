package com.cac.mpn.Block;


import com.cac.mpn.power.devices.ZincWire;
import com.cac.mpn.power.devices.ElectricFurnace;
import com.cac.mpn.Block.BlockZincWire;
import com.cac.mpn.Block.BlockElectricFurnace;
import com.cac.mpn.Block.BlockCopperWire;
import com.cac.mpn.Block.BlockBasicSolarGenerator;

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
    public static final BlockSteamGenerator STEAM_GENERATOR = new BlockSteamGenerator();
    public static final BlockZincWire BLOCK_ZINC_WIRE = new BlockZincWire();
    public static final BlockElectricFurnace BLOCK_ELECTRIC_FURNACE = new BlockElectricFurnace();
    public static final Copper COPPER = new Copper();
    public static final Zinc ZINC = new Zinc();
    public static final AlloyMachine ALLOY_MACHINE = new AlloyMachine();
    public static final Tin TIN = new Tin();
    public static final Aluminum ALUMINUM = new Aluminum();
    public static final BlockCopperWire BLOCK_COPPER_CABLE = new BlockCopperWire();
    public static final BlockBasicSolarGenerator BASIC_SOLAR_GENERATOR = new BlockBasicSolarGenerator();


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(ELECTRONIC_SOLAR);
        registry.register(SPECTRAL_SOLAR);
        registry.register(SINGULAR_SOLAR);
        registry.register(TITANIUM);
        registry.register(STEAM_GENERATOR);
        registry.register(BLOCK_ZINC_WIRE);
        registry.register(BLOCK_ELECTRIC_FURNACE);
        registry.register(COPPER);
        registry.register(ZINC);
        registry.register(ALLOY_MACHINE);
        registry.register(TIN);
        registry.register(ALUMINUM);
        registry.register(BLOCK_COPPER_CABLE);
        registry.register(BASIC_SOLAR_GENERATOR);

    }
}