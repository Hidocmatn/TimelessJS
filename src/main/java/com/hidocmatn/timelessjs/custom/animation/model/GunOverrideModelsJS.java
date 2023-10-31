package com.hidocmatn.timelessjs.custom.animation.model;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class GunOverrideModelsJS {
    public static final Map<ResourceLocation, GunOverrideModelJS> CUSTOM_GUN_MAP = new HashMap();
    public static void register(ResourceLocation id, GunOverrideModelJS model) {
        CUSTOM_GUN_MAP.put(id, model);
    }
}
