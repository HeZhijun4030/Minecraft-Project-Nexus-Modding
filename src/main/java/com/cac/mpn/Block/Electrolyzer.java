package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

import com.cac.mpn.Mod_Main;
import com.cac.mpn.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class Electrolyzer extends PowerBlock {
    public Electrolyzer() {
        // 耗能: 20 ZF/s
        // 最大输入: 无限制 (Long.MAX_VALUE)
        // 容量: 设为 2000 (可供 100秒 消耗)
        super(Material.IRON, IPowerDevice.DeviceType.CONSUMER, 0L, 0L, 20L, 2000L, Long.MAX_VALUE);
        this.setUnlocalizedName("electrolyzer");
        this.setRegistryName("electrolyzer");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(Mod_Main.instance, GuiHandler.GUI_ELECTROLYZER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public boolean hasTileEntity(@javax.annotation.Nonnull IBlockState state) { return true; }

    @Override
    public net.minecraft.tileentity.TileEntity createTileEntity(@javax.annotation.Nonnull World world, @javax.annotation.Nonnull IBlockState state) {
        return new com.cac.mpn.power.TileEntityPower();
    }
}
