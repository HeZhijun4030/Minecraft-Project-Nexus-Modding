Ran tool
Read file: readme.md
Read file: src/main/java/com/cac/mpn/power/README.md
下面是为你的项目量身定制的**维护文档**，内容涵盖项目简介、架构、模块说明、开发规范、常见问题与维护建议，适合团队长期维护和新成员快速上手。

---

# Minecraft Project Nexus 维护文档

---

## 一、项目简介

**Minecraft Project Nexus** 是基于 Minecraft 1.12.2 Forge 的工业模组，目标是打造超越 IC2 的创新工业体验，兼容主流模组，支持高效电力系统、自动化、材料加工等功能。项目采用 Java 8，推荐 JDK 8U371，使用 Gradle 4.10 构建。

---

## 二、项目结构

```
src/
  main/
    java/
      com.cac.mpn/
        Block/         // 方块与矿石定义
        item/          // 物品与工具
        power/         // 电力系统核心与设备
        crafting/      // 合成与配方
        Mod_Main.java  // Mod主类
    resources/
      assets/mpn/
        blockstates/   // 方块状态
        lang/          // 语言文件
        models/        // 模型
        textures/      // 贴图
      mcmod.info       // Mod元数据
```

---

## 三、核心模块说明

### 1. 电力系统（power/）

- **SimplePowerTileEntity**：所有电力相关TileEntity的基类，实现能量存储、同步、类型标识。
- **IPowerDevice**：统一的电力接口，支持 GENERATOR（发电）、CONSUMER（用电）、TRANSMITTER（导线）、STORAGE（储能）。
- **SimplePowerSystem**：负责设备注册与Tick调度（已禁用自动分配，能量流动靠TileEntity主动实现）。
- **ZincWire**：锌导线，主动拉取/推送能量，支持与相邻导线平衡能量。
- **SteamGenerator**：蒸汽发电机，消耗燃料和水产电。
- **ElectricFurnace**：电热炉，消耗电能烧炼物品，电量显示k为单位，能量变化实时同步。

### 2. 方块与物品（Block/、item/）

- **RegisterBlock/RegisterItem**：统一注册所有方块和物品，支持ItemBlock自动注册。
- **Titanium**：钛块，支持合成与后续扩展。
- **各类太阳能板、刀剑等**：可扩展自定义属性。

### 3. 合成与配方（crafting/）

- **FurnaceRecipeRegistryHandler**：注册熔炼配方，支持自定义物品与矿石。

---

## 四、开发与维护规范

### 1. 依赖与环境

- **Java 8**，推荐JDK 8U371
- **Forge 1.12.2-14.23.5.2860**
- **Gradle 4.10**，推荐使用IDEA或Eclipse

### 2. 代码规范

- 包名统一小写，类名大驼峰。
- 资源文件命名与注册名保持一致。
- 所有TileEntity必须注册（见Mod_Main.java的preInit）。
- 事件注册、GUI注册、世界生成注册等均在preInit完成。

### 3. 资源与本地化

- 贴图、模型、blockstate、lang等资源需同步维护。
- 支持中英文双语，优先完善zh_cn.lang和en_us.lang。

---

## 五、常见问题与维护建议

### 1. 电力不流动/电热炉无电

- 检查物理连接（发电机-导线-用电器必须六面相邻）。
- 检查ZincWire缓冲与推送逻辑，建议适当调大CAPACITY。
- 禁用SimplePowerSystem自动分配后，所有能量流动靠TileEntity主动实现。

### 2. TileEntity崩溃或数据丢失

- 必须在preInit注册所有自定义TileEntity，注册名建议“mpn:xxx”格式。

### 3. 世界生成相关

- 如需矿石自然生成，需实现IWorldGenerator并注册，详见标准写法。

### 4. GUI不同步/电量显示异常

- TileEntity数据变化时需调用markDirty+notifyBlockUpdate，已在核心设备实现。
- GUI显示电量已用k为单位，便于阅读。

### 5. 资源文件缺失/紫黑方块

- 检查assets/mpn/blockstates、models、textures等目录下资源是否齐全。
- 注册名、资源名、lang名需完全一致。

---

## 六、扩展与二次开发建议

- 新增设备请继承SimplePowerTileEntity并实现onTick逻辑。
- 新能源/新材料/新自动化设备可参考现有代码结构快速扩展。
- 支持多语言、兼容主流工业模组生态。

---

## 七、社区与贡献

- 欢迎通过Pull Request、Issue等方式参与开发与反馈。
- 代码、文档、翻译、资源均可贡献。

---

## 八、联系方式

- 项目主页/仓库地址：**[请补充]**
- 主要开发者/维护者：**[请补充]**
- QQ/Discord/邮箱等：**[请补充]**

---

如需详细API文档、二次开发教程、或有其它维护需求，请随时补充本维护文档！

---

**最后更新：2025-07-21**  
**维护人：Project Nexus 团队**