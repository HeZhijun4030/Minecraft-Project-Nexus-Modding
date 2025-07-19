// com/cac/mpn/power/core/IPowerConsumer.java
package com.cac.mpn.power.core;


public interface IPowerConsumer extends IPowerNode {

    long receivePower(long maxReceive, boolean simulate);


    long getMaxInput();


    boolean canReceivePower();


    default boolean isActive() {
        return true;
    }
}