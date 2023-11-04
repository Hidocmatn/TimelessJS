package com.hidocmatn.timelessjs.custom.registry;

import com.hidocmatn.timelessjs.custom.animation.AnimationLoader;
import com.hidocmatn.timelessjs.custom.animation.AnimationType;
import com.hidocmatn.timelessjs.custom.animation.controller.CustomController;
import com.hidocmatn.timelessjs.custom.animation.model.GunOverrideModelsJS;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import dev.latvian.kubejs.KubeJSObjects;
import dev.latvian.kubejs.event.StartupEventJS;

import java.util.function.Consumer;

public class TimelessGunRegistryEventJS extends StartupEventJS {
    public TimelessGunRegistryEventJS() {}
    public TimelessItemBuilder create(String name, AnimationType animationType) {
        TimelessItemBuilder builder = new TimelessItemBuilder(name, animationType);
        KubeJSObjects.ITEMS.put(builder.id, builder);
        KubeJSObjects.ALL.add(builder);
        GunAnimationController.setAnimationControllerMap(builder.id, builder.controller);
        GunOverrideModelsJS.register(builder.id, builder.overrideModel);
        AnimationLoader.registerController((CustomController)builder.controller);
        return builder;
    }
    public void create(String name, AnimationType animationType, Consumer<TimelessItemBuilder> callback) {
        TimelessItemBuilder builder = new TimelessItemBuilder(name, animationType);
        callback.accept(builder);
        KubeJSObjects.ITEMS.put(builder.id, builder);
        KubeJSObjects.ALL.add(builder);
        GunAnimationController.setAnimationControllerMap(builder.id, builder.controller);
        GunOverrideModelsJS.register(builder.id, builder.overrideModel);
    }
}
