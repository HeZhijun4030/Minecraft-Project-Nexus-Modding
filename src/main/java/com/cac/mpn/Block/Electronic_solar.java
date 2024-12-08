package com.cac.mpn.Block;
import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Electronic_solar extends Block {
    public Electronic_solar()
    {
        super(Material.IRON);
        this.setUnlocalizedName("electronic_solar");
        this.setRegistryName("electronic_solar");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
}
