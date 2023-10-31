package com.hidocmatn.timelessjs.custom.animation;

import com.hidocmatn.timelessjs.custom.animation.lib.GunRenderBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class AnimationRenderPart {
    public String name;
    public int index;
    public double offset;
    public AnimationPartType partType;
    public ResourceLocation modelToRender;
    public IBakedModel cachedModel;
    public boolean isPartEmissive;
    public int light;
    public boolean useCustomRenderMethod;
    public Consumer<GunRenderBuilder> customRenderMethod;
    public AnimationRenderPart(String name, int index, AnimationPartType partType) {
        this.name = name;
        this.index = index;
        this.partType = partType;
        this.offset = 0;
        this.useCustomRenderMethod = false;
    }
    public AnimationRenderPart setModelToRender(ResourceLocation model) {
        this.modelToRender = model;
        return this;
    }
    public AnimationRenderPart setModelToRender(String modelPath) {
        return this.setModelToRender(new ResourceLocation(modelPath));
    }
    public AnimationRenderPart isEmissive(boolean flag) {
        this.isPartEmissive = flag;
        return this;
    }
    public AnimationRenderPart setEmissive(int light) {
        this.light = light;
        return this;
    }

    public AnimationRenderPart useCustomRenderMethod(boolean flag) {
        this.useCustomRenderMethod = flag;
        return this;
    }

    public IBakedModel getSpecialModel() {
        if (this.cachedModel == null) {
            IBakedModel model = Minecraft.getInstance().getModelManager().getModel(this.modelToRender);
            if (model == Minecraft.getInstance().getModelManager().getMissingModel()) {
                return model;
            }
            this.cachedModel = model;
        }
        return this.cachedModel;
    }

    public AnimationRenderPart customRenderMethod(Consumer<GunRenderBuilder> renderMethod) {
        this.customRenderMethod = renderMethod;
        return this;
    }
}
