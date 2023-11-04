package com.hidocmatn.timelessjs.custom.animation.lib;

import dev.latvian.kubejs.event.StartupEventJS;

public class IBakedModelRegistryEventJS extends StartupEventJS {
    public IBakedModelRegistryEventJS() {}
    public void register(String name, String modelPath) {
        IBakedModelBuilder builder = new IBakedModelBuilder(name, modelPath);
        IBakedModelsJS.registerModel(builder.name, builder.modelPath);
    }
}
