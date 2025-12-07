package com.cac.mpn.Block;

import net.minecraft.block.material.Material;
import com.cac.mpn.power.IPowerBlock;
import com.cac.mpn.power.IPowerDevice;

/**
 * 方便的抽象基类：可使新 Block 通过构造参数声明电力属性。
 * 示例：public class MyGenerator extends PowerBlock { public MyGenerator(){ super(Material.ROCK, DeviceType.GENERATOR, 10, 0, 1024, 128); }}
 */
public abstract class PowerBlock extends BaseFacingBlock implements IPowerBlock {
    private final IPowerDevice.DeviceType deviceType;
    private final long generation; // per-tick
    private final long generationInRain; // per-tick
    private final long consumption; // per-tick
    private final long capacity;
    private final long maxTransfer; // per-tick

    /**
     * 旧构造器（按每刻/tick 参数）：保持向后兼容
     */
    public PowerBlock(Material materialIn, IPowerDevice.DeviceType deviceType, long generation, long consumption, long capacity, long maxTransfer) {
        super(materialIn);
        this.deviceType = deviceType;
        this.generation = generation;
        this.generationInRain = generation / 2;
        this.consumption = consumption;
        this.capacity = capacity;
        this.maxTransfer = maxTransfer;
    }

    /**
     * 新构造器（按每秒参数，推荐使用）：传入的值为每秒（ZF/s），内部转换为每刻（tick）存储。
     */
    public PowerBlock(Material materialIn, IPowerDevice.DeviceType deviceType, long generationPerSecond, long generationInRainPerSecond, long consumptionPerSecond, long capacity, long maxTransferPerSecond) {
        super(materialIn);
        this.deviceType = deviceType;
        // Convert per-second to per-tick by dividing by 20. Keep integer semantics.
        this.generation = generationPerSecond / 20L;
        this.generationInRain = generationInRainPerSecond / 20L;
        this.consumption = consumptionPerSecond / 20L;
        this.capacity = capacity;
        this.maxTransfer = maxTransferPerSecond / 20L;
    }

    @Override
    public IPowerDevice.DeviceType getDeviceType() { return deviceType; }

    @Override
    public long getGeneration() { return generation; }

    @Override
    public long getConsumption() { return consumption; }

    @Override
    public long getCapacity() { return capacity; }

    @Override
    public long getMaxTransfer() { return maxTransfer; }

    @Override
    public long getGenerationInRain() { return generationInRain; }

    // Per-second derived helpers
    @Override
    public long getGenerationPerSecond() { return getGeneration() * 20L; }

    @Override
    public long getGenerationInRainPerSecond() { return getGenerationInRain() * 20L; }

    @Override
    public long getConsumptionPerSecond() { return getConsumption() * 20L; }

    @Override
    public long getMaxTransferPerSecond() { return getMaxTransfer() * 20L; }
}
