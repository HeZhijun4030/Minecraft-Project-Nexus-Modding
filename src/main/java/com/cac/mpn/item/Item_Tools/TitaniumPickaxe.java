package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.ItemPickaxe;

public class TitaniumPickaxe extends ItemPickaxe {
    public TitaniumPickaxe() {
        super(RegisterItem.TITANIUM_TOOL_MATERIAL);
        setUnlocalizedName("titanium_pickaxe");
        setRegistryName("titanium_pickaxe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 