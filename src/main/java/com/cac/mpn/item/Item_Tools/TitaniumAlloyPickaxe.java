package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemPickaxe;

public class TitaniumAlloyPickaxe extends ItemPickaxe {
    public TitaniumAlloyPickaxe() {
        super(RegisterItem.TITANIUM_ALLOY_TOOL_MATERIAL);
        setUnlocalizedName("titanium_alloy_pickaxe");
        setRegistryName("titanium_alloy_pickaxe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 