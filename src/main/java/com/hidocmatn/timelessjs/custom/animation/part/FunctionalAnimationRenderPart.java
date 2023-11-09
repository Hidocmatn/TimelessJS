package com.hidocmatn.timelessjs.custom.animation.part;

import com.hidocmatn.timelessjs.custom.animation.lib.GunRenderBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FunctionalAnimationRenderPart extends AnimationRenderPart implements FunctionalPart<FunctionalAnimationRenderPart>, EmissivePart<FunctionalAnimationRenderPart>{
    public String name;
    public int index;
    public boolean isPartEmissive;
    public int light;
    public String bodyModelName;
    public boolean useCustomRenderMethod;
    public Consumer<GunRenderBuilder> customRenderMethod;
//    public Map<String, String> candidateModels = new HashMap<>();
    public FunctionalAnimationRenderPart(String name, int index) {
        super(name, index);
        this.light = 15728880;
        this.bodyModelName = this.gunID + "_body";
        this.useCustomRenderMethod = false;
    }
    public FunctionalAnimationRenderPart isEmissive(boolean flag) {
        this.isPartEmissive = flag;
        return this;
    }
    public FunctionalAnimationRenderPart setEmissive(int light) {
        this.light = light;
        return this;
    }
    public FunctionalAnimationRenderPart setBodyModel(String modelName) {
        this.bodyModelName = modelName;
        return this;
    }
//    public FunctionalAnimationRenderPart addCandidateModel(String candidate, String modelName) {
//        this.candidateModels.put(candidate, modelName);
//        return this;
//    }

    public FunctionalAnimationRenderPart useCustomRenderMethod(boolean flag) {
        this.useCustomRenderMethod = flag;
        return this;
    }

    public FunctionalAnimationRenderPart customRenderMethod(Consumer<GunRenderBuilder> renderMethod) {
        this.customRenderMethod = renderMethod;
        return this;
    }
}
