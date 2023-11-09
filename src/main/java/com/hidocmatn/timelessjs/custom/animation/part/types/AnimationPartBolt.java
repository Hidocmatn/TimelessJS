package com.hidocmatn.timelessjs.custom.animation.part.types;

import com.hidocmatn.timelessjs.custom.animation.part.FunctionalAnimationRenderPart;

public class AnimationPartBolt extends FunctionalAnimationRenderPart {
    public boolean isAutomatic;
    public double offset;
    public AnimationPartBolt(String name, int index) {
        super(name, index);
        this.isAutomatic = false;
        this.offset = 0;
    }
    public AnimationPartBolt isAutomatic(boolean flag) {
        this.isAutomatic = flag;
        return this;
    }
}
