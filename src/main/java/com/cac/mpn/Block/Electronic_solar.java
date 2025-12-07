package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;

public class Electronic_solar extends PowerBlock {
    public Electronic_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 1L, 0L, 0L, 100L, 1L);
        this.setUnlocalizedName("electronic_solar");
        this.setRegistryName("electronic_solar");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public boolean hasTileEntity(net.minecraft.block.state.IBlockState state) { return true; }

    @Override
    public net.minecraft.tileentity.TileEntity createTileEntity(net.minecraft.world.World world, net.minecraft.block.state.IBlockState state) {
        return new com.cac.mpn.power.TileEntityPower();
    }
}
