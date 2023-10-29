package com.hidocmatn.timelessjs.custom;

import dev.latvian.kubejs.KubeJSObjects;
import dev.latvian.kubejs.event.StartupEventJS;

import java.util.function.Consumer;

public class TimelessGunRegistryEventJS extends StartupEventJS {
    public TimelessGunRegistryEventJS() {}
    public TimelessItemBuilder create(String name) {
        TimelessItemBuilder builder = new TimelessItemBuilder(name);
        KubeJSObjects.ITEMS.put(builder.id, builder);
        KubeJSObjects.ALL.add(builder);
        return builder;
    }
    public void create(String name, Consumer<TimelessItemBuilder> callback) {
        TimelessItemBuilder builder = new TimelessItemBuilder(name);
        callback.accept(builder);
        KubeJSObjects.ITEMS.put(builder.id, builder);
        KubeJSObjects.ALL.add(builder);
    }
}
