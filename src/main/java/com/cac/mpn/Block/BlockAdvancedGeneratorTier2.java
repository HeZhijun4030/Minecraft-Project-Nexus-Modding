package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier2;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier2 extends BlockContainer {
    public BlockAdvancedGeneratorTier2() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier2");
        setRegistryName("advanced_generator_tier2");
        setHardness(4.0F);
        setResistance(20.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier2();
    }
} 