package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockContainer;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;

public class BlockCopperWire extends BlockContainer {
    public BlockCopperWire() {
        super(Material.IRON);
        setUnlocalizedName("copper_cable");
        setRegistryName("copper_cable");
        setHardness(1.0F);
        setResistance(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new com.cac.mpn.power.devices.CopperWire();
    }
} 