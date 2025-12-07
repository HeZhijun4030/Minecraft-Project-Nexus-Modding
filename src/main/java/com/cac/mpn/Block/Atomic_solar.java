package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * 原子级太阳能：32768 ZF/s
 */
public class Atomic_solar extends PowerBlock {
    public Atomic_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 32768L, 0L, 0L, 32768L * 100L, 32768L);
        this.setUnlocalizedName("atomic_solar");
        this.setRegistryName("atomic_solar");
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
