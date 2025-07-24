package com.cac.mpn.item.Item_Bow;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.ItemBow;

public class DataIngotBow extends ItemBow {
    public DataIngotBow() {
        super();
        setUnlocalizedName("data_ingot_bow");
        setRegistryName("data_ingot_bow");
        setCreativeTab(ModTabs.MPN_TAB);
        this.setMaxDamage(4096); // 极高耐久
        this.setFull3D();
    }
    // 可在此重写onPlayerStoppedUsing等方法以提升射速和伤害（如需进一步自定义可补充）
} 