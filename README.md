# Color-the-ducts (Mindustry Java Mod)

- [中文](#中文)
- [English](#english)

## 中文

### 简介

`Color-the-ducts` 是一个纯客户端 QoL 模组：

- 在每个正在运输液体的液体导管中心，绘制一个“液体颜色”的正方形。
- 例如导管内是臭氧，就会显示臭氧颜色的中心方块。

该功能只影响显示，不改动游戏逻辑，适用于多人服务器（服务器无需安装）。

### 设置项

- `启用导管染色`：总开关。
- `导管中心方块缩放 (K)`：范围 `0.0 ~ 1.0`，步长 `0.1`。
  - 方块边长计算：`边长 = K * 导管大小`。

### 作用范围

当前覆盖液体运输管线相关建筑：

- `Conduit`（含其衍生导管）
- `LiquidJunction`
- `LiquidRouter`
- `LiquidBridge`
- `DirectionLiquidBridge`

### 安装

- 桌面端：使用 `dist/color-the-ducts.zip` 或 `dist/color-the-ducts.jar`。
- 安卓端：使用 `dist/color-the-ducts-android.jar`（含 `classes.dex`）。

### 本地构建

在仓库根目录执行：

```powershell
.\gradlew.bat clean zipMod jarMod jarAndroid
```

构建产物：

- `dist/color-the-ducts.zip`
- `dist/color-the-ducts.jar`
- `dist/color-the-ducts-android.jar`

同时会复制一份到工作区根目录 `构建/`：

- `构建/color-the-ducts-1.0.0.zip`
- `构建/color-the-ducts-1.0.0.jar`
- `构建/color-the-ducts-1.0.0-android.jar`

---

## English

### Overview

`Color-the-ducts` is a client-side QoL mod:

- It draws a centered square on liquid duct blocks.
- The square color matches the liquid currently transported.

It is visual-only and does not change gameplay logic.

### Settings

- `Enable Color-the-ducts`
- `Duct center square scale (K)`: `0.0 ~ 1.0`, step `0.1`
  - Formula: `square side length = K * duct size`

### Build

From repo root:

```powershell
.\gradlew.bat clean zipMod jarMod jarAndroid
```

Outputs are written to `dist/` and copied to workspace `构建/`.
