package com.cac.mpn.item;

import com.cac.mpn.Block.RegisterBlock;
import com.cac.mpn.item.Item_Swords.*;
import com.cac.mpn.Block.BlockZincWire;
import com.cac.mpn.Block.BlockElectricFurnace;
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
    public static final DataKnife DATA_KNIFE = new DataKnife();
    public static final Titanium_sword TITANIUM_SWORD = new Titanium_sword();
    public static final Titanium_ingot TITANIUM_INGOT = new Titanium_ingot();
    public static final Data_ingot DATA_INGOT = new Data_ingot();



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
    }

    private static void registerItemBlock(IForgeRegistry<Item> registry, ItemBlock itemBlock) {
        itemBlock.setRegistryName(itemBlock.getBlock().getRegistryName());
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
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }
}