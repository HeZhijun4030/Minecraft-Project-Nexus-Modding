// com/cac/mpn/power/core/AbstractGeneratorTileEntity.java
package com.cac.mpn.power.core;

public abstract class AbstractGeneratorTileEntity extends AbstractPowerTileEntity implements IPowerProvider {
    protected AbstractGeneratorTileEntity(long capacity) {
        super(capacity);
    }


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