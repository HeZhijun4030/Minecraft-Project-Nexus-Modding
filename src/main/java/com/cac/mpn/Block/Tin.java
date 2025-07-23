package com.cac.mpn.Block;
import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Tin extends Block {
    public Tin() {
        super(Material.IRON);
        this.setUnlocalizedName("tin_ore");
        this.setRegistryName("tin_ore");
        this.setHardness(4.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
        this.setHarvestLevel("pickaxe", 2);
    }
} 