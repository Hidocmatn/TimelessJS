package com.hidocmatn.timelessjs.custom.animation.part.types;

import com.hidocmatn.timelessjs.custom.animation.part.AnimationPartType;
import com.hidocmatn.timelessjs.custom.animation.part.FunctionalAnimationRenderPart;

public class AnimationPartMagazine extends FunctionalAnimationRenderPart {
    public String standardMagModelName;
    public boolean renderExtendedMag;
    public String extendedMagModelName;
    public AnimationPartMagazine(String name, int index) {
        super(name, index);
        this.renderExtendedMag = false;
        this.standardMagModelName = this.gunID + "_standard_magazine";
    }
    public AnimationPartMagazine renderExtendedMag(boolean flag) {
        this.renderExtendedMag = flag;
        if (flag) this.extendedMagModelName = this.gunID + "_extended_magazine";
        return this;
    }
    public AnimationPartMagazine setStandardMagazineModel(String modelName) {
        this.standardMagModelName = modelName;
        return this;
    }
    public AnimationPartMagazine setExtendedMagazineModel(String modelName) {
        this.extendedMagModelName = modelName;
        return this;
    }
}
