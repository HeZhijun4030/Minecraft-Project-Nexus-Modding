package com.cac.mpn.item;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;

public class AluminumIngot extends Item {
    public AluminumIngot() {
        this.setUnlocalizedName("aluminum_ingot");
        this.setRegistryName("aluminum_ingot");
        this.setMaxStackSize(64);
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 