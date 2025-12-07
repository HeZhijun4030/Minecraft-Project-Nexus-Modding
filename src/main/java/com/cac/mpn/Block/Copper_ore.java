package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Copper_ore extends Block {
    public Copper_ore()
    {
        super(Material.ROCK);
        this.setUnlocalizedName("copper_ore");
        this.setRegistryName("copper_ore");
        this.setHardness(3.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
}
