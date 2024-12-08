package com.cac.mpn.Block;
import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Singular_solar extends Block {
    public Singular_solar()
    {
        super(Material.IRON);
        this.setUnlocalizedName("singular_solar");
        this.setRegistryName("singular_solar");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
}
