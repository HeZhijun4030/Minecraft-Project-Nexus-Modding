package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemSpade;

public class DataIngotShovel extends ItemSpade {
    public DataIngotShovel() {
        super(RegisterItem.DATA_INGOT_TOOL_MATERIAL);
        setUnlocalizedName("data_ingot_shovel");
        setRegistryName("data_ingot_shovel");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 