package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * 质子级太阳能：131072 ZF/s
 */
public class Proton_solar extends PowerBlock {
    public Proton_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 131072L, 0L, 0L, 131072L * 100L, 131072L);
        this.setUnlocalizedName("proton_solar");
        this.setRegistryName("proton_solar");
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
