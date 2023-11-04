package com.hidocmatn.timelessjs.custom.animation.lib;

import net.minecraft.util.ResourceLocation;

public class IBakedModelBuilder {
    public String name;
    public ResourceLocation modelPath;
    public IBakedModelBuilder(String name, String path) {
        this.name = name;
        this.modelPath = new ResourceLocation(path);
    }
}
