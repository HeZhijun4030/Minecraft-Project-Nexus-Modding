package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * IV 型太阳能：32 ZF/s
 */
public class IV_solar extends PowerBlock {
    public IV_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 32L, 0L, 0L, 32L * 100L, 32L);
        this.setUnlocalizedName("iv_solar");
        this.setRegistryName("iv_solar");
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
