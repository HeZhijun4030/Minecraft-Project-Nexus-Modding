package com.cac.mpn.item;

import com.cac.mpn.item.Item_Swords.DataKnife;
import com.cac.mpn.item.Item_Swords.Data_ingot;
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
    public static final Item.ToolMaterial DATA_KNIFE_MATERIAL = EnumHelper.addToolMaterial("DATA", 1, 2048, 1.0F, 45.0F, 10);
    public static final Item.ToolMaterial TITANIUM_SWORD_MATERIAL = EnumHelper.addToolMaterial("TITANIUM", 1, 1024, 1.6F, 12.0F, 10);
    public static final ItemBlock ITEM_SPECTRAL_SOLAR = new ItemBlock(SPECTRAL_SOLAR);
    public static final ItemBlock ITEM_II_SOLAR = new ItemBlock(II_SOLAR);
    public static final ItemBlock ITEM_III_SOLAR = new ItemBlock(III_SOLAR);
    public static final ItemBlock ITEM_IV_SOLAR = new ItemBlock(IV_SOLAR);
    public static final ItemBlock ITEM_V_SOLAR = new ItemBlock(V_SOLAR);
    public static final ItemBlock ITEM_VI_SOLAR = new ItemBlock(VI_SOLAR);
    public static final ItemBlock ITEM_VII_SOLAR = new ItemBlock(VII_SOLAR);
    public static final ItemBlock ITEM_ATOMIC_SOLAR = new ItemBlock(ATOMIC_SOLAR);
    public static final ItemBlock ITEM_PROTON_SOLAR = new ItemBlock(PROTON_SOLAR);
    public static final ItemBlock ITEM_NEUTRON_SOLAR = new ItemBlock(NEUTRON_SOLAR);
    public static final ItemBlock ITEM_QUARK_SOLAR = new ItemBlock(QUARK_SOLAR);
    public static final ItemBlock ITEM_PLANCK_SOLAR = new ItemBlock(PLANCK_SOLAR);
    public static final ItemBlock ITEM_VOID_SOLAR = new ItemBlock(VOID_SOLAR);
    public static final ItemBlock ITEM_TITANIUM = new ItemBlock(TITANIUM);
    public static final ItemBlock ITEM_ELECTRONIC_SOLAR = new ItemBlock(ELECTRONIC_SOLAR);
    public static final ItemBlock ITEM_SINGULAR_SOLAR = new ItemBlock(SINGULAR_SOLAR);
    public static final ItemBlock ITEM_COPPER_ORE = new ItemBlock(COPPER_ORE);
    public static final ItemBlock ITEM_ZINC_ORE = new ItemBlock(ZINC_ORE);
    public static final ItemBlock ITEM_TIN_ORE = new ItemBlock(TIN_ORE);
    public static final DataKnife DATA_KNIFE = new DataKnife();
    public static final Titanium_sword TITANIUM_SWORD = new Titanium_sword();
    public static final Titanium_ingot TITANIUM_INGOT = new Titanium_ingot();
    public static final Data_ingot DATA_INGOT = new Data_ingot();
    public static final ItemBlock ITEM_I_SOLAR = new ItemBlock(I_SOLAR);
    public static final Copper_ingot COPPER_INGOT = new Copper_ingot();
    public static final Zinc_ingot ZINC_INGOT = new Zinc_ingot();
    public static final Tin_ingot TIN_INGOT = new Tin_ingot();
    public static final ItemBlock ITEM_ELECTROLYZER = new ItemBlock(ELECTROLYZER);
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        ITEM_ELECTROLYZER.setRegistryName(ITEM_ELECTROLYZER.getBlock().getRegistryName());
        registry.register(ITEM_ELECTROLYZER);
        registry.register(DATA_KNIFE);
        registry.register(TITANIUM_SWORD);
        registry.register(TITANIUM_INGOT);
        registry.register(DATA_INGOT);
        registry.register(ZINC_INGOT);
        registry.register(TIN_INGOT);
        registry.register(COPPER_INGOT);
        ITEM_SPECTRAL_SOLAR.setRegistryName(ITEM_SPECTRAL_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SPECTRAL_SOLAR);
        ITEM_II_SOLAR.setRegistryName(ITEM_II_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_II_SOLAR);
        ITEM_III_SOLAR.setRegistryName(ITEM_III_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_III_SOLAR);
        ITEM_IV_SOLAR.setRegistryName(ITEM_IV_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_IV_SOLAR);
        ITEM_V_SOLAR.setRegistryName(ITEM_V_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_V_SOLAR);
        ITEM_VI_SOLAR.setRegistryName(ITEM_VI_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_VI_SOLAR);
        ITEM_VII_SOLAR.setRegistryName(ITEM_VII_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_VII_SOLAR);
        ITEM_ATOMIC_SOLAR.setRegistryName(ITEM_ATOMIC_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_ATOMIC_SOLAR);
        ITEM_PROTON_SOLAR.setRegistryName(ITEM_PROTON_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_PROTON_SOLAR);
        ITEM_NEUTRON_SOLAR.setRegistryName(ITEM_NEUTRON_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_NEUTRON_SOLAR);
        ITEM_QUARK_SOLAR.setRegistryName(ITEM_QUARK_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_QUARK_SOLAR);
        ITEM_PLANCK_SOLAR.setRegistryName(ITEM_PLANCK_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_PLANCK_SOLAR);
        ITEM_VOID_SOLAR.setRegistryName(ITEM_VOID_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_VOID_SOLAR);
        ITEM_TITANIUM.setRegistryName(ITEM_TITANIUM.getBlock().getRegistryName());
        registry.register(ITEM_TITANIUM);
        ITEM_ELECTRONIC_SOLAR.setRegistryName(ITEM_ELECTRONIC_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_ELECTRONIC_SOLAR);
        ITEM_SINGULAR_SOLAR.setRegistryName(ITEM_SINGULAR_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SINGULAR_SOLAR);
        ITEM_COPPER_ORE.setRegistryName(ITEM_COPPER_ORE.getBlock().getRegistryName());
        registry.register(ITEM_COPPER_ORE);
        ITEM_ZINC_ORE.setRegistryName(ITEM_ZINC_ORE.getBlock().getRegistryName());
        registry.register(ITEM_ZINC_ORE);
        ITEM_TIN_ORE.setRegistryName(ITEM_TIN_ORE.getBlock().getRegistryName());
        registry.register(ITEM_TIN_ORE);
        ITEM_I_SOLAR.setRegistryName(ITEM_I_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_I_SOLAR);
    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(DATA_KNIFE);
        registerModel(TITANIUM_INGOT);
        registerModel(ITEM_TITANIUM);
        registerModel(TITANIUM_SWORD);
        registerModel(ITEM_SPECTRAL_SOLAR);
        registerModel(ITEM_II_SOLAR);
        registerModel(ITEM_III_SOLAR);
        registerModel(ITEM_IV_SOLAR);
        registerModel(ITEM_V_SOLAR);
        registerModel(ITEM_VI_SOLAR);
        registerModel(ITEM_VII_SOLAR);
        registerModel(ITEM_ATOMIC_SOLAR);
        registerModel(ITEM_PROTON_SOLAR);
        registerModel(ITEM_NEUTRON_SOLAR);
        registerModel(ITEM_QUARK_SOLAR);
        registerModel(ITEM_PLANCK_SOLAR);
        registerModel(ITEM_VOID_SOLAR);
        registerModel(ITEM_ELECTRONIC_SOLAR);
        registerModel(ITEM_SINGULAR_SOLAR);
        registerModel(DATA_INGOT);
        registerModel(ITEM_COPPER_ORE);
        registerModel(ITEM_ELECTROLYZER);
        registerModel(ITEM_ZINC_ORE);
        registerModel(ITEM_TIN_ORE);
        registerModel(ITEM_I_SOLAR);
        registerModel(COPPER_INGOT);
        registerModel(ZINC_INGOT);
        registerModel(TIN_INGOT);
    }
    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }

}
