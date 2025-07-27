package com.cac.mpn.item;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;

public class ZincWire extends Item {
    public ZincWire() {
        this.setUnlocalizedName("zinc_wire");
        this.setRegistryName("zinc_wire");
        this.setMaxStackSize(64);
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 