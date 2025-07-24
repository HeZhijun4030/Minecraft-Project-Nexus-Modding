package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemSpade;

public class TitaniumShovel extends ItemSpade {
    public TitaniumShovel() {
        super(RegisterItem.TITANIUM_TOOL_MATERIAL);
        setUnlocalizedName("titanium_shovel");
        setRegistryName("titanium_shovel");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 