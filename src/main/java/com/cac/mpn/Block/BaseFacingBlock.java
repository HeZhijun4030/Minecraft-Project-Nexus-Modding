package com.cac.mpn.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nonnull;

public class BaseFacingBlock extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BaseFacingBlock(Material materialIn) {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public int getMetaFromState(@Nonnull IBlockState state) {
        EnumFacing facing = state.getValue(FACING);
        return facing.getHorizontalIndex();
    }

    @Override
    @Nonnull
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta % 4);
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    @Nonnull
    public IBlockState getStateForPlacement(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        EnumFacing horizontal = placer == null ? EnumFacing.NORTH : placer.getHorizontalFacing().getOpposite();
        return this.getDefaultState().withProperty(FACING, horizontal);
    }
}