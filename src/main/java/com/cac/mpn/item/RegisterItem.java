package com.cac.mpn.item;

import com.cac.mpn.item.Item_Swords.DataKnife;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.cac.mpn.Block.RegisterBlock.SPECTRAL_SOLAR;


@Mod.EventBusSubscriber
public class RegisterItem {



    public static final ItemBlock ITEM_SPECRAL_SOLAR = new ItemBlock(SPECTRAL_SOLAR);
    public static final DataKnife DATA_KNIFE = new DataKnife();
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(DATA_KNIFE);
        ITEM_SPECRAL_SOLAR.setRegistryName(ITEM_SPECRAL_SOLAR.getBlock().getRegistryName());
        registry.register(ITEM_SPECRAL_SOLAR);

    }

}