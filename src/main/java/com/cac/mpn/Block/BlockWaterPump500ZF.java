package com.cac.mpn.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import com.cac.mpn.power.devices.TileEntityWaterPump500ZF;

public class BlockWaterPump500ZF extends Block {
    public BlockWaterPump500ZF() {
        super(Material.IRON);
        setUnlocalizedName("water_pump_500zf");
        setRegistryName("water_pump_500zf");
        setHardness(2.0F);
        setResistance(10.0F);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityWaterPump500ZF();
    }
} 