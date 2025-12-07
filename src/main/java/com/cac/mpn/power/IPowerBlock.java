package com.cac.mpn.power;

/**
 * Block 端声明电力属性的接口。Block 实现此接口后，TileEntityPower
 * 会在运行时读取这些值，从而使得创建新机器时只需在 Block 中声明参数。
 */
public interface IPowerBlock {
    IPowerDevice.DeviceType getDeviceType();
    long getGeneration();      // 每刻产生的电量（用于 GENERATOR）
    long getConsumption();     // 每刻消耗的电量（用于 CONSUMER）
    long getCapacity();        // 内部缓冲容量（若无缓冲，可返回0）
    long getMaxTransfer();     // 最大传输速率（传输/网络使用）
    /**
     * 在下雨/暴风等天气时的发电量。提供默认实现以向后兼容（默认取普通发电量的一半）。
     * Block 可重写此方法以指定不同的下雨发电量。
     */
    default long getGenerationInRain() { return getGeneration() / 2; }
    /**
     * 每秒发电量（用于更直观地配置发电机）。
     * 默认实现向后兼容：基于每刻发电量乘以 20。
     */
    default long getGenerationPerSecond() { return getGeneration() * 20L; }

    /**
     * 下雨时的每秒发电量，默认基于 getGenerationInRain().
     */
    default long getGenerationInRainPerSecond() { return getGenerationInRain() * 20L; }
    /**
     * 每秒消耗量。默认向后兼容：基于每刻消耗乘以 20。
     */
    default long getConsumptionPerSecond() { return getConsumption() * 20L; }

    /**
     * 每秒最大传输速率（用于限制网络内每秒最多传输量）。
     * 默认向后兼容：基于每刻值乘以 20。
     */
    default long getMaxTransferPerSecond() { return getMaxTransfer() * 20L; }
}
