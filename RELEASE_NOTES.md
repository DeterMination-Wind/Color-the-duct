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
