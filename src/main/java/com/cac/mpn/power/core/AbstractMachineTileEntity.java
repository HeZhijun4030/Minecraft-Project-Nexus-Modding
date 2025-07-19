// com/cac/mpn/power/core/AbstractMachineTileEntity.java
package com.cac.mpn.power.core;

/**
 * 用电设备基类
 */
public abstract class AbstractMachineTileEntity extends AbstractPowerTileEntity implements IPowerConsumer {
    protected AbstractMachineTileEntity(long capacity) {
        super(capacity);
    }

    /**
     * 每tick用电逻辑
     */
    protected abstract void consumePower();

    @Override
    public void update() {
        super.update();
        if (!world.isRemote && isActive()) {
            consumePower();
        }
    }

    @Override
    public long receivePower(long maxReceive, boolean simulate) {
        long received = Math.min(capacity - energyStored, Math.min(getMaxInput(), maxReceive));
        if (!simulate && received > 0) {
            energyStored += received;
            markDirty();
        }
        return received;
    }

    @Override
    public boolean canReceivePower() {
        return energyStored < capacity;
    }
}