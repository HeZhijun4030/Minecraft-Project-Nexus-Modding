package com.cac.mpn.power;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;

import net.minecraft.block.Block;

/**
 * 通用 TileEntity 实现：读取所在 Block 的电力声明（若其实现了 `IPowerBlock`），
 * 并作为 `IPowerDevice` 暴露给 `PowerNetwork`。
 *
 * Block 作者通常不需要修改此类：只需让 Block 继承自 `PowerBlock` 或 实现 `IPowerBlock`。
 */
public class TileEntityPower extends TileEntity implements IPowerDevice {

    private long storedPower = 0L;
    // 用于累积每刻的分数能量（当使用每秒配置时可能产生小数）
    private double energyAccumulator = 0.0;

    @Override
    public long getStoredPower() {
        return storedPower;
    }

    @Override
    public long getCapacity() {
        if (world == null) return 0L;
        Block block = world.getBlockState(pos).getBlock();
        if (block instanceof IPowerBlock) return ((IPowerBlock) block).getCapacity();
        return 0L;
    }

    @Override
    public void setStoredPower(long amount) {
        long cap = getCapacity();
        if (cap <= 0) {
            storedPower = 0;
        } else {
            storedPower = Math.max(0, Math.min(amount, cap));
        }
        markDirty();
    }

    @Override
    public BlockPos getPosition() {
        return pos;
    }

    @Override
    public DeviceType getDeviceType() {
        if (world == null) return DeviceType.CONSUMER;
        Block block = world.getBlockState(pos).getBlock();
        if (block instanceof IPowerBlock) return ((IPowerBlock) block).getDeviceType();
        return DeviceType.CONSUMER;
    }

    @Override
    public void onTick() {
        if (world == null || world.isRemote) return;
        Block block = world.getBlockState(pos).getBlock();
        if (!(block instanceof IPowerBlock)) return;
        IPowerBlock pb = (IPowerBlock) block;

        // 简单逻辑：生成器每刻增加 generation；消费者每刻消耗 consumption（优先使用内部缓存）
        if (getDeviceType() == DeviceType.GENERATOR) {
            // 计算每秒发电量（支持晴天/雨天不同的每秒值），并将其分摊到每个刻中
            double perSecond = 0.0;
            if (world.canSeeSky(pos.up()) && world.isDaytime()) {
                if (world.isRaining()) {
                    perSecond = (double) pb.getGenerationInRainPerSecond();
                } else {
                    perSecond = (double) pb.getGenerationPerSecond();
                }
            }

            if (perSecond > 0 && getCapacity() > 0) {
                double perTick = perSecond / 20.0; // 20 ticks per second
                energyAccumulator += perTick;
                long toAdd = (long) Math.floor(energyAccumulator);
                if (toAdd > 0) {
                    energyAccumulator -= toAdd;
                    setStoredPower(getStoredPower() + toAdd);
                }
            }
            transmitPower(pb);
        } else if (getDeviceType() == DeviceType.CONSUMER) {
            // 使用每秒消耗量并将其分摊到每刻
            double consPerSecond = (double) pb.getConsumptionPerSecond();
            if (consPerSecond > 0 && getCapacity() > 0) {
                double perTickCons = consPerSecond / 20.0;
                energyAccumulator -= perTickCons; // reuse accumulator to represent fractional changes
                long toRemove = (long) Math.floor(-energyAccumulator);
                if (toRemove > 0) {
                    energyAccumulator += toRemove; // subtract the removed amount (energyAccumulator becomes less negative)
                    setStoredPower(getStoredPower() - toRemove);
                }
            }
        }
    }

    @Override
    public boolean canConnectTo(IPowerDevice other) {
        return true;
    }

    private void transmitPower(IPowerBlock pb) {
        long maxTransfer = pb.getMaxTransfer();
        if (maxTransfer <= 0 || storedPower <= 0) return;

        for (EnumFacing facing : EnumFacing.VALUES) {
            BlockPos neighborPos = pos.offset(facing);
            TileEntity te = world.getTileEntity(neighborPos);
            if (te instanceof IPowerDevice) {
                IPowerDevice neighbor = (IPowerDevice) te;
                if (neighbor.canConnectTo(this)) {
                    long neighborCapacity = neighbor.getCapacity();
                    long neighborStored = neighbor.getStoredPower();
                    long space = neighborCapacity - neighborStored;
                    
                    if (space > 0) {
                        long toSend = Math.min(storedPower, Math.min(maxTransfer, space));
                        if (toSend > 0) {
                            neighbor.setStoredPower(neighborStored + toSend);
                            this.storedPower -= toSend;
                            markDirty();
                            if (storedPower <= 0) break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("storedPower")) storedPower = compound.getLong("storedPower");
        if (compound.hasKey("energyAccumulator")) energyAccumulator = compound.getDouble("energyAccumulator");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setLong("storedPower", storedPower);
        compound.setDouble("energyAccumulator", energyAccumulator);
        return compound;
    }
}
