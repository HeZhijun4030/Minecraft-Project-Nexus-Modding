package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier7;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier7 extends BlockContainer {
    public BlockAdvancedGeneratorTier7() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier7");
        setRegistryName("advanced_generator_tier7");
        setHardness(9.0F);
        setResistance(45.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier7();
    }
} 