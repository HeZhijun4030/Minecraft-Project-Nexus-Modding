package com.cac.mpn.power.core;

import java.util.List;
import java.util.stream.Collectors;

public class PowerNetwork {
    
    public void update(List<IPowerDevice> devices) {
        if (devices.isEmpty()) return;
        

        List<IPowerDevice> generators = devices.stream()
                .filter(d -> d.getDeviceType() == IPowerDevice.DeviceType.GENERATOR)
                .collect(Collectors.toList());
                
        List<IPowerDevice> consumers = devices.stream()
                .filter(d -> d.getDeviceType() == IPowerDevice.DeviceType.CONSUMER)
                .collect(Collectors.toList());

        for (IPowerDevice device : devices) {
            device.onTick();
        }

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
        
        for (IPowerDevice consumer : consumers) {
            long consumerDemand = consumer.getCapacity() - consumer.getStoredPower();
            if (consumerDemand <= 0) continue;

            long powerForThisConsumer = (consumerDemand * powerToDistribute) / totalDemand;

            for (IPowerDevice generator : generators) {
                if (powerForThisConsumer <= 0) break;
                
                long availableFromGenerator = generator.getStoredPower();
                if (availableFromGenerator <= 0) continue;
                
                long powerToTransfer = Math.min(powerForThisConsumer, availableFromGenerator);

                generator.setStoredPower(generator.getStoredPower() - powerToTransfer);
                consumer.setStoredPower(consumer.getStoredPower() + powerToTransfer);
                
                powerForThisConsumer -= powerToTransfer;
            }
        }
    }
} 