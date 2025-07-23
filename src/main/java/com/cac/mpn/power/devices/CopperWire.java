package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;

public class CopperWire extends SimplePowerTileEntity {
    public static final int CAPACITY = 1500;
    public static final int TRANSFER_PER_TICK = 75; // 1500RF/s

    public CopperWire() {
        super(CAPACITY, IPowerDevice.DeviceType.TRANSMITTER);
    }

    @Override
    public void onTick() {
        if (world == null || world.isRemote) return;
        // 1. 从相邻GENERATOR拉取能量
        for (net.minecraft.util.EnumFacing facing : net.minecraft.util.EnumFacing.values()) {
            net.minecraft.tileentity.TileEntity te = world.getTileEntity(pos.offset(facing));
            if (te instanceof com.cac.mpn.power.core.IPowerDevice) {
                com.cac.mpn.power.core.IPowerDevice neighbor = (com.cac.mpn.power.core.IPowerDevice) te;
                if (neighbor.getDeviceType() == com.cac.mpn.power.core.IPowerDevice.DeviceType.GENERATOR && getStoredPower() < getCapacity()) {
                    long canPull = Math.min(TRANSFER_PER_TICK, neighbor.getStoredPower());
                    if (canPull > 0) {
                        neighbor.setStoredPower(neighbor.getStoredPower() - canPull);
                        setStoredPower(getStoredPower() + canPull);
                    }
                }
            }
        }
        // 2. 向相邻CONSUMER推送能量
        for (net.minecraft.util.EnumFacing facing : net.minecraft.util.EnumFacing.values()) {
            net.minecraft.tileentity.TileEntity te = world.getTileEntity(pos.offset(facing));
            if (te instanceof com.cac.mpn.power.core.IPowerDevice) {
                com.cac.mpn.power.core.IPowerDevice neighbor = (com.cac.mpn.power.core.IPowerDevice) te;
                if (neighbor.getDeviceType() == com.cac.mpn.power.core.IPowerDevice.DeviceType.CONSUMER && getStoredPower() > 0) {
                    long canPush = Math.min(TRANSFER_PER_TICK, neighbor.getCapacity() - neighbor.getStoredPower());
                    canPush = Math.min(canPush, getStoredPower());
                    if (canPush > 0) {
                        neighbor.setStoredPower(neighbor.getStoredPower() + canPush);
                        setStoredPower(getStoredPower() - canPush);
                    }
                }
            }
        }
        // 3. 与相邻导线平衡能量
        for (net.minecraft.util.EnumFacing facing : net.minecraft.util.EnumFacing.values()) {
            net.minecraft.tileentity.TileEntity te = world.getTileEntity(pos.offset(facing));
            if (te instanceof com.cac.mpn.power.devices.CopperWire && te != this) {
                com.cac.mpn.power.devices.CopperWire neighbor = (com.cac.mpn.power.devices.CopperWire) te;
                long diff = getStoredPower() - neighbor.getStoredPower();
                if (diff > 1) {
                    long transfer = Math.min(Math.abs(diff) / 2, TRANSFER_PER_TICK);
                    if (diff > 0 && transfer > 0) {
                        setStoredPower(getStoredPower() - transfer);
                        neighbor.setStoredPower(neighbor.getStoredPower() + transfer);
                    } else if (diff < 0 && transfer > 0) {
                        setStoredPower(getStoredPower() + transfer);
                        neighbor.setStoredPower(neighbor.getStoredPower() - transfer);
                    }
                }
            }
        }
    }
} 