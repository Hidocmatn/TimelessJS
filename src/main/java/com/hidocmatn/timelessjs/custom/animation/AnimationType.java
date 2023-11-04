package com.hidocmatn.timelessjs.custom.animation;

import com.tac.guns.client.render.animation.module.GunAnimationController;

public enum AnimationType {
    BASIC("basic"),
    PISTOL("pistol"),
    BOLT_ACTION("bolt_action"),
    PUMP_SHOTGUN("pump_shotgun"),
    MACHINE_GUN("machine_gun");
    private String typeName;
    AnimationType(String name) {
        this.typeName = name;
    }
}
