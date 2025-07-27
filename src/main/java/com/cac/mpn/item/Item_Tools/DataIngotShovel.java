package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.ItemSpade;
import static com.cac.mpn.item.RegisterItem.DATA_TOOL_MATERIAL;

public class DataIngotShovel extends ItemSpade {
    
    public DataIngotShovel() {
        super(DATA_TOOL_MATERIAL);
        setRegistryName("data_ingot_shovel");
        setUnlocalizedName("data_ingot_shovel");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 