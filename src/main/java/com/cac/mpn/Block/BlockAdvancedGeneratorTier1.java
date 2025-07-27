package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier1;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier1 extends BlockContainer {
    public BlockAdvancedGeneratorTier1() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier1");
        setRegistryName("advanced_generator_tier1");
        setHardness(3.0F);
        setResistance(15.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier1();
    }
} 