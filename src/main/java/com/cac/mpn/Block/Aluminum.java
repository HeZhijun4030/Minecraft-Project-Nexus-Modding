package com.cac.mpn.Block;
import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Aluminum extends Block {
    public Aluminum() {
        super(Material.IRON);
        this.setUnlocalizedName("aluminum_ore");
        this.setRegistryName("aluminum_ore");
        this.setHardness(4.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
        this.setHarvestLevel("pickaxe", 2);
    }
} 