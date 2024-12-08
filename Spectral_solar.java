package com.cac.mpn.Block;


import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Spectral_solar extends Block {
    public Spectral_solar()
    {
        super(Material.IRON);
        this.setUnlocalizedName("spectral_solar");
        this.setRegistryName("spectral_solar");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
}
