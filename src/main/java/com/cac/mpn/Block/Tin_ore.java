package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Tin_ore extends Block {
    public Tin_ore()
    {
        super(Material.ROCK);
        this.setUnlocalizedName("tin_ore");
        this.setRegistryName("tin_ore");
        this.setHardness(3.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
}
