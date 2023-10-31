package com.hidocmatn.timelessjs.custom.animation.controller;

import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.GunAnimationController;

import java.util.HashMap;
import java.util.Map;

public class GunAnimationControllerJS extends GunAnimationController {
    public Map<String, Integer> partIndexMap = new HashMap<>();
    public String id;
    public GunAnimationControllerJS(String controllerID) {
        this.id = controllerID;
        this.partIndexMap.put("body", 0);
        this.partIndexMap.put("left_hand", 0);
        this.partIndexMap.put("right_hand", 0);
    }
    @Override
    public AnimationMeta getAnimationFromLabel(AnimationLabel animationLabel) {
        return null;
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
}
