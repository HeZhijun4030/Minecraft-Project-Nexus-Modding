package com.cac.mpn.Block;
import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Zinc extends Block {
    public Zinc() {
        super(Material.IRON);
        this.setUnlocalizedName("zinc_ore");
        this.setRegistryName("zinc_ore");
        this.setHardness(4.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
        this.setHarvestLevel("pickaxe", 2);
    }
} 