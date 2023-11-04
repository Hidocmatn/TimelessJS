package com.hidocmatn.timelessjs.custom.animation;

import com.hidocmatn.timelessjs.TimelessJS;
import com.tac.guns.client.render.animation.module.GunAnimationController;

import java.util.HashMap;
import java.util.Map;

public enum AnimationLabelJS {
    STATIC(GunAnimationController.AnimationLabel.STATIC, "STATIC"),
    DRAW(GunAnimationController.AnimationLabel.DRAW, "DRAW"),
    RELOAD_NORMAL(GunAnimationController.AnimationLabel.RELOAD_NORMAL, "RELOAD_NORMAL"),
    RELOAD_EMPTY(GunAnimationController.AnimationLabel.RELOAD_EMPTY, "RELOAD_EMPTY"),
    RELOAD_INTRO(GunAnimationController.AnimationLabel.RELOAD_INTRO, "RELOAD_INTRO"),
    RELOAD_LOOP(GunAnimationController.AnimationLabel.RELOAD_LOOP, "RELOAD_LOOP"),
    RELOAD_NORMAL_END(GunAnimationController.AnimationLabel.RELOAD_NORMAL_END, "RELOAD_NORMAL_END"),
    RELOAD_EMPTY_END(GunAnimationController.AnimationLabel.RELOAD_EMPTY_END, "RELOAD_EMPTY_END"),
    PULL_BOLT(GunAnimationController.AnimationLabel.PULL_BOLT, "PULL_BOLT"),
    PUMP(GunAnimationController.AnimationLabel.PUMP, "PUMP"),
    BULLET_CHAIN(GunAnimationController.AnimationLabel.BULLET_CHAIN, "BULLET_CHAIN"),
    INSPECT(GunAnimationController.AnimationLabel.INSPECT, "INSPECT"),
    INSPECT_EMPTY(GunAnimationController.AnimationLabel.INSPECT_EMPTY, "INSPECT_EMPTY");
    public static final Map<String, GunAnimationController.AnimationLabel> animationLabelMap = new HashMap<>();
    private String name;
    private GunAnimationController.AnimationLabel label;
    AnimationLabelJS(GunAnimationController.AnimationLabel label, String name) {
        this.label = label;
        this.name = name;
    }
    private void registerLabel(String name, GunAnimationController.AnimationLabel label) {
        animationLabelMap.put(name, label);
    };
    public static GunAnimationController.AnimationLabel getLabelFromName(String name) {
        return animationLabelMap.get(name);
    }
    static {
        for (AnimationLabelJS element: AnimationLabelJS.values()) {
            element.registerLabel(element.name, element.label);
        }
    }
}
