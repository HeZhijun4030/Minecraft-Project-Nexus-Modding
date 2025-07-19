// com/cac/mpn/power/core/IPowerNode.java
package com.cac.mpn.power.core;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public interface IPowerNode {

    long getStoredPower();


    long getCapacity();


    void setStoredPower(long amount);


    BlockPos getPosition();

    World getWorld();


    default boolean canConnectTo(IPowerNode other) {
        return true;
    }
}