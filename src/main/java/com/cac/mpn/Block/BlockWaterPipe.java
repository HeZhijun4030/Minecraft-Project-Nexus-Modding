package com.cac.mpn.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import com.cac.mpn.power.devices.TileEntityWaterPipe;

public class BlockWaterPipe extends Block {
    public BlockWaterPipe() {
        super(Material.IRON);
        setUnlocalizedName("water_pipe");
        setRegistryName("water_pipe");
        setHardness(1.0F);
        setResistance(5.0F);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityWaterPipe();
    }
} 