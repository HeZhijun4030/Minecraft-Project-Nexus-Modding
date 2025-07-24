package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemAxe;

public class TitaniumAxe extends ItemAxe {
    public TitaniumAxe() {
        super(RegisterItem.TITANIUM_TOOL_MATERIAL, 8.0F, -3.1F);
        setUnlocalizedName("titanium_axe");
        setRegistryName("titanium_axe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 