package com.hidocmatn.timelessjs.custom.animation.controller;

import com.hidocmatn.timelessjs.TimelessJS;
import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.Animations;
import com.tac.guns.client.render.animation.module.PistalAnimationController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PistolAnimationControllerJS extends PistalAnimationController implements CustomController{
    public Map<String, Integer> partIndexMap = new HashMap<>();
    public Map<AnimationLabel, AnimationMeta> animationMetaMap = new HashMap<>();
    public String id;
    public PistolAnimationControllerJS(String controllerID) {
        this.id = controllerID;
        this.partIndexMap.put("body", 0);
        this.partIndexMap.put("slide", 0);
        this.partIndexMap.put("magazine", 0);
        this.partIndexMap.put("left_hand", 0);
        this.partIndexMap.put("right_hand", 0);
    }
    @Override
    public AnimationMeta getAnimationFromLabel(AnimationLabel animationLabel) {
        return animationMetaMap.get(animationLabel);
    }
    @Override
    public int getSlideNodeIndex() {
        return partIndexMap.get("slide");
    }

    @Override
    public int getMagazineNodeIndex() {
        return partIndexMap.get("magazine");
    }

    @Override
    protected int getAttachmentsNodeIndex() {
        return partIndexMap.get("body");
    }

    @Override
    protected int getRightHandNodeIndex() {
        return partIndexMap.get("right_hand");
    }

    @Override
    protected int getLeftHandNodeIndex() {
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
        if (!animationMetaMap.isEmpty()) {
            enableStaticState();
        }
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
