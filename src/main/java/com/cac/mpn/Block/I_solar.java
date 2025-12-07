package com.cac.mpn.Block;

import com.cac.mpn.item.ModTabs;
import com.cac.mpn.power.IPowerDevice;
import com.cac.mpn.power.TileEntityPower;
import javax.annotation.Nonnull;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * I_solar - 示例太阳能方块
 *
 * 说明：
 * - 该方块继承自 `BaseFacingBlock`（保留朝向行为），同时实现 `IPowerBlock`，
 *   以在不改变继承关系的情况下声明电力属性。
 * - 我们为本示例提供了简要的发电/存储/传输参数；你可以根据需求修改这些返回值或
 *   将它们改为构造器参数以便复用。
 */
public class I_solar extends PowerBlock {

    /**
     * 默认构造器：使用每秒单位声明参数（晴天 1 ZF/s，雨天 0 ZF/s，消耗 0，容量 100，最大传输 1 ZF/s）。
     */
    public I_solar() {
        super(Material.IRON, IPowerDevice.DeviceType.GENERATOR, 1L, 0L, 0L, 100L, 1L);
        this.setUnlocalizedName("I_solar");
        this.setRegistryName("I_solar");
        this.setHardness(5.0F);
        this.setCreativeTab(ModTabs.MPN_TAB);
    }

    @Override
    public boolean hasTileEntity(@Nonnull IBlockState state) { return true; }

    @Override
    @Nonnull
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {
        return new TileEntityPower();
    }
}
