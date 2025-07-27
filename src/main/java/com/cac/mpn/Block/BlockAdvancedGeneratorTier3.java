package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier3;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier3 extends BlockContainer {
    public BlockAdvancedGeneratorTier3() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier3");
        setRegistryName("advanced_generator_tier3");
        setHardness(5.0F);
        setResistance(25.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier3();
    }
} 