package com.hidocmatn.timelessjs.custom.animation.lib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;


public class IBakedModelsJS {
    public static final Map<String, ResourceLocation> MODEL_REGISTER_MAP = new HashMap<>();
    public static void registerModel(String name, ResourceLocation modelPath) {
        MODEL_REGISTER_MAP.put(name, modelPath);
    }
    public static IBakedModel getIBakedModelByName(String name) {
        IBakedModel model = Minecraft.getInstance().getModelManager().getModel(MODEL_REGISTER_MAP.get(name));
        if (model == Minecraft.getInstance().getModelManager().getMissingModel()) {
            return model;
        }
        return model;
    }
}
