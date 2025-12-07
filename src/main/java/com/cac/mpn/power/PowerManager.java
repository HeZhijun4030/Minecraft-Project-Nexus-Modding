package com.cac.mpn.power;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * PowerManager: 负责每个世界的电力网络驱动。
 *
 * - 在服务端世界刻（WorldTick END）收集所有实现 `IPowerDevice` 的 TileEntity
 * - 将设备列表传递到对应世界的 `PowerNetwork.update(...)`
 *
 * 说明：本实现只会对实现了 `IPowerDevice` 的 TileEntity 生效；若存在非 TileEntity 的设备
 *（例如纯 Block 或 Item），应补充适配器将其包装为 `IPowerDevice`。
 */
@Mod.EventBusSubscriber
public class PowerManager {

    // 每个维度维持一个 PowerNetwork 实例
    private static final Map<Integer, PowerNetwork> networks = new ConcurrentHashMap<>();

    @SubscribeEvent
    public static void onWorldTick(TickEvent.WorldTickEvent event) {
        // 仅在服务器端、刻结束时更新
        if (event.phase != TickEvent.Phase.END) return;
        if (event.world.isRemote) return;

        int dimension = event.world.provider.getDimension();

        PowerNetwork network = networks.computeIfAbsent(dimension, k -> new PowerNetwork());

        // 收集当前世界中所有实现 IPowerDevice 的 TileEntity
        List<IPowerDevice> devices = event.world.loadedTileEntityList.stream()
                .filter(te -> te instanceof IPowerDevice)
                .map(te -> (IPowerDevice) te)
                .collect(Collectors.toList());

        // 更新网络（内部会调用 device.onTick()）
        network.update(devices);
    }

}
