package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * 普朗克级太阳能：33554432 ZF/s
 */
public class Planck_solar extends PowerBlock {
    public Planck_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 33554432L, 0L, 0L, 33554432L * 100L, 33554432L);
        this.setUnlocalizedName("planck_solar");
        this.setRegistryName("planck_solar");
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
