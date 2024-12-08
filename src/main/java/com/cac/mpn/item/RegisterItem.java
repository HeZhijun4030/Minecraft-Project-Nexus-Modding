package com.cac.mpn.item;

import com.cac.mpn.item.Item_Swords.DataKnife;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
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
    public static final ItemBlock ITEM_ELECTRONIC_SOLAR = new ItemBlock(ELECTRONIC_SOLAR);
    public static final DataKnife DATA_KNIFE = new DataKnife();
    public static final ItemBlock ITEM_SINGULAR_SOLAR = new ItemBlock(SINGULAR_SOLAR);
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(DATA_KNIFE);
        ITEM_SPECTRAL_SOLAR.setRegistryName(ITEM_SPECTRAL_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SPECTRAL_SOLAR);
        ITEM_ELECTRONIC_SOLAR.setRegistryName(ITEM_ELECTRONIC_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_ELECTRONIC_SOLAR);
        ITEM_SINGULAR_SOLAR.setRegistryName(ITEM_SINGULAR_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SINGULAR_SOLAR);

    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(DATA_KNIFE, 0,
                new ModelResourceLocation(DATA_KNIFE.getRegistryName(), "inventory"));
    }

}