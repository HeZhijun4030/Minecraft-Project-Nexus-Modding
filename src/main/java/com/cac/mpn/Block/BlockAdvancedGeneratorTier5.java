package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.devices.AdvancedGeneratorTier5;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvancedGeneratorTier5 extends BlockContainer {
    public BlockAdvancedGeneratorTier5() {
        super(Material.IRON);
        setUnlocalizedName("advanced_generator_tier5");
        setRegistryName("advanced_generator_tier5");
        setHardness(7.0F);
        setResistance(35.0F);
        setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvancedGeneratorTier5();
    }
} 