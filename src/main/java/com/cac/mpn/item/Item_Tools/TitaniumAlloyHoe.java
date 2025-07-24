package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemHoe;

public class TitaniumAlloyHoe extends ItemHoe {
    public TitaniumAlloyHoe() {
        super(RegisterItem.TITANIUM_ALLOY_TOOL_MATERIAL);
        setUnlocalizedName("titanium_alloy_hoe");
        setRegistryName("titanium_alloy_hoe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 