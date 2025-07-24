package com.cac.mpn.item;

import com.cac.mpn.Block.RegisterBlock;
import com.cac.mpn.item.Item_Swords.*;
import com.cac.mpn.Block.BlockZincWire;
import com.cac.mpn.Block.BlockElectricFurnace;
import com.cac.mpn.item.CopperIngot;
import com.cac.mpn.item.ZincIngot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.item.ItemArmor;
import net.minecraft.init.SoundEvents;

import java.util.Objects;

@Mod.EventBusSubscriber
public class RegisterItem {
    public static final Item.ToolMaterial DATA_KNIFE_MATERIAL = EnumHelper.addToolMaterial("DATA", 1, 2048, 1.0F, 45.0F, 10);
    public static final Item.ToolMaterial TITANIUM_SWORD_MATERIAL = EnumHelper.addToolMaterial("TITANIUM", 1, 1024, 1.6F, 12.0F, 10);
    public static final ItemBlock ITEM_SPECTRAL_SOLAR = new ItemBlock(RegisterBlock.SPECTRAL_SOLAR);
    public static final ItemBlock ITEM_TITANIUM = new ItemBlock(RegisterBlock.TITANIUM);
    public static final ItemBlock ITEM_ELECTRONIC_SOLAR = new ItemBlock(RegisterBlock.ELECTRONIC_SOLAR);
    public static final ItemBlock ITEM_SINGULAR_SOLAR = new ItemBlock(RegisterBlock.SINGULAR_SOLAR);
    public static final ItemBlock ITEM_STEAM_GENERATOR = new ItemBlock(RegisterBlock.STEAM_GENERATOR);
    public static final ItemBlock ITEM_ZINC_WIRE = new ItemBlock(RegisterBlock.BLOCK_ZINC_WIRE);
    public static final ItemBlock ITEM_ELECTRIC_FURNACE = new ItemBlock(RegisterBlock.BLOCK_ELECTRIC_FURNACE);
    public static final ItemBlock ITEM_COPPER = new ItemBlock(RegisterBlock.COPPER);
    public static final ItemBlock ITEM_ZINC = new ItemBlock(RegisterBlock.ZINC);
    public static final ItemBlock ITEM_ALLOY_MACHINE = new ItemBlock(RegisterBlock.ALLOY_MACHINE);
    public static final ItemBlock ITEM_COPPER_CABLE = new ItemBlock(RegisterBlock.BLOCK_COPPER_CABLE);
    public static final CopperIngot COPPER_INGOT = new CopperIngot();
    public static final ZincIngot ZINC_INGOT = new ZincIngot();
    public static final DataKnife DATA_KNIFE = new DataKnife();
    public static final Titanium_sword TITANIUM_SWORD = new Titanium_sword();
    public static final Titanium_ingot TITANIUM_INGOT = new Titanium_ingot();
    public static final Data_ingot DATA_INGOT = new Data_ingot();
    public static final ZincPlate ZINC_PLATE = new ZincPlate();
    public static final AluminumPlate ALUMINUM_PLATE = new AluminumPlate();
    public static final CopperPlate COPPER_PLATE = new CopperPlate();
    public static final ItemPrimaryBattery PRIMARY_BATTERY = new ItemPrimaryBattery();
    public static final Hammer HAMMER = new Hammer();
    public static final CircuitBoard CIRCUIT_BOARD = new CircuitBoard();
    public static final HydraulicShears HYDRAULIC_SHEARS = new HydraulicShears();
    public static final BasicCircuitCore BASIC_CIRCUIT_CORE = new BasicCircuitCore();
    public static final CopperWire COPPER_WIRE = new CopperWire();
    public static final TinWire TIN_WIRE = new TinWire();
    public static final BasicIronShell BASIC_IRON_SHELL = new BasicIronShell();
    public static final TitaniumAlloyIngot TITANIUM_ALLOY_INGOT = new TitaniumAlloyIngot();

    // 盔甲实例
    public static ItemArmor TITANIUM_HELMET;
    public static ItemArmor TITANIUM_CHESTPLATE;
    public static ItemArmor TITANIUM_LEGGINGS;
    public static ItemArmor TITANIUM_BOOTS;
    public static ItemArmor TITANIUM_ALLOY_HELMET;
    public static ItemArmor TITANIUM_ALLOY_CHESTPLATE;
    public static ItemArmor TITANIUM_ALLOY_LEGGINGS;
    public static ItemArmor TITANIUM_ALLOY_BOOTS;
    public static ItemArmor DATA_INGOT_HELMET;
    public static ItemArmor DATA_INGOT_CHESTPLATE;
    public static ItemArmor DATA_INGOT_LEGGINGS;
    public static ItemArmor DATA_INGOT_BOOTS;
    // 工具实例
    public static Item TITANIUM_PICKAXE;
    public static Item TITANIUM_AXE;
    public static Item TITANIUM_SHOVEL;
    public static Item TITANIUM_HOE;
    public static Item TITANIUM_ALLOY_PICKAXE;
    public static Item TITANIUM_ALLOY_AXE;
    public static Item TITANIUM_ALLOY_SHOVEL;
    public static Item TITANIUM_ALLOY_HOE;
    public static Item DATA_INGOT_PICKAXE;
    public static Item DATA_INGOT_AXE;
    public static Item DATA_INGOT_SHOVEL;
    public static Item DATA_INGOT_HOE;
    public static Item DATA_INGOT_BOW;
    public static Item DATA_INGOT_ARROW;

