package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class AdvancedGeneratorTier4 extends SimplePowerTileEntity {
    public static final long POWER_PER_SECOND = 6400L;
    public static final long POWER_PER_TICK = POWER_PER_SECOND / 20L;
    public static final long POWER_CAPACITY = 640000L;

    public AdvancedGeneratorTier4() {
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