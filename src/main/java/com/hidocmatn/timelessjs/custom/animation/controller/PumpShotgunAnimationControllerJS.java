package com.hidocmatn.timelessjs.custom.animation.controller;

import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.PumpShotgunAnimationController;

public class PumpShotgunAnimationControllerJS extends PumpShotgunAnimationController {
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
