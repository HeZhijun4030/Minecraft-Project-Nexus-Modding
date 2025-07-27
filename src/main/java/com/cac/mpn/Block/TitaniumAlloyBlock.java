package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TitaniumAlloyBlock extends Block {
    public TitaniumAlloyBlock() {
        super(Material.IRON);
        this.setUnlocalizedName("titanium_alloy_block");
        this.setRegistryName("titanium_alloy_block");
        this.setHardness(8.0F);
        this.setResistance(20.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
        this.setHarvestLevel("pickaxe", 3);
    }
} 