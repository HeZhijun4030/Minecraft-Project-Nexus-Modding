package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * III 型太阳能：8 ZF/s
 */
public class III_solar extends PowerBlock {
    public III_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 8L, 0L, 0L, 8L * 100L, 8L);
        this.setUnlocalizedName("iii_solar");
        this.setRegistryName("iii_solar");
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
