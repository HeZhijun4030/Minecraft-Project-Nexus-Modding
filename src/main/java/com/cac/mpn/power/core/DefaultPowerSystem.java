// com/cac/mpn/power/core/DefaultPowerSystem.java
package com.cac.mpn.power.core;

public class DefaultPowerSystem extends PowerSystemManager {
    public DefaultPowerSystem(int threadCount) {
        super(threadCount);
    }

    @Override
    protected AbstractPowerNetwork createNewNetwork() {
        return new ChunkBasedPowerNetwork();
    }
}