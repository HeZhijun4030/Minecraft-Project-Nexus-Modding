package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier4;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier4 extends BlockContainer {
    public BlockAdvancedGeneratorTier4() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier4");
        setRegistryName("advanced_generator_tier4");
        setHardness(6.0F);
        setResistance(30.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier4();
    }
} 