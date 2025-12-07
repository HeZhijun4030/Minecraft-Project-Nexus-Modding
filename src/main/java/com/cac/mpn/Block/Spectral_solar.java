package com.cac.mpn.Block;


import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;

public class Spectral_solar extends PowerBlock {
    public Spectral_solar() {
        // 使用每秒单位声明：晴天 1 ZF/s，雨天 0 ZF/s，消耗 0，容量 100，最大传输 1 ZF/s
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 8192L, 0L, 0L, 8192L * 100L, 8192L);
        this.setUnlocalizedName("spectral_solar");
        this.setRegistryName("spectral_solar");
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
