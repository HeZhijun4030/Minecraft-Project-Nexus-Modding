package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * 中子级太阳能：524288 ZF/s
 */
public class Neutron_solar extends PowerBlock {
    public Neutron_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 524288L, 0L, 0L, 524288L * 100L, 524288L);
        this.setUnlocalizedName("neutron_solar");
        this.setRegistryName("neutron_solar");
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
