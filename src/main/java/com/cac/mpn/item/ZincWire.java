package com.cac.mpn.item;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;

public class ZincWire extends Item {
    public ZincWire() {
        // 原注册名与方块 BlockZincWire 冲突，改为独立物品名避免 ForgeRegistry.sync 崩溃
        this.setUnlocalizedName("zinc_wire_item");
        this.setRegistryName("zinc_wire_item");
        this.setMaxStackSize(64);
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 