package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemHoe;

public class DataIngotHoe extends ItemHoe {
    public DataIngotHoe() {
        super(RegisterItem.DATA_INGOT_TOOL_MATERIAL);
        setUnlocalizedName("data_ingot_hoe");
        setRegistryName("data_ingot_hoe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 