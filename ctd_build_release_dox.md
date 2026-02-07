# Color-the-ducts 构建 / 打包工作流

本文档按 `Power-Grid-Minimap-repo-clone` 的流程整理（本地构建 + 版本维护 + 可选自动 Release）。

---

## 1) 本地构建（Windows / PowerShell）

在仓库根目录执行：

```powershell
.\gradlew.bat clean zipMod jarMod jarAndroid
```

输出：

- `dist/color-the-ducts.zip`
- `dist/color-the-ducts.jar`
- `dist/color-the-ducts-android.jar`

并自动复制到工作区根目录 `构建/`：

- `color-the-ducts-<version>.zip`
- `color-the-ducts-<version>.jar`
- `color-the-ducts-<version>-android.jar`

---

## 2) 版本号维护

发布前保持版本一致：

- `build.gradle`：`version = "x.y.z"`
- `src/main/resources/mod.json`：`"version": "x.y.z"`

建议：先改版本，再执行一次完整构建，确认 `dist/` 已更新。

---

## 3) 可选 GitHub Actions Release

工作流文件：

- `.github/workflows/release.yml`

触发条件：

- push tag：`v*`（如 `v1.0.0`）

CI 行为：

1) checkout
2) Java 17 + Gradle + Android SDK
3) 执行 `clean zipMod jarMod jarAndroid`
4) 上传三个产物到 GitHub Release

> 按你的要求，这里只保留工作流模板，不涉及远程仓库提交步骤。
