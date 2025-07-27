package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class AdvancedGeneratorTier5 extends SimplePowerTileEntity {
    public static final int POWER_PER_SECOND = 25600;
    public static final int POWER_PER_TICK = POWER_PER_SECOND / 20;
    public static final int POWER_CAPACITY = 2560000;

    public AdvancedGeneratorTier5() {
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