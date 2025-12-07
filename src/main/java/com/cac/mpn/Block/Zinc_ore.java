package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Zinc_ore extends Block {
    public Zinc_ore()
    {
        super(Material.ROCK);
        this.setUnlocalizedName("zinc_ore");
        this.setRegistryName("zinc_ore");
        this.setHardness(3.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
}
