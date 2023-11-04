package com.hidocmatn.timelessjs.custom.animation.controller;

import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.GunAnimationController;

public interface CustomController {
    void tryLoadAnimation();
    void registerPart(String name, int index);
    void registerAnimation(GunAnimationController.AnimationLabel label, AnimationMeta meta);
}
