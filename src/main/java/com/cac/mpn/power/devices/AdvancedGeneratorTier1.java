package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class AdvancedGeneratorTier1 extends SimplePowerTileEntity {
    public static final int POWER_PER_SECOND = 100;
    public static final int POWER_PER_TICK = POWER_PER_SECOND / 20;
    public static final int POWER_CAPACITY = 10000;

    public AdvancedGeneratorTier1() {
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