package com.hidocmatn.timelessjs.custom.animation.controller;

import com.hidocmatn.timelessjs.TimelessJS;
import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.Animations;
import com.tac.guns.client.render.animation.module.GunAnimationController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GunAnimationControllerJS extends GunAnimationController implements CustomController{
    public Map<String, Integer> partIndexMap = new HashMap<>();
    public Map<AnimationLabel, AnimationMeta> animationMetaMap = new HashMap<>();
    public String id;
    public GunAnimationControllerJS(String controllerID) {
        this.id = controllerID;
        this.partIndexMap.put("body", 0);
        this.partIndexMap.put("left_hand", 0);
        this.partIndexMap.put("right_hand", 0);
    }
    @Override
    public AnimationMeta getAnimationFromLabel(AnimationLabel animationLabel) {
        if (animationMetaMap.containsKey(animationLabel)) {
            return animationMetaMap.get(animationLabel);
        }
        else return null;
    }

    @Override
    public int getAttachmentsNodeIndex() {
        return partIndexMap.get("body");
    }

    @Override
    public int getRightHandNodeIndex() {
        return partIndexMap.get("right_hand");
    }

    @Override
    public int getLeftHandNodeIndex() {
        return partIndexMap.get("left_hand");
    }

    @Override
    public void tryLoadAnimation() {
        for (AnimationLabel label : animationMetaMap.keySet()) {
            try {
                Animations.load(animationMetaMap.get(label));
            } catch (IOException e) {
                TimelessJS.LOGGER.fatal(e.getStackTrace());
            }
        }
        enableStaticState();
    }

    @Override
    public void registerPart(String name, int index) {
        this.partIndexMap.put(name, index);
    }

    @Override
    public void registerAnimation(AnimationLabel label, AnimationMeta meta) {
        this.animationMetaMap.put(label, meta);
    }
}
