package com.cac.mpn.Block;

import com.cac.mpn.power.devices.SteamGenerator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSteamGenerator extends BlockContainer {
    public BlockSteamGenerator() {
        super(Material.IRON);
        setUnlocalizedName("steam_generator");
        setRegistryName("steam_generator");
        setHardness(2.0F);
        setResistance(10.0F);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new SteamGenerator();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(com.cac.mpn.Mod_Main.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof com.cac.mpn.power.devices.SteamGenerator) {
            com.cac.mpn.power.devices.SteamGenerator gen = (com.cac.mpn.power.devices.SteamGenerator) tileentity;
            for (int i = 0; i < gen.getSizeInventory(); i++) {
                net.minecraft.inventory.InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), gen.getStackInSlot(i));
            }
        }
        super.breakBlock(worldIn, pos, state);
    }
} 