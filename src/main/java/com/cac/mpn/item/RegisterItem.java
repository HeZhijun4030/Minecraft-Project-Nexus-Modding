package com.cac.mpn.item;

import com.cac.mpn.item.Item_Swords.DataKnife;
import com.cac.mpn.item.Item_Swords.Titanium_ingot;
import com.cac.mpn.item.Item_Swords.Titanium_sword;
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

import static com.cac.mpn.Block.RegisterBlock.*;

@Mod.EventBusSubscriber
public class RegisterItem {

    public static final ItemBlock ITEM_SPECTRAL_SOLAR = new ItemBlock(SPECTRAL_SOLAR);
    public static final ItemBlock ITEM_TITANIUM = new ItemBlock(TITANIUM);
    public static final ItemBlock ITEM_ELECTRONIC_SOLAR = new ItemBlock(ELECTRONIC_SOLAR);
    public static final ItemBlock ITEM_SINGULAR_SOLAR = new ItemBlock(SINGULAR_SOLAR);
    public static final DataKnife DATA_KNIFE = new DataKnife();
    public static final Titanium_sword TITANIUM_SWORD = new Titanium_sword();
    public static final Titanium_ingot TITANIUM_INGOT = new Titanium_ingot();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(DATA_KNIFE);
        registry.register(TITANIUM_SWORD);
        registry.register(TITANIUM_INGOT);
        ITEM_SPECTRAL_SOLAR.setRegistryName(ITEM_SPECTRAL_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SPECTRAL_SOLAR);
        ITEM_TITANIUM.setRegistryName(ITEM_TITANIUM.getBlock().getRegistryName());
        registry.register(ITEM_TITANIUM);
        ITEM_ELECTRONIC_SOLAR.setRegistryName(ITEM_ELECTRONIC_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_ELECTRONIC_SOLAR);
        ITEM_SINGULAR_SOLAR.setRegistryName(ITEM_SINGULAR_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SINGULAR_SOLAR);
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
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }

}
