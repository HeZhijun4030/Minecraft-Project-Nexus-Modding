package com.cac.mpn.item.Item_Bow;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.ItemArrow;

public class DataIngotArrow extends ItemArrow {
    public DataIngotArrow() {
        super();
        setUnlocalizedName("data_ingot_arrow");
        setRegistryName("data_ingot_arrow");
        setCreativeTab(ModTabs.MPN_TAB);
        this.setMaxStackSize(64);
    }
    // 可在此重写createArrow等方法以提升伤害（如需进一步自定义可补充）
} 