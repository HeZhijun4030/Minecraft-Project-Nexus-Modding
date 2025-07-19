// com/cac/mpn/power/core/AbstractGeneratorTileEntity.java
package com.cac.mpn.power.core;

/**
 * 发电设备基类
 */
public abstract class AbstractGeneratorTileEntity extends AbstractPowerTileEntity implements IPowerProvider {
    protected AbstractGeneratorTileEntity(long capacity) {
        super(capacity);
    }

    /**
     * 每tick发电逻辑
     */
    protected abstract void generatePower();

    @Override
    public void update() {
        super.update();
        if (!world.isRemote) {
            generatePower();
        }
    }

    @Override
    public long extractPower(long maxExtract, boolean simulate) {
        long extracted = Math.min(energyStored, Math.min(getMaxOutput(), maxExtract));
        if (!simulate && extracted > 0) {
            energyStored -= extracted;
            markDirty();
        }
        return extracted;
    }
}