## v1.2.3

- Add Neon aggregate hooks: expose a public `bekBuildSettings(SettingsMenuDialog.SettingsTable)` hook and a `bekBundled` flag so a bundling host mod (e.g. Neon) can embed the settings UI and suppress auto-registration; the default "enabled" state now adapts when bundled.

## v1.2.2

- Merge desktop and Android into a single artifact: `dist/color-the-ducts.jar` / `dist/color-the-ducts.zip` now contain `classes.dex` and `mod.json` and work on both platforms.
- Move `mod.json` from `src/main/resources/` to the repo root.
- Release workflow now builds with `clean deploy` and uploads `dist/*.jar` and `dist/*.zip`.

## v1.2.1

- Fix hover-line connected detection for liquid junctions: when a duct links into a junction, the opposite duct in the same direction is now included as part of the same line (e.g. `-x-`).

## v1.2.0

- Add a new hover-mode option to color the whole connected liquid-duct line under the cursor.
- Connected-line detection now follows real liquid links, including junction pass-through and liquid bridge links.

## v1.1.0

- Add a new settings toggle to switch between coloring all liquid ducts and only the duct under the mouse cursor.
- Add configurable coloring opacity (0% to 100%, step 5%) in settings.

## v1.0.2

- Fix GitHub Actions release build by switching dependency coordinates to `com.github.Anuken.Mindustry:core`.
- Pin CI compile version to `v146` to avoid missing Arc artifacts on JitPack.

## v1.0.1

- Fix GitHub Actions build by pinning compile dependency to `MindustryJitpack core v146`.
- Keep release workflow using `-PmindustryVersion=v146` for deterministic CI builds.

## v1.0.0

- Initial release of `Color-the-ducts`.
- Draws liquid-colored center squares on liquid duct blocks.
- Adds mod setting `K` (0.0 to 1.0, step 0.1) to control square size.
