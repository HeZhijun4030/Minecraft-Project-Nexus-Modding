package com.cac.mpn.item.Item_Swords;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class Titanium_sword extends ItemSword {
    public Titanium_sword(ToolMaterial TITANIUM_SWORD_MATERIAL) {
        super(TITANIUM_SWORD_MATERIAL);
        setRegistryName("titanium_sword");
        setUnlocalizedName("titanium_sword");
        setCreativeTab(ModTabs.MPN_TAB);
    }
}
