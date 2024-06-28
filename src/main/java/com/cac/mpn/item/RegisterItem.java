package com.cac.mpn.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
class RegisterItem {


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item().setRegistryName("data_knife").setCreativeTab(ModTabs.MPN_TAB).setUnlocalizedName("data_knife"));
        //第一个物品，暂时未添加贴图
    }

}