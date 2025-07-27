package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IWaterHandler;
import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityWaterPump500ZF extends SimplePowerTileEntity implements IWaterHandler {
    private static final int CAPACITY = 10000; // 最大容量10L
    private static final int GENERATE_PER_SECOND = 1500; // 每秒生成1.5L=1500mL
    private static final int POWER_CONSUME_PER_SECOND = 100; // 每秒消耗100RF
    private static final int POWER_CONSUME_PER_TICK = POWER_CONSUME_PER_SECOND / 20; // 每tick消耗5RF
    private int waterAmount = 0;
    private int tickCounter = 0;

    public TileEntityWaterPump500ZF() {
        super(5000, IPowerDevice.DeviceType.CONSUMER); // 5000RF容量，作为消费者
    }

    @Override
    public void onTick() {
        if (!world.isRemote) {
            tickCounter++;
            if (tickCounter >= 20) { // 20tick=1秒
                tickCounter = 0;
                // 检查是否有足够电量生成水
                if (getStoredPower() >= POWER_CONSUME_PER_SECOND) {
                    setStoredPower(getStoredPower() - POWER_CONSUME_PER_SECOND);
                    if (waterAmount + GENERATE_PER_SECOND <= CAPACITY) {
                        waterAmount += GENERATE_PER_SECOND;
                    } else {
                        waterAmount = CAPACITY;
                    }
                    markDirty();
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
        compound.setInteger("TickCounter", tickCounter);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.waterAmount = compound.getInteger("WaterAmount");
        this.tickCounter = compound.getInteger("TickCounter");
    }
} 