package com.hidocmatn.timelessjs.custom.animation.controller;

import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.BoltActionAnimationController;

public class BoltActionAnimationControllerJS extends BoltActionAnimationController {
    @Override
    public AnimationMeta getAnimationFromLabel(AnimationLabel animationLabel) {
        return null;
    }

    @Override
    protected int getAttachmentsNodeIndex() {
        return 0;
    }

    @Override
    protected int getRightHandNodeIndex() {
        return 0;
    }

    @Override
    protected int getLeftHandNodeIndex() {
        return 0;
    }
}
