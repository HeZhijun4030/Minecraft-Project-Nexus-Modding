package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * 虚无级太阳能：134217728 ZF/s
 */
public class Void_solar extends PowerBlock {
    public Void_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 134217728L, 0L, 0L, 134217728L * 100L, 134217728L);
        this.setUnlocalizedName("void_solar");
        this.setRegistryName("void_solar");
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
