package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemPickaxe;

public class DataIngotPickaxe extends ItemPickaxe {
    public DataIngotPickaxe() {
        super(RegisterItem.DATA_INGOT_TOOL_MATERIAL);
        setUnlocalizedName("data_ingot_pickaxe");
        setRegistryName("data_ingot_pickaxe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 