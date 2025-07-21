package com.cac.mpn.Block;

public class BlockZincWire extends net.minecraft.block.BlockContainer {
    public BlockZincWire() {
        super(net.minecraft.block.material.Material.IRON);
        setUnlocalizedName("zinc_wire");
        setRegistryName("zinc_wire");
        setHardness(1.0F);
        setResistance(5.0F);
        setCreativeTab(net.minecraft.creativetab.CreativeTabs.MISC);
    }
    @Override
    public net.minecraft.tileentity.TileEntity createNewTileEntity(net.minecraft.world.World worldIn, int meta) {
        return new com.cac.mpn.power.devices.ZincWire();
    }
} 