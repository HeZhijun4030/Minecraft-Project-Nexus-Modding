package com.cac.mpn.item.Item_Swords;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import static com.cac.mpn.item.RegisterItem.TITANIUM_SWORD_MATERIAL;

public class Titanium_sword extends ItemSword {
    public Titanium_sword() {
        super(TITANIUM_SWORD_MATERIAL);
        setRegistryName("titanium_sword");
        setUnlocalizedName("titanium_sword");
        setCreativeTab(ModTabs.MPN_TAB);
    }
}
