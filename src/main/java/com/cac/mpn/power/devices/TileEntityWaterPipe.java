package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IWaterHandler;
import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWaterPipe extends SimplePowerTileEntity implements IWaterHandler {
    private static final int CAPACITY = 2000; // 每根管道最大2L
    private static final int DRAIN_PER_SECOND = 10000; // 每秒拉取10L=10000mL
    private static final int DRAIN_PER_TICK = DRAIN_PER_SECOND / 20; // 每tick拉取500mL
    private int waterAmount = 0;

    public TileEntityWaterPipe() {
        super(1000, IPowerDevice.DeviceType.TRANSMITTER); // 1000RF容量，作为传输设备
    }

    @Override
    public void onTick() {
        if (!world.isRemote) {
            // 从相邻的IWaterHandler拉取水
            for (EnumFacing facing : EnumFacing.values()) {
                TileEntity te = world.getTileEntity(pos.offset(facing));
                if (te instanceof IWaterHandler) {
                    IWaterHandler handler = (IWaterHandler) te;
                    if (handler != this) { // 避免自己拉自己
                        int canPull = Math.min(DRAIN_PER_TICK, handler.getWaterAmount());
                        canPull = Math.min(canPull, CAPACITY - waterAmount);
                        if (canPull > 0) {
                            int pulled = handler.drainWater(canPull);
                            if (pulled > 0) {
                                waterAmount += pulled;
                                markDirty();
                                break; // 一次只从一个设备拉取
                            }
                        }
                    }
                }
            }
            
            // 向相邻的IWaterHandler推送水
            for (EnumFacing facing : EnumFacing.values()) {
                TileEntity te = world.getTileEntity(pos.offset(facing));
                if (te instanceof IWaterHandler) {
                    IWaterHandler handler = (IWaterHandler) te;
                    if (handler != this && waterAmount > 0) { // 避免推给自己
                        int canPush = Math.min(DRAIN_PER_TICK, waterAmount);
                        canPush = Math.min(canPush, handler.getWaterCapacity() - handler.getWaterAmount());
                        if (canPush > 0) {
                            int pushed = handler.fillWater(canPush);
                            if (pushed > 0) {
                                waterAmount -= pushed;
                                markDirty();
                                break; // 一次只推给一个设备
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int fillWater(int amount) {
        int canFill = Math.min(CAPACITY - waterAmount, amount);
        waterAmount += canFill;
        markDirty();
        return canFill;
    }

    @Override
    public int drainWater(int amount) {
        int canDrain = Math.min(waterAmount, amount);
        waterAmount -= canDrain;
        markDirty();
        return canDrain;
    }

    @Override
    public int getWaterAmount() {
        return waterAmount;
    }

    @Override
    public int getWaterCapacity() {
        return CAPACITY;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("WaterAmount", waterAmount);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.waterAmount = compound.getInteger("WaterAmount");
    }
} 