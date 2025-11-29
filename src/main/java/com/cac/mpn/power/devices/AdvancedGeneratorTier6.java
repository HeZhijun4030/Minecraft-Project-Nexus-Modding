package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class AdvancedGeneratorTier6 extends SimplePowerTileEntity {
    public static final long POWER_PER_SECOND = 102400L;
    public static final long POWER_PER_TICK = POWER_PER_SECOND / 20L;
    public static final long POWER_CAPACITY = 10240000L;

    public AdvancedGeneratorTier6() {
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