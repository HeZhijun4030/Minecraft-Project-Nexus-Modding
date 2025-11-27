# Minecraft Project Nexus - AI Coding Guidelines

## 项目概述
这是一个 **Minecraft 1.12.2 Forge 工业模组**，模组ID为 `mpn`，目标是打造超越IC2的工业体验。

- **技术栈**: Java 8 (JDK 8U371), Forge 1.12.2-14.23.5.2860, Gradle 4.10
- **包路径**: `com.cac.mpn`
- **入口类**: `Mod_Main.java`

## 核心架构

### 电力系统 (`power/core/`)
- `IPowerDevice` - 电力设备接口，定义四种设备类型: `GENERATOR`, `CONSUMER`, `STORAGE`, `TRANSMITTER`
- `SimplePowerTileEntity` - 所有电力TileEntity基类，继承它并实现 `onTick()` 方法
- `SimplePowerSystem` - 设备注册与Tick调度（自动能量分配已禁用，能量流动由TileEntity主动实现）

```java
// 新增电力设备示例
public class MyDevice extends SimplePowerTileEntity {
    public MyDevice() {
        super(10000, IPowerDevice.DeviceType.CONSUMER); // 容量, 类型
    }
    @Override
    public void onTick() { /* 设备逻辑 */ }
}
```

### 注册系统
- **方块注册**: `Block/RegisterBlock.java` - 使用 `@Mod.EventBusSubscriber` + `@SubscribeEvent`
- **物品注册**: `item/RegisterItem.java` - 同时注册 `ItemBlock` 与独立物品
- **TileEntity注册**: 必须在 `Mod_Main.preInit()` 中手动注册，格式: `new ResourceLocation(MODID, "xxx_tile")`
- **熔炼配方**: `crafting/FurnaceRecipeRegistryHandler.java`
- **矿石生成**: `Block/ModWorldGen.java`

## 开发规范

### 添加新方块/物品流程
1. 创建方块类 (`Block/`) 或物品类 (`item/`)
2. 在 `RegisterBlock`/`RegisterItem` 中声明静态实例并注册
3. 如果是TileEntity，在 `Mod_Main.preInit()` 中注册
4. 添加资源文件: `blockstates/`, `models/`, `textures/`, `lang/`

### 资源文件路径
```
src/main/resources/assets/mpn/
  blockstates/{block_name}.json
  models/block/{block_name}.json
  models/item/{item_name}.json
  textures/blocks/{texture}.png
  textures/items/{texture}.png
  lang/zh_cn.lang, en_us.lang
```

### 命名约定
- 注册名使用小写下划线: `zinc_wire`, `steam_generator`
- 类名大驼峰: `ZincWire`, `SteamGenerator`
- 资源文件名与注册名一致

## 构建与运行

```bash
# 构建模组
./gradlew build

# 运行客户端测试
./gradlew runClient

# 运行服务端测试  
./gradlew runServer
```

输出JAR位于 `build/libs/mpn-{version}.jar`

## 关键注意事项

1. **TileEntity必须注册** - 否则会导致崩溃，检查 `Mod_Main.preInit()` 
2. **数据同步** - TileEntity数据变化时调用 `markDirty()` + `notifyBlockUpdate()`
3. **电力流动** - 当前禁用自动分配，导线(`ZincWire`)主动拉取/推送能量
4. **资源文件齐全** - 缺失会显示紫黑方块，检查blockstates/models/textures
5. **编码UTF-8** - `build.gradle`已配置 `options.encoding = 'UTF-8'`