    // 盔甲材质
    public static final ItemArmor.ArmorMaterial TITANIUM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("TITANIUM", "mpn:titanium", 20, new int[]{3, 6, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static final ItemArmor.ArmorMaterial TITANIUM_ALLOY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("TITANIUM_ALLOY", "mpn:titanium_alloy", 35, new int[]{3, 7, 6, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial DATA_INGOT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("DATA_INGOT", "mpn:data_ingot", 80, new int[]{4, 9, 8, 5}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);

    // 工具材质
    public static final Item.ToolMaterial TITANIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial("TITANIUM", 2, 600, 7.0F, 2.5F, 12);
    public static final Item.ToolMaterial TITANIUM_ALLOY_TOOL_MATERIAL = EnumHelper.addToolMaterial("TITANIUM_ALLOY", 3, 1800, 9.0F, 3.5F, 18);
    public static final Item.ToolMaterial DATA_INGOT_TOOL_MATERIAL = EnumHelper.addToolMaterial("DATA_INGOT", 4, 4096, 12.0F, 5.0F, 25);


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(DATA_KNIFE);
        registry.register(TITANIUM_SWORD);
        registry.register(TITANIUM_INGOT);
        registry.register(DATA_INGOT);
        registerItemBlock(registry, ITEM_SPECTRAL_SOLAR);
        registerItemBlock(registry, ITEM_TITANIUM);
        registerItemBlock(registry, ITEM_ELECTRONIC_SOLAR);
        registerItemBlock(registry, ITEM_SINGULAR_SOLAR);
        registerItemBlock(registry, ITEM_STEAM_GENERATOR);
        registerItemBlock(registry, ITEM_ZINC_WIRE);
        registerItemBlock(registry, ITEM_ELECTRIC_FURNACE);
        registerItemBlock(registry, ITEM_COPPER);
        registerItemBlock(registry, ITEM_ZINC);
        registerItemBlock(registry, ITEM_ALLOY_MACHINE);
        registerItemBlock(registry, ITEM_COPPER_CABLE);
        registry.register(COPPER_WIRE);
        registry.register(COPPER_INGOT);
        registry.register(ZINC_INGOT);
        registry.register(ZINC_PLATE);
        registry.register(ALUMINUM_PLATE);
        registry.register(COPPER_PLATE);
        registry.register(PRIMARY_BATTERY);
        registry.register(HAMMER);
        registry.register(CIRCUIT_BOARD);
        registry.register(HYDRAULIC_SHEARS);
        registry.register(BASIC_CIRCUIT_CORE);
        registry.register(TIN_WIRE);
        registry.register(BASIC_IRON_SHELL);
        registry.register(TITANIUM_ALLOY_INGOT);
        // 盔甲实例化
        TITANIUM_HELMET = new com.cac.mpn.item.Armor.TitaniumArmor.Helmet();
        TITANIUM_CHESTPLATE = new com.cac.mpn.item.Armor.TitaniumArmor.Chestplate();
        TITANIUM_LEGGINGS = new com.cac.mpn.item.Armor.TitaniumArmor.Leggings();
        TITANIUM_BOOTS = new com.cac.mpn.item.Armor.TitaniumArmor.Boots();
        TITANIUM_ALLOY_HELMET = new com.cac.mpn.item.Armor.TitaniumAlloyArmor.Helmet();
        TITANIUM_ALLOY_CHESTPLATE = new com.cac.mpn.item.Armor.TitaniumAlloyArmor.Chestplate();
        TITANIUM_ALLOY_LEGGINGS = new com.cac.mpn.item.Armor.TitaniumAlloyArmor.Leggings();
        TITANIUM_ALLOY_BOOTS = new com.cac.mpn.item.Armor.TitaniumAlloyArmor.Boots();
        DATA_INGOT_HELMET = new com.cac.mpn.item.Armor.DataIngotArmor.Helmet();
        DATA_INGOT_CHESTPLATE = new com.cac.mpn.item.Armor.DataIngotArmor.Chestplate();
        DATA_INGOT_LEGGINGS = new com.cac.mpn.item.Armor.DataIngotArmor.Leggings();
        DATA_INGOT_BOOTS = new com.cac.mpn.item.Armor.DataIngotArmor.Boots();
        // 工具实例化
        TITANIUM_PICKAXE = new com.cac.mpn.item.Item_Tools.TitaniumPickaxe();
        TITANIUM_AXE = new com.cac.mpn.item.Item_Tools.TitaniumAxe();
        TITANIUM_SHOVEL = new com.cac.mpn.item.Item_Tools.TitaniumShovel();
        TITANIUM_HOE = new com.cac.mpn.item.Item_Tools.TitaniumHoe();
        TITANIUM_ALLOY_PICKAXE = new com.cac.mpn.item.Item_Tools.TitaniumAlloyPickaxe();
        TITANIUM_ALLOY_AXE = new com.cac.mpn.item.Item_Tools.TitaniumAlloyAxe();
        TITANIUM_ALLOY_SHOVEL = new com.cac.mpn.item.Item_Tools.TitaniumAlloyShovel();
        TITANIUM_ALLOY_HOE = new com.cac.mpn.item.Item_Tools.TitaniumAlloyHoe();
        DATA_INGOT_PICKAXE = new com.cac.mpn.item.Item_Tools.DataIngotPickaxe();
        DATA_INGOT_AXE = new com.cac.mpn.item.Item_Tools.DataIngotAxe();
        DATA_INGOT_SHOVEL = new com.cac.mpn.item.Item_Tools.DataIngotShovel();
        DATA_INGOT_HOE = new com.cac.mpn.item.Item_Tools.DataIngotHoe();
        // 数据锭弓箭实例化
        DATA_INGOT_BOW = new com.cac.mpn.item.Item_Bow.DataIngotBow();
        DATA_INGOT_ARROW = new com.cac.mpn.item.Item_Bow.DataIngotArrow();
        // 注册盔甲
        registry.register(TITANIUM_HELMET);
        registry.register(TITANIUM_CHESTPLATE);
        registry.register(TITANIUM_LEGGINGS);
        registry.register(TITANIUM_BOOTS);
        registry.register(TITANIUM_ALLOY_HELMET);
        registry.register(TITANIUM_ALLOY_CHESTPLATE);
        registry.register(TITANIUM_ALLOY_LEGGINGS);
        registry.register(TITANIUM_ALLOY_BOOTS);
        registry.register(DATA_INGOT_HELMET);
        registry.register(DATA_INGOT_CHESTPLATE);
        registry.register(DATA_INGOT_LEGGINGS);
        registry.register(DATA_INGOT_BOOTS);
        // 注册工具
        registry.register(TITANIUM_PICKAXE);
        registry.register(TITANIUM_AXE);
        registry.register(TITANIUM_SHOVEL);
        registry.register(TITANIUM_HOE);
        registry.register(TITANIUM_ALLOY_PICKAXE);
        registry.register(TITANIUM_ALLOY_AXE);
        registry.register(TITANIUM_ALLOY_SHOVEL);
        registry.register(TITANIUM_ALLOY_HOE);
        registry.register(DATA_INGOT_PICKAXE);
        registry.register(DATA_INGOT_AXE);
        registry.register(DATA_INGOT_SHOVEL);
        registry.register(DATA_INGOT_HOE);
        // 注册数据锭弓箭
        registry.register(DATA_INGOT_BOW);
        registry.register(DATA_INGOT_ARROW);
    }

    private static void registerItemBlock(IForgeRegistry<Item> registry, ItemBlock itemBlock) {
        itemBlock.setRegistryName(Objects.requireNonNull(itemBlock.getBlock().getRegistryName()));
        registry.register(itemBlock);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(DATA_KNIFE);
        registerModel(TITANIUM_INGOT);
        registerModel(ITEM_TITANIUM);
        registerModel(TITANIUM_SWORD);
        registerModel(ITEM_SPECTRAL_SOLAR);
        registerModel(ITEM_ELECTRONIC_SOLAR);
        registerModel(ITEM_SINGULAR_SOLAR);
        registerModel(DATA_INGOT);
        registerModel(ITEM_STEAM_GENERATOR);
        registerModel(ITEM_ZINC_WIRE);
        registerModel(ITEM_ELECTRIC_FURNACE);
        registerModel(ZINC_PLATE);
        registerModel(ALUMINUM_PLATE);
        registerModel(COPPER_PLATE);
        registerModel(PRIMARY_BATTERY);
        registerModel(HAMMER);
        registerModel(CIRCUIT_BOARD);
        registerModel(HYDRAULIC_SHEARS);
        registerModel(BASIC_CIRCUIT_CORE);
        registerModel(COPPER_WIRE);
        registerModel(TIN_WIRE);
        registerModel(BASIC_IRON_SHELL);
        registerModel(ITEM_ALLOY_MACHINE);
        registerModel(TITANIUM_ALLOY_INGOT);
        registerModel(ITEM_COPPER_CABLE);
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }
}