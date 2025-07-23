package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AlloyMachine extends net.minecraft.block.BlockContainer {
    public AlloyMachine() {
        super(Material.IRON);
        this.setUnlocalizedName("alloy_machine");
        this.setRegistryName("alloy_machine");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public net.minecraft.tileentity.TileEntity createNewTileEntity(net.minecraft.world.World worldIn, int meta) {
        return new com.cac.mpn.power.devices.AlloyMachineTileEntity();
    }

    @Override
    public boolean onBlockActivated(net.minecraft.world.World worldIn, net.minecraft.util.math.BlockPos pos, net.minecraft.block.state.IBlockState state, net.minecraft.entity.player.EntityPlayer playerIn, net.minecraft.util.EnumHand hand, net.minecraft.util.EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(com.cac.mpn.Mod_Main.instance, 2, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
} 