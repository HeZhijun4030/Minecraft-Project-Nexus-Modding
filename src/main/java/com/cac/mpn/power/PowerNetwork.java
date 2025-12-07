package com.cac.mpn.power;

import java.util.List;
import java.util.stream.Collectors;
import com.cac.mpn.power.IPowerDevice;
public class PowerNetwork {

    public void update(List<IPowerDevice> devices) {
        if (devices.isEmpty()) return;


        List<IPowerDevice> generators = devices.stream()
            .filter(d -> d.getDeviceType() == IPowerDevice.DeviceType.GENERATOR)
            .collect(Collectors.toList());

        // consumers 包含纯消费者和存储设备（可接收能量）
        List<IPowerDevice> consumers = devices.stream()
            .filter(d -> d.getDeviceType() == IPowerDevice.DeviceType.CONSUMER || d.getDeviceType() == IPowerDevice.DeviceType.STORAGE)
            .collect(Collectors.toList());

        for (IPowerDevice device : devices) {
            device.onTick();
        }

        // 自动分配能量（简单按需分配）
        distributePower(generators, consumers);
    }

    private void distributePower(List<IPowerDevice> generators, List<IPowerDevice> consumers) {
        if (generators.isEmpty() || consumers.isEmpty()) return;

        long totalAvailable = generators.stream()
                .mapToLong(IPowerDevice::getStoredPower)
                .sum();

        if (totalAvailable <= 0) return;

        long totalDemand = consumers.stream()
                .mapToLong(consumer -> consumer.getCapacity() - consumer.getStoredPower())
                .sum();

        if (totalDemand <= 0) return;

        long powerToDistribute = Math.min(totalAvailable, totalDemand);

        // 将每秒传输上限转换为每刻上限（每秒/20）并跟踪每个 generator/consumer 在本刻剩余的可传输额度
        final int TICKS_PER_SECOND = 20;
        long[] genRemaining = new long[generators.size()];
        for (int i = 0; i < generators.size(); i++) {
            IPowerDevice g = generators.get(i);
            if (g instanceof IPowerBlock) {
                long perTickMax = ((IPowerBlock) g).getMaxTransferPerSecond() / TICKS_PER_SECOND;
                genRemaining[i] = Math.max(0, perTickMax);
            } else {
                genRemaining[i] = Long.MAX_VALUE; // no specific cap
            }
        }

        long[] consRemaining = new long[consumers.size()];
        for (int j = 0; j < consumers.size(); j++) {
            IPowerDevice c = consumers.get(j);
            if (c instanceof IPowerBlock) {
                long perTickMax = ((IPowerBlock) c).getMaxTransferPerSecond() / TICKS_PER_SECOND;
                consRemaining[j] = Math.max(0, perTickMax);
            } else {
                consRemaining[j] = Long.MAX_VALUE;
            }
        }

        for (int j = 0; j < consumers.size(); j++) {
            IPowerDevice consumer = consumers.get(j);
            long consumerDemand = consumer.getCapacity() - consumer.getStoredPower();
            if (consumerDemand <= 0) continue;

            long powerForThisConsumer = (consumerDemand * powerToDistribute) / totalDemand;
            // also cap by consumer per-tick remaining
            powerForThisConsumer = Math.min(powerForThisConsumer, consRemaining[j]);

            for (int i = 0; i < generators.size(); i++) {
                if (powerForThisConsumer <= 0) break;
                IPowerDevice generator = generators.get(i);

                long availableFromGenerator = Math.min(generator.getStoredPower(), genRemaining[i]);
                if (availableFromGenerator <= 0) continue;

                long powerToTransfer = Math.min(powerForThisConsumer, availableFromGenerator);

                generator.setStoredPower(generator.getStoredPower() - powerToTransfer);
                consumer.setStoredPower(consumer.getStoredPower() + powerToTransfer);

                powerForThisConsumer -= powerToTransfer;
                genRemaining[i] -= powerToTransfer;
                consRemaining[j] -= powerToTransfer;
            }
        }
    }
}