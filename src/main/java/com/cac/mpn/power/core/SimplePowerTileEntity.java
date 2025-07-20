package com.cac.mpn.power.core;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public abstract class SimplePowerTileEntity extends TileEntity implements ITickable, IPowerDevice {
    
    protected long energyStored;
    protected final long capacity;
    protected final IPowerDevice.DeviceType deviceType;
    
    protected SimplePowerTileEntity(long capacity, IPowerDevice.DeviceType deviceType) {
        this.capacity = capacity;
        this.deviceType = deviceType;
    }
    
    @Override
    public void update() {
        if (!world.isRemote) {
            SimplePowerSystem.getInstance().registerDevice(this);

            onTick();
        }
    }
    
    @Override
    public void invalidate() {
        super.invalidate();
        SimplePowerSystem.getInstance().unregisterDevice(this);
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
        energyStored = Math.max(0, Math.min(amount, capacity));
        markDirty();
    }
    
    @Override
    public BlockPos getPosition() {
        return pos;
    }
    
    @Override
    public IPowerDevice.DeviceType getDeviceType() {
        return deviceType;
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

    @Override
    public abstract void onTick();
} 