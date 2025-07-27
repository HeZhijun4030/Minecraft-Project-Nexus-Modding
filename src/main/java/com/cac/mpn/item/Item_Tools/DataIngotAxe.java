package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.ItemAxe;
import static com.cac.mpn.item.RegisterItem.DATA_TOOL_MATERIAL;

public class DataIngotAxe extends ItemAxe {
    
    public DataIngotAxe() {
        super(DATA_TOOL_MATERIAL, 12.0F, -3.0F);
        setRegistryName("data_ingot_axe");
        setUnlocalizedName("data_ingot_axe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 