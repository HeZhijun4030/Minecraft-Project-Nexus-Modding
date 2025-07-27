package com.cac.mpn.power.core;

public interface IWaterHandler {
    /**
     * 尝试向容器中注入水（单位：毫升）。返回实际注入量。
     */
    int fillWater(int amount);

    /**
     * 尝试从容器中抽取水（单位：毫升）。返回实际抽取量。
     */
    int drainWater(int amount);

    /**
     * 获取当前水量（单位：毫升）。
     */
    int getWaterAmount();

    /**
     * 获取最大水量（单位：毫升）。
     */
    int getWaterCapacity();
} 