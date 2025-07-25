package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class BasicSolarGenerator extends SimplePowerTileEntity {
    private static final int POWER_PER_SECOND = 15;
    private static final int POWER_PER_TICK = POWER_PER_SECOND / 20; // 0.75, 取1
    private static final int CAPACITY = 5000;
    private int tickCounter = 0;
    private int tickPower = 0;

    public BasicSolarGenerator() {
        super(CAPACITY, IPowerDevice.DeviceType.GENERATOR);
    }

    @Override
    public void onTick() {
        if (world != null && world.isDaytime() && !world.isRaining()) {
            tickCounter++;
            tickPower += POWER_PER_SECOND;
            if (tickCounter >= 20) {
                setStoredPower(getStoredPower() + tickPower / 20);
                tickCounter = 0;
                tickPower = 0;
            }
        } else {
            tickCounter = 0;
            tickPower = 0;
        }
    }
} 