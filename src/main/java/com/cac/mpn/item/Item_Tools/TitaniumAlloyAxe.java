package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemAxe;

public class TitaniumAlloyAxe extends ItemAxe {
    public TitaniumAlloyAxe() {
        super(RegisterItem.TITANIUM_ALLOY_TOOL_MATERIAL, 9.0F, -3.0F);
        setUnlocalizedName("titanium_alloy_axe");
        setRegistryName("titanium_alloy_axe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 