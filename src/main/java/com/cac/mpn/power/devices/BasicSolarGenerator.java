package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class BasicSolarGenerator extends SimplePowerTileEntity {
    private static final long POWER_PER_SECOND = 15L;
    private static final long POWER_PER_TICK = POWER_PER_SECOND / 20L; // 0.75, 取1
    private static final long CAPACITY = 5000L;
    private int tickCounter = 0;
    private long tickPower = 0L;

    public BasicSolarGenerator() {
        super(CAPACITY, IPowerDevice.DeviceType.GENERATOR);
    }

    @Override
    public void onTick() {
        if (world != null && world.isDaytime() && !world.isRaining()) {
            tickCounter++;
            tickPower += POWER_PER_SECOND;
            if (tickCounter >= 20) {
                setStoredPower(getStoredPower() + tickPower / 20L);
                tickCounter = 0;
                tickPower = 0L;
            }
        } else {
            tickCounter = 0;
            tickPower = 0L;
        }
    }
} 