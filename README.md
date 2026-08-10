# Color-the-ducts (Mindustry Java Mod)
<h1 align="center">
  <a href="https://github.com/DeterMination-Wind/Color-the-duct/releases/latest"><img src="https://img.shields.io/github/v/release/DeterMination-Wind/Color-the-duct?display_name=release&label=Latest%20Release&color=green"></a>
  <a href="https://github.com/DeterMination-Wind/Color-the-duct/releases"><img src="https://img.shields.io/github/downloads/DeterMination-Wind/Color-the-duct/total?label=Downloads&color=blue"></a>
  <a href="LICENSE"><img src="https://img.shields.io/github/license/DeterMination-Wind/Color-the-duct?label=License"></a>
  <a href="https://github.com/DeterMination-Wind/Color-the-duct"><img src="https://img.shields.io/github/stars/DeterMination-Wind/Color-the-duct?style=flat&label=Star%20this%20mod!&color=yellow"></a>
</h1>

- [中文](#中文)
- [English](#english)

## 中文

### 简介

`Color-the-ducts` 是一个纯客户端 QoL 模组：

- 在每个正在运输液体的液体导管中心，绘制一个“液体颜色”的正方形。
- 例如导管内是臭氧，就会显示臭氧颜色的中心方块。

该功能只影响显示，不改动游戏逻辑，适用于多人服务器（服务器无需安装）。

### 设置项

- `启用导管染色`：总开关，默认开启。
- `导管中心方块缩放 (K)`：范围 `0.0 ~ 1.0`，步长 `0.1`，默认 `0.6`。
  - 方块边长计算：`边长 = K * 导管大小`；设为 `0` 时关闭方块显示。
- `仅为鼠标指向导管染色`：只给鼠标当前指向的液体导管染色，默认关闭。
- `指向时染色整条导管`：在鼠标指向模式下，给整条已链接导管染色（含交叉器与液体桥链接），默认关闭。
- `染色不透明度`：液体颜色方块的不透明度，范围 `0% ~ 100%`，步长 `5%`，默认 `100%`。

### 作用范围

当前覆盖液体运输管线相关建筑：

- `Conduit`（含其衍生导管）
- `LiquidJunction`
- `LiquidRouter`
- `LiquidBridge`
- `DirectionLiquidBridge`

### 安装

- 桌面端与安卓端通用：使用 `dist/color-the-ducts.zip` 或 `dist/color-the-ducts.jar`（合并产物，内含 `classes.dex` 与 `mod.json`）。

### 本地构建

在仓库根目录执行：

```powershell
.\gradlew.bat clean deploy
```

构建产物（合并桌面与安卓的单一产物）：

- `dist/color-the-ducts.zip`
- `dist/color-the-ducts.jar`

同时会复制一份带版本号的副本到工作区 `构建/color-the-ducts/`：

- `color-the-ducts-1.2.3.zip`
- `color-the-ducts-1.2.3.jar`

---

## English

### Overview

`Color-the-ducts` is a client-side QoL mod:

- It draws a centered square on liquid duct blocks.
- The square color matches the liquid currently transported.

It is visual-only and does not change gameplay logic.

### Settings

- `Enable Color-the-ducts` (default on)
- `Duct center square scale (K)`: `0.0 ~ 1.0`, step `0.1`, default `0.6`
  - Formula: `square side length = K * duct size`; `0` hides the square.
- `Color only hovered duct`: colors only the duct under the mouse cursor (default off)
- `Hover mode colors full line`: colors the whole connected duct line, junction and liquid-bridge links included (default off)
- `Coloring opacity`: `0% ~ 100%`, step `5%`, default `100%`

### Build

From repo root:

```powershell
.\gradlew.bat clean deploy
```

A single merged desktop+Android artifact is written to `dist/` (`color-the-ducts.jar` / `.zip`, containing `classes.dex`), with a versioned copy in workspace `构建/color-the-ducts/`.
