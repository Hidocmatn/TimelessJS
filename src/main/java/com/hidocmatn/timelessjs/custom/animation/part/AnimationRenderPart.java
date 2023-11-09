package com.hidocmatn.timelessjs.custom.animation.part;

public class AnimationRenderPart {
    public String name;
    public String gunID;
    public int index;
    public AnimationRenderPart(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public AnimationRenderPart setGun(String gunID) {
        this.gunID = gunID;
        return this;
    }
}
