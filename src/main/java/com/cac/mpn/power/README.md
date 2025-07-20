# 精简电力系统使用指南

## 概述

这个精简的电力系统是对原有复杂架构的重构，主要改进包括：

### 主要简化
1. **统一接口**: 将 `IPowerNode`、`IPowerProvider`、`IPowerConsumer` 合并为单一的 `IPowerDevice` 接口
2. **简化基类**: 将多个抽象类合并为 `SimplePowerTileEntity`
3. **简化管理器**: 将复杂的 `PowerSystemManager` 简化为 `SimplePowerSystem`
4. **移除多线程**: 移除了不必要的多线程复杂性，使用单线程同步更新

### 核心组件

#### 1. IPowerDevice 接口
```java
public interface IPowerDevice {
    long getStoredPower();
    long getCapacity();
    void setStoredPower(long amount);
    BlockPos getPosition();
    World getWorld();
    DeviceType getDeviceType();
    void onTick();
    boolean canConnectTo(IPowerDevice other);
}
```

#### 2. SimplePowerTileEntity 基类
```java
public abstract class SimplePowerTileEntity extends TileEntity implements ITickable, IPowerDevice {
    protected SimplePowerTileEntity(long capacity, IPowerDevice.DeviceType deviceType);
    public abstract void onTick();
}
```

#### 3. SimplePowerSystem 管理器
```java
public class SimplePowerSystem {
    public static SimplePowerSystem getInstance();
    public void registerDevice(IPowerDevice device);
    public void unregisterDevice(IPowerDevice device);
}
```

## 快速开始

### 1. 初始化系统
在 Mod 主类的 `preInit` 方法中：

```java
@EventHandler
public void preInit(FMLPreInitializationEvent event) {
    // 初始化电力系统
    SimplePowerRegistry.initialize();
}
```

### 2. 创建发电机
```java
public class SolarPanel extends SimplePowerTileEntity {
    public SolarPanel() {
        super(5000, IPowerDevice.DeviceType.GENERATOR);
    }
    
    @Override
    public void onTick() {
        if (world.isDaytime() && !world.isRaining()) {
            setStoredPower(getStoredPower() + 10);
        }
    }
}
```

### 3. 创建用电器
```java
public class ElectricFurnace extends SimplePowerTileEntity {
    public ElectricFurnace() {
        super(8000, IPowerDevice.DeviceType.CONSUMER);
    }
    
    @Override
    public void onTick() {
        if (getStoredPower() >= 5) {
            setStoredPower(getStoredPower() - 5);
            // 处理逻辑...
        }
    }
}
```

### 4. 注册设备
```java
@EventHandler
public void preInit(FMLPreInitializationEvent event) {
    SimplePowerRegistry.initialize();
    SimplePowerRegistry.registerPowerDevices(SolarPanel.class, ElectricFurnace.class);
}
```

## 设备类型

系统支持四种设备类型：

- **GENERATOR**: 发电机，产生电力
- **CONSUMER**: 用电器，消耗电力
- **STORAGE**: 储能设备，存储电力
- **TRANSMITTER**: 传输设备，传输电力

## 电力分配

系统自动在区块内的设备间分配电力：

1. 发电机将电力存储到自己的容量中
2. 用电器从发电机中提取电力
3. 按需求比例分配电力
4. 支持多个发电机和用电器

## 性能优化

相比原系统，精简版本：

- **减少内存占用**: 移除了复杂的网络管理
- **简化更新逻辑**: 单线程同步更新
- **减少接口数量**: 从3个接口简化为1个
- **简化继承层次**: 从多个抽象类简化为1个

## 迁移指南

### 从原系统迁移

1. **替换接口实现**:
   ```java
   // 旧版本
   public class MyGenerator extends AbstractGeneratorTileEntity implements IPowerProvider
   
   // 新版本
   public class MyGenerator extends SimplePowerTileEntity
   ```

2. **更新设备类型**:
   ```java
   // 在构造函数中指定设备类型
   super(capacity, IPowerDevice.DeviceType.GENERATOR);
   ```

3. **简化更新逻辑**:
   ```java
   // 旧版本
   @Override
   protected void generatePower() { ... }
   
   // 新版本
   @Override
   public void onTick() { ... }
   ```

## 示例代码

完整示例请参考：
- `SolarPanel.java` - 发电机示例
- `ElectricFurnace.java` - 用电器示例

## 注意事项

1. 设备会自动注册到电力系统，无需手动管理
2. 电力分配按区块进行，跨区块需要特殊处理
3. 系统使用同步更新，避免复杂的线程安全问题
4. 所有设备共享相同的电力单位（EU）

---

这个精简系统保留了核心功能，同时大大简化了使用复杂度。 