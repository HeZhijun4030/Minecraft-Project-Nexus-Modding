package com.cac.mpn.item;

import com.cac.mpn.item.Item_Swords.DataKnife;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

// 定义一个名为 RegisterItem 的类，用于注册游戏中的物品
public class RegisterItem {

    // 定义一个静态的 DataKnife 实例
    public static final DataKnife DATA_KNIFE = new DataKnife();

    // 在物品注册事件中注册 DataKnife 实例
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(DATA_KNIFE);
    }
}
