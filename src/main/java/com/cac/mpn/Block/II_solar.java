package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import javax.annotation.Nonnull;

/**
 * II 型太阳能：2 ZF/s
 */
public class II_solar extends PowerBlock {
	public II_solar() {
		super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 2L, 0L, 0L, 2L * 100L, 2L);
		this.setUnlocalizedName("ii_solar");
		this.setRegistryName("ii_solar");
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
