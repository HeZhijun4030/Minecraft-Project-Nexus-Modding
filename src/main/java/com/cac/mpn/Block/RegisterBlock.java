package com.cac.mpn.Block;


import com.cac.mpn.power.devices.ZincWire;
import com.cac.mpn.power.devices.ElectricFurnace;
import com.cac.mpn.Block.BlockZincWire;
import com.cac.mpn.Block.BlockElectricFurnace;
import com.cac.mpn.Block.BlockCopperWire;
import com.cac.mpn.Block.BlockBasicSolarGenerator;
import com.cac.mpn.Block.BlockWaterPump500ZF;
import com.cac.mpn.Block.BlockWaterPipe;
import com.cac.mpn.Block.TitaniumAlloyBlock;

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
    public static final BlockWaterPump500ZF WATER_PUMP_500ZF = new BlockWaterPump500ZF();
    public static final BlockWaterPipe WATER_PIPE = new BlockWaterPipe();
    public static final TitaniumAlloyBlock TITANIUM_ALLOY_BLOCK = new TitaniumAlloyBlock();
    
    // 高级发电机
    public static final BlockAdvancedGeneratorTier1 ADVANCED_GENERATOR_TIER1 = new BlockAdvancedGeneratorTier1();
    public static final BlockAdvancedGeneratorTier2 ADVANCED_GENERATOR_TIER2 = new BlockAdvancedGeneratorTier2();
    public static final BlockAdvancedGeneratorTier3 ADVANCED_GENERATOR_TIER3 = new BlockAdvancedGeneratorTier3();
    public static final BlockAdvancedGeneratorTier4 ADVANCED_GENERATOR_TIER4 = new BlockAdvancedGeneratorTier4();
    public static final BlockAdvancedGeneratorTier5 ADVANCED_GENERATOR_TIER5 = new BlockAdvancedGeneratorTier5();
    public static final BlockAdvancedGeneratorTier6 ADVANCED_GENERATOR_TIER6 = new BlockAdvancedGeneratorTier6();
    public static final BlockAdvancedGeneratorTier7 ADVANCED_GENERATOR_TIER7 = new BlockAdvancedGeneratorTier7();
    public static final BlockAdvancedGeneratorTier8 ADVANCED_GENERATOR_TIER8 = new BlockAdvancedGeneratorTier8();


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
        event.getRegistry().register(WATER_PUMP_500ZF);
        event.getRegistry().register(WATER_PIPE);
        event.getRegistry().register(TITANIUM_ALLOY_BLOCK);
        
        // 注册高级发电机
        event.getRegistry().register(ADVANCED_GENERATOR_TIER1);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER2);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER3);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER4);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER5);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER6);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER7);
        event.getRegistry().register(ADVANCED_GENERATOR_TIER8);

    }
}