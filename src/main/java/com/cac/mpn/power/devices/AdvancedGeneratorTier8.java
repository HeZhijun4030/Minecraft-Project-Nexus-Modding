package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class AdvancedGeneratorTier8 extends SimplePowerTileEntity {
    public static final int POWER_PER_SECOND = 1638400;
    public static final int POWER_PER_TICK = POWER_PER_SECOND / 20;
    public static final int POWER_CAPACITY = 163840000;

    public AdvancedGeneratorTier8() {
        super(POWER_CAPACITY, IPowerDevice.DeviceType.GENERATOR);
    }

    @Override
    public void onTick() {
        if (!world.isRemote) {
            // 持续发电
            if (getStoredPower() < getCapacity()) {
                setStoredPower(getStoredPower() + POWER_PER_TICK);
            }
        }
    }
} 