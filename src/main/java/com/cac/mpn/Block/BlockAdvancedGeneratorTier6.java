package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier6;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier6 extends BlockContainer {
    public BlockAdvancedGeneratorTier6() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier6");
        setRegistryName("advanced_generator_tier6");
        setHardness(8.0F);
        setResistance(40.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier6();
    }
} 