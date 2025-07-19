# Minecraft Project Nexus 电力系统使用文档

## 1. 系统概述

本电力系统为 Minecraft 1.12.2 Forge Mod 设计，提供模块化的电力生产、传输和消耗框架。系统特点包括：
- 基于区块的电力网络管理
- 多线程电力计算
- 支持多种发电设备和用电器
- 可扩展的架构设计

## 2. 快速开始

### 2.1 初始化电力系统

在 Mod 主类的 `preInit` 方法中初始化：

```java
@EventHandler
public void preInit(FMLPreInitializationEvent event) {
    // 初始化电力系统（2个工作线程）
    PowerSystemManager.initialize(DefaultPowerSystem.class, 2);

    // 注册电力设备
    PowerRegistry.initialize();
}
```

### 2.2 添加基础设备

系统已内置三种基础设备：
1. 基础发电机 (`basic_generator`)
2. 电力导线 (`power_wire`)
3. 电炉 (`electric_furnace`)

## 3. 扩展新设备

### 3.1 创建新发电机

1. 创建 TileEntity 类：

```java
public class TileSolarPanel extends AbstractGeneratorTileEntity {
    public TileSolarPanel() {
        super(5000); // 5K容量
    }

    @Override
    protected void generatePower() {
        if (world.isDaytime() && !world.isRaining()) {
            setStoredPower(getStoredPower() + 10); // 白天发电
        }
    }

    @Override
    public long getMaxOutput() {
        return 5; // 最大输出
    }
}
```

2. 在 `PowerRegistry` 中注册：

```java
private static void registerGenerators() {
    // ...其他发电机
    registerCustomPowerDevice(TileSolarPanel.class, "mpn:solar_panel");
}
```

### 3.2 创建新用电器

1. 创建 TileEntity 类：

```java
public class TileCrusher extends AbstractMachineTileEntity {
    public TileCrusher() {
        super(8000); // 8K容量
    }

    @Override
    protected void consumePower() {
        if (getStoredPower() >= 100) { // 每次操作消耗100EU
            // 打粉逻辑...
            setStoredPower(getStoredPower() - 100);
        }
    }
}
```

2. 在 `PowerRegistry` 中注册：

```java
private static void registerMachines() {
    // ...其他机器
    registerCustomPowerDevice(TileCrusher.class, "mpn:crusher");
}
```

## 4. 电力网络调试

### 4.1 查看网络状态

在游戏中查看活跃电力网络数量：
```java
logger.info("Active networks: {}",
    PowerSystemManager.getInstance().getNetworkCount());
```

### 4.2 调试命令

添加测试命令（可选）：
```java
@EventHandler
public void serverStarting(FMLServerStartingEvent event) {
    event.registerServerCommand(new CommandPowerDebug());
}
```

示例命令实现：
```java
public class CommandPowerDebug implements ICommand {
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        sender.sendMessage(new TextComponentString(
            "Active power networks: " +
            PowerSystemManager.getInstance().getNetworkCount()
        ));
    }
}
```

## 5. 最佳实践

1. **电力平衡**：
   - 保持发电量略大于用电需求
   - 为设备设置合理的容量和传输速率

2. **性能优化**：
   - 复杂设备逻辑放在单独的tick计数器
   - 避免每tick进行昂贵计算

3. **网络分割**：
   - 大型工厂使用多个独立电力网络
   - 关键设备配备备用电源

## 6. 常见问题

### Q1: 设备不工作
- 检查是否实现正确接口
- 确认已正确注册TileEntity
- 验证电力网络连接

### Q2: 电力不传输
- 检查导线是否连接
- 确认设备实现了`canConnectTo()`
- 验证网络是否跨区块

### Q3: 性能问题
- 减少高频更新的设备
- 增加电力系统线程数
- 分割大型电力网络

## 7. API参考

### 核心接口

| 接口 | 方法 | 说明 |
|------|------|------|
| `IPowerNode` | `getStoredPower()` | 获取当前存储 |
| `IPowerProvider` | `extractPower()` | 提取电力 |
| `IPowerConsumer` | `receivePower()` | 接收电力 |

### 关键类

| 类 | 作用 |
|----|------|
| `PowerSystemManager` | 系统核心 |
| `AbstractPowerNetwork` | 网络基类 |
| `PowerRegistry` | 设备注册 |

---

> 文档版本：1.0
> 最后更新：2023-11-15
> 适用版本：Minecraft 1.12.2
> 如需更多帮助，请参考示例代码或联系开发者