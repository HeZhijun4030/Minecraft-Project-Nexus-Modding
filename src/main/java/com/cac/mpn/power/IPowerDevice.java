package com.cac.mpn.power;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public interface IPowerDevice {
    long getStoredPower();
    long getCapacity();
    void setStoredPower(long amount);
    BlockPos getPosition();
    DeviceType getDeviceType();
    void onTick();
    default boolean canConnectTo(IPowerDevice other) {
        return true;
    }
    enum DeviceType {
        GENERATOR,
        CONSUMER,
        STORAGE,
        TRANSMITTER
    }
}