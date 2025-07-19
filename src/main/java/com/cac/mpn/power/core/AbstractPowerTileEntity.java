// com/cac/mpn/power/core/AbstractPowerTileEntity.java
package com.cac.mpn.power.core;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 电力设备TileEntity基类
 * 提供基础的电力存储和NBT功能
 */
public abstract class AbstractPowerTileEntity extends TileEntity implements ITickable, IPowerNode {
    protected long energyStored;
    protected final long capacity;

    protected AbstractPowerTileEntity(long capacity) {
        this.capacity = capacity;
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            PowerSystemManager.getInstance().registerNode(world, this);
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        PowerSystemManager.getInstance().unregisterNode(world, this);
    }

    @Override
    public long getStoredPower() {
        return energyStored;
    }

    @Override
    public long getCapacity() {
        return capacity;
    }

    @Override
    public void setStoredPower(long amount) {
        energyStored = Math.min(amount, capacity);
        markDirty();
    }

    @Override
    public BlockPos getPosition() {
        return pos;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        energyStored = compound.getLong("Energy");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setLong("Energy", energyStored);
        return super.writeToNBT(compound);
    }
}