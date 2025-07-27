package com.cac.mpn.item;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;

public class TinIngot extends Item {
    public TinIngot() {
        this.setUnlocalizedName("tin_ingot");
        this.setRegistryName("tin_ingot");
        this.setMaxStackSize(64);
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 