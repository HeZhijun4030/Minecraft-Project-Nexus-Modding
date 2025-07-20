package com.cac.mpn.power.core;

import com.cac.mpn.power.core.PowerNetwork;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.tileentity.TileEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SimplePowerSystem {
    private static SimplePowerSystem instance;
    private final Map<World, Map<ChunkPos, PowerNetwork>> networks = new ConcurrentHashMap<>();
    private final Set<IPowerDevice> devices = Collections.newSetFromMap(new ConcurrentHashMap<>());

    private SimplePowerSystem() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static SimplePowerSystem getInstance() {
        if (instance == null) {
            instance = new SimplePowerSystem();
        }
        return instance;
    }

    public void registerDevice(IPowerDevice device) {
        devices.add(device);
    }

    public void unregisterDevice(IPowerDevice device) {
        devices.remove(device);
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.world.isRemote) {
            updateNetworks(event.world);
        }
    }

    private void updateNetworks(World world) {

        Map<ChunkPos, List<IPowerDevice>> chunkDevices = new HashMap<>();
        
        for (IPowerDevice device : devices) {
            if (device instanceof TileEntity && ((TileEntity)device).getWorld() == world) {
                ChunkPos chunkPos = new ChunkPos(device.getPosition());
                chunkDevices.computeIfAbsent(chunkPos, k -> new ArrayList<>()).add(device);
            }
        }


        for (Map.Entry<ChunkPos, List<IPowerDevice>> entry : chunkDevices.entrySet()) {
            PowerNetwork network = getOrCreateNetwork(world, entry.getKey());
            network.update(entry.getValue());
        }
    }

    private PowerNetwork getOrCreateNetwork(World world, ChunkPos chunkPos) {
        return networks.computeIfAbsent(world, k -> new ConcurrentHashMap<>())
                .computeIfAbsent(chunkPos, k -> new PowerNetwork());
    }

    public int getNetworkCount() {
        return networks.values().stream()
                .mapToInt(Map::size)
                .sum();
    }

    public int getDeviceCount() {
        return devices.size();
    }
} 