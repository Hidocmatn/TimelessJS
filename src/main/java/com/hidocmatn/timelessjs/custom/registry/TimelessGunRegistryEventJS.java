package com.hidocmatn.timelessjs.custom.registry;

import com.hidocmatn.timelessjs.custom.animation.model.GunOverrideModelsJS;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import dev.latvian.kubejs.KubeJSObjects;
import dev.latvian.kubejs.event.StartupEventJS;

import java.util.function.Consumer;

public class TimelessGunRegistryEventJS extends StartupEventJS {
    public TimelessGunRegistryEventJS() {}
    public TimelessItemBuilder create(String name) {
        TimelessItemBuilder builder = new TimelessItemBuilder(name);
        KubeJSObjects.ITEMS.put(builder.id, builder);
        KubeJSObjects.ALL.add(builder);
        GunAnimationController.setAnimationControllerMap(builder.id, builder.controller);
        GunOverrideModelsJS.register(builder.id, builder.overrideModel);
        return builder;
    }
    public void create(String name, Consumer<TimelessItemBuilder> callback) {
        TimelessItemBuilder builder = new TimelessItemBuilder(name);
        callback.accept(builder);
        KubeJSObjects.ITEMS.put(builder.id, builder);
        KubeJSObjects.ALL.add(builder);
        GunAnimationController.setAnimationControllerMap(builder.id, builder.controller);
    }
}
