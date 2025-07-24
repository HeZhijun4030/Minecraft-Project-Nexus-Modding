package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemAxe;

public class DataIngotAxe extends ItemAxe {
    public DataIngotAxe() {
        super(RegisterItem.DATA_INGOT_TOOL_MATERIAL, 12.0F, -2.8F);
        setUnlocalizedName("data_ingot_axe");
        setRegistryName("data_ingot_axe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 