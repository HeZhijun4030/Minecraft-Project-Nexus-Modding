package com.cac.mpn.Block;
import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Copper extends Block {
    public Copper() {
        super(Material.IRON);
        this.setUnlocalizedName("copper");
        this.setRegistryName("copper");
        this.setHardness(4.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
        this.setHarvestLevel("pickaxe", 2);
    }
} 