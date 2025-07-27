package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.ItemHoe;
import static com.cac.mpn.item.RegisterItem.DATA_TOOL_MATERIAL;

public class DataIngotHoe extends ItemHoe {
    
    public DataIngotHoe() {
        super(DATA_TOOL_MATERIAL);
        setRegistryName("data_ingot_hoe");
        setUnlocalizedName("data_ingot_hoe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 