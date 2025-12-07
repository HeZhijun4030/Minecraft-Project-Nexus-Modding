package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * V 型太阳能：128 ZF/s
 */
public class V_solar extends PowerBlock {
    public V_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 128L, 0L, 0L, 128L * 100L, 128L);
        this.setUnlocalizedName("v_solar");
        this.setRegistryName("v_solar");
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
