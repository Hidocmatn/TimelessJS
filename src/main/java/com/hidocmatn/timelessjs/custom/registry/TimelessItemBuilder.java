package com.hidocmatn.timelessjs.custom.registry;

import com.hidocmatn.timelessjs.custom.animation.AnimationPartType;
import com.hidocmatn.timelessjs.custom.animation.AnimationRenderPart;
import com.hidocmatn.timelessjs.custom.animation.controller.GunAnimationControllerJS;
import com.hidocmatn.timelessjs.custom.animation.model.GunOverrideModelJS;
import com.tac.guns.interfaces.IGunModifier;
import dev.latvian.kubejs.item.ItemBuilder;

import java.util.function.Consumer;

public class TimelessItemBuilder extends ItemBuilder {
    public GunAnimationControllerJS controller;
    public GunOverrideModelJS overrideModel;
    public transient double radiusMultiplier;
    public transient double speedMultiplier;
    public transient double additionalGravity;
    public TimelessItemBuilder(String i) {
        super(i);
        this.controller = new GunAnimationControllerJS(i);
        this.overrideModel = new GunOverrideModelJS(i);
        this.type = TimelessGunItemType.INSTANCE;
        radiusMultiplier = 1.0;
        speedMultiplier = 1.0;
        additionalGravity = 0.0;
    }
    public TimelessItemBuilder setFireSoundRadiusMultiplier(double multiplier) {
        this.radiusMultiplier = multiplier;
        return this;
    }
    public TimelessItemBuilder setAimDownSightSpeedMultiplier(double multiplier) {
        this.speedMultiplier = multiplier;
        return this;
    }
    public TimelessItemBuilder setAdditionalGravity(double gravity) {
        this.additionalGravity = gravity;
        return this;
    }
    public IGunModifier createIGunModifier() {
        IGunModifier modifier = new IGunModifier() {
            @Override
            public double modifyFireSoundRadius(double radius) {
                return radius * radiusMultiplier;
            }
            @Override
            public double modifyAimDownSightSpeed(double speed) {
                return speed * speedMultiplier;
            }
            @Override
            public double additionalProjectileGravity() {
                return additionalGravity;
            }
        };
        return modifier;
    }
    public TimelessItemBuilder addRenderPart(String partName, int partIndex, AnimationPartType partType, Consumer<AnimationRenderPart> part) {
        AnimationRenderPart renderPart = new AnimationRenderPart(partName, partIndex, partType);
        part.accept(renderPart);
        this.overrideModel.partSet.add(renderPart);
        this.controller.partIndexMap.put(partName, partIndex);
        return this;
    }
}
