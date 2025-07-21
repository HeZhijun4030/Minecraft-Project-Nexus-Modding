package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;

public class BlockElectricFurnace extends net.minecraft.block.BlockContainer {
    public BlockElectricFurnace() {
        super(net.minecraft.block.material.Material.IRON);
        setUnlocalizedName("electric_furnace");
        setRegistryName("electric_furnace");
        setHardness(2.0F);
        setResistance(10.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
    @Override
    public net.minecraft.tileentity.TileEntity createNewTileEntity(net.minecraft.world.World worldIn, int meta) {
        return new com.cac.mpn.power.devices.ElectricFurnace();
    }

    @Override
    public boolean onBlockActivated(net.minecraft.world.World worldIn, net.minecraft.util.math.BlockPos pos, net.minecraft.block.state.IBlockState state, net.minecraft.entity.player.EntityPlayer playerIn, net.minecraft.util.EnumHand hand, net.minecraft.util.EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(com.cac.mpn.Mod_Main.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
} 