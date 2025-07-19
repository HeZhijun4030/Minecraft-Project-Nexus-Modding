// com/cac/mpn/power/core/IPowerProvider.java
package com.cac.mpn.power.core;


public interface IPowerProvider extends IPowerNode {

    long extractPower(long maxExtract, boolean simulate);


    long getMaxOutput();


    default boolean canProvidePower() {
        return getStoredPower() > 0;
    }
}