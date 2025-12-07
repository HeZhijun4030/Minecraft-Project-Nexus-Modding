package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * VII 型太阳能：2048 ZF/s
 */
public class VII_solar extends PowerBlock {
    public VII_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 2048L, 0L, 0L, 2048L * 100L, 2048L);
        this.setUnlocalizedName("vii_solar");
        this.setRegistryName("vii_solar");
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
