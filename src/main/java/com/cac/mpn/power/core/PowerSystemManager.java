// com/cac/mpn/power/core/PowerSystemManager.java
package com.cac.mpn.power.core;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.*;
import java.util.concurrent.*;

public abstract class PowerSystemManager {
    private static PowerSystemManager instance;

    public static PowerSystemManager getInstance() {
        return instance;
    }
    protected final Map<World, Map<ChunkPos, AbstractPowerNetwork>> networks = new ConcurrentHashMap<>();
    protected final ExecutorService executor;

    protected PowerSystemManager(int threadCount) {
        this.executor = Executors.newFixedThreadPool(threadCount);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void initialize(Class<? extends PowerSystemManager> managerClass, int threadCount) {
        try {
            instance = managerClass.getConstructor(int.class).newInstance(threadCount);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PowerSystem", e);
        }
    }
    public void registerNode(World world, IPowerNode node) {
        ChunkPos chunkPos = new ChunkPos(node.getPosition());
        executor.execute(() -> {
            AbstractPowerNetwork network = getOrCreateNetwork(world, chunkPos);
            network.addNode(node);
        });
    }

    public void unregisterNode(World world, IPowerNode node) {
        ChunkPos chunkPos = new ChunkPos(node.getPosition());
        executor.execute(() -> {
            AbstractPowerNetwork network = networks.getOrDefault(world, Collections.emptyMap()).get(chunkPos);
            if (network != null) {
                network.removeNode(node);
                if (network.isEmpty()) {
                    networks.get(world).remove(chunkPos);
                }
            }
        });
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.world.isRemote) {
            updateNetworks(event.world, event.world.getTotalWorldTime());
        }
    }

    protected abstract AbstractPowerNetwork createNewNetwork();

    protected void updateNetworks(World world, long currentTick) {
        Map<ChunkPos, AbstractPowerNetwork> worldNetworks = networks.get(world);
        if (worldNetworks == null) return;

        executor.execute(() -> {
            worldNetworks.values().forEach(network -> network.update(world, currentTick));
        });
    }

    public int getNetworkCount() {
        return networks.values().stream()
                .mapToInt(Map::size)
                .sum();
    }

    public void shutdown() {
        executor.shutdown();
    }

    private AbstractPowerNetwork getOrCreateNetwork(World world, ChunkPos chunkPos) {
        return networks.computeIfAbsent(world, k -> new ConcurrentHashMap<>())
                .computeIfAbsent(chunkPos, k -> createNewNetwork());
    }
}