// com/cac/mpn/power/core/AbstractPowerNetwork.java
package com.cac.mpn.power.core;

import net.minecraft.world.World;
import java.util.*;


public abstract class AbstractPowerNetwork {
    protected final Set<IPowerNode> nodes = new HashSet<>();

    public void addNode(IPowerNode node) {
        nodes.add(node);
    }

    public void removeNode(IPowerNode node) {
        nodes.remove(node);
    }

    public abstract void update(World world, long currentTick);

    protected abstract void distributePower(List<IPowerProvider> providers, List<IPowerConsumer> consumers);

    public boolean isEmpty() {
        return nodes.isEmpty();
    }
}