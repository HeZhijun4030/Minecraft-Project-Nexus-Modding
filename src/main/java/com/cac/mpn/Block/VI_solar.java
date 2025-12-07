package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * VI 型太阳能：512 ZF/s
 */
public class VI_solar extends PowerBlock {
    public VI_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 512L, 0L, 0L, 512L * 100L, 512L);
        this.setUnlocalizedName("vi_solar");
        this.setRegistryName("vi_solar");
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
