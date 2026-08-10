# Color-the-ducts 构建 / 打包工作流

本文档整理本地构建、版本维护与可选自动 Release 的工作流。

---

## 1) 本地构建（Windows / PowerShell）

在仓库根目录执行：

```powershell
.\gradlew.bat clean deploy
```

输出（合并桌面与安卓的单一产物）：

- `dist/color-the-ducts.jar`（内含 `classes.dex` 与 `mod.json`，桌面 / 安卓通用）
- `dist/color-the-ducts.zip`（同上，zip 形式）

并自动复制带版本号的副本到工作区 `构建/color-the-ducts/`：

- `color-the-ducts-<version>.jar`
- `color-the-ducts-<version>.zip`

> 如需单独的平台产物，仍可执行 `zipMod` / `jarMod` / `jarAndroid`（产出 `dist/color-the-ducts-android.jar` 等），但默认发布流程使用 `deploy` 的合并产物。

---

## 2) 版本号维护

发布前保持版本一致：

- `build.gradle`：`version = "x.y.z"`（决定 `构建/` 副本文件名）
- 仓库根 `mod.json`：`"version": "x.y.z"`（随模组包发布；注意该文件在仓库根目录，不在 `src/main/resources/`）

建议：先改版本，再执行一次完整构建，确认 `dist/` 已更新。

---

## 3) 可选 GitHub Actions Release

工作流文件：

- `.github/workflows/release.yml`

触发条件：

- push tag：`v*`（如 `v1.2.3`）

CI 行为：

1) checkout
2) Java 17 + Gradle + Android SDK（`build-tools;34.0.0`）
3) 执行 `clean deploy`
4) 上传 `dist/*.jar` 与 `dist/*.zip` 到 GitHub Release
