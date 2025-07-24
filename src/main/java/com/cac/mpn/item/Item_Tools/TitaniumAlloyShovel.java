package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemSpade;

public class TitaniumAlloyShovel extends ItemSpade {
    public TitaniumAlloyShovel() {
        super(RegisterItem.TITANIUM_ALLOY_TOOL_MATERIAL);
        setUnlocalizedName("titanium_alloy_shovel");
        setRegistryName("titanium_alloy_shovel");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 