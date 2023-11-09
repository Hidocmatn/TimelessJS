package com.hidocmatn.timelessjs.custom.animation.part;

import com.hidocmatn.timelessjs.custom.animation.part.types.AnimationPartBody;
import com.hidocmatn.timelessjs.custom.animation.part.types.AnimationPartMagazine;

public enum AnimationPartType {
    BODY,
    CAPS,
    BOLT,
    SLIDE,
    PUMP,
    LEFT_HAND,
    RIGHT_HAND,
    MAGAZINE,
    BULLET,
    CHAIN,
    CUSTOM,
    SYMBOL;
    AnimationPartType() {
    }
    public static AnimationRenderPart getPartByType(String name, int index, AnimationPartType type) {
        switch (type) {
            case BODY: return new AnimationPartBody(name, index);
            case MAGAZINE: return new AnimationPartMagazine(name, index);
            case CUSTOM: return new FunctionalAnimationRenderPart(name, index);
            case SYMBOL:
            default: return new AnimationRenderPart(name, index);
        }
    }
}
