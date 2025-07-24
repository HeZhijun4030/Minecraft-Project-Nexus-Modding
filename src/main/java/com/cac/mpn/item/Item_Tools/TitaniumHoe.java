package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemHoe;

public class TitaniumHoe extends ItemHoe {
    public TitaniumHoe() {
        super(RegisterItem.TITANIUM_TOOL_MATERIAL);
        setUnlocalizedName("titanium_hoe");
        setRegistryName("titanium_hoe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 