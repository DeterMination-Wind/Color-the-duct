package colortheducts;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.game.EventType.Trigger;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Icon;
import mindustry.graphics.Layer;
import mindustry.mod.Mod;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;

import java.util.Locale;

import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;
import static mindustry.Vars.ui;
import static mindustry.Vars.world;

public class ColorTheDuctsMod extends Mod{
    private static final String keyEnabled = "ctd-enabled";
    private static final String keyScaleTenths = "ctd-square-scale";

    public ColorTheDuctsMod(){
        Events.on(ClientLoadEvent.class, e -> {
            Core.settings.defaults(keyEnabled, true);
            Core.settings.defaults(keyScaleTenths, 6);
            registerSettings();
        });

        Events.run(Trigger.draw, this::drawLiquidSquares);
    }

    private void registerSettings(){
        if(ui == null || ui.settings == null) return;

        String category = Core.bundle.get("ctd.category", "Color-the-ducts");
        ui.settings.addCategory(category, Icon.imageSmall, table -> {
            table.checkPref(keyEnabled, true);
            table.sliderPref(keyScaleTenths, 6, 0, 10, 1, value -> {
                if(value <= 0) return Core.bundle.get("ctd.scale.off", "off");
                return String.format(Locale.ROOT, "%.1f", value / 10f);
            });
        });
    }

    private void drawLiquidSquares(){
        if(!Core.settings.getBool(keyEnabled, true)) return;
        if(world == null || state == null || !state.isGame() || world.isGenerating()) return;

        float scale = Mathf.clamp(Core.settings.getInt(keyScaleTenths, 6) / 10f, 0f, 1f);
        if(scale <= 0.0001f) return;

        Draw.z(Layer.blockOver + 0.1f);
        Groups.build.each(build -> drawForBuilding(build, scale));
        Draw.color();
    }

    private void drawForBuilding(Building build, float scale){
        if(build == null || !build.isValid() || build.block == null) return;
        if(!isLiquidDuct(build.block)) return;
        if(build.liquids == null || build.liquids.currentAmount() <= 0.0001f) return;

        Liquid liquid = build.liquids.current();
        if(liquid == null) return;

        float sideLength = build.block.size * tilesize * scale;
        if(sideLength <= 0.0001f) return;

        Draw.color(liquid.color);
        Fill.square(build.x, build.y, sideLength / 2f);
    }

    private boolean isLiquidDuct(Block block){
        return block instanceof Conduit
            || block instanceof LiquidJunction
            || block instanceof LiquidRouter
            || block instanceof LiquidBridge
            || block instanceof DirectionLiquidBridge;
    }
}
