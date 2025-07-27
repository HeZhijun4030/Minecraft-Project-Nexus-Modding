package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier8;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier8 extends BlockContainer {
    public BlockAdvancedGeneratorTier8() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier8");
        setRegistryName("advanced_generator_tier8");
        setHardness(10.0F);
        setResistance(50.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier8();
    }
} 