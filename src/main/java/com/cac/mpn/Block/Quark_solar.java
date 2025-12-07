package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * 夸克级太阳能：8388608 ZF/s
 */
public class Quark_solar extends PowerBlock {
    public Quark_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 8388608L, 0L, 0L, 8388608L * 100L, 8388608L);
        this.setUnlocalizedName("quark_solar");
        this.setRegistryName("quark_solar");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public boolean hasTileEntity(@Nonnull net.minecraft.block.state.IBlockState state) { return true; }

    @Override
    @Nonnull
    public net.minecraft.tileentity.TileEntity createTileEntity(@Nonnull net.minecraft.world.World world, @Nonnull net.minecraft.block.state.IBlockState state) {
        return new com.cac.mpn.power.TileEntityPower();
    }
}
