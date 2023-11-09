package com.hidocmatn.timelessjs.custom.registry;

import com.hidocmatn.timelessjs.custom.animation.AnimationLabelJS;
import com.hidocmatn.timelessjs.custom.animation.part.AnimationPartType;
import com.hidocmatn.timelessjs.custom.animation.part.AnimationRenderPart;
import com.hidocmatn.timelessjs.custom.animation.part.FunctionalAnimationRenderPart;
import com.hidocmatn.timelessjs.custom.animation.AnimationType;
import com.hidocmatn.timelessjs.custom.animation.controller.BoltActionAnimationControllerJS;
import com.hidocmatn.timelessjs.custom.animation.controller.CustomController;
import com.hidocmatn.timelessjs.custom.animation.controller.GunAnimationControllerJS;
import com.hidocmatn.timelessjs.custom.animation.controller.PistolAnimationControllerJS;
import com.hidocmatn.timelessjs.custom.animation.model.GunOverrideModelJS;
import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import com.tac.guns.interfaces.IGunModifier;
import dev.latvian.kubejs.KubeJS;
import dev.latvian.kubejs.util.BuilderBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class TimelessItemBuilder extends BuilderBase {
    public TimelessGunItemType type;
    public transient ItemGroup group;
    public GunAnimationController controller;
    public GunOverrideModelJS overrideModel;
    public AnimationType animationType;
    public double radiusMultiplier;
    public double speedMultiplier;
    public double additionalGravity;
    public String parentModel;
    public int maxDamage;
    public TimelessItemBuilder(String i, AnimationType animationType) {
        super(i);
        this.group = KubeJS.tab;
        this.animationType = animationType;
        setAnimationController(i, animationType);
        this.overrideModel = new GunOverrideModelJS(i);
        this.type = TimelessGunItemType.INSTANCE;
        this.parentModel = "kubejs:gun/default";
        this.maxDamage = 0;
        radiusMultiplier = 1.0;
        speedMultiplier = 1.0;
        additionalGravity = 0.0;
    }
    @Override
    public String getBuilderType() {
        return "item";
    }
    public void setAnimationController(String i, AnimationType type) {
        switch (type) {
            case BASIC: this.controller = new GunAnimationControllerJS(i);
            case PISTOL: this.controller = new PistolAnimationControllerJS(i);
            case BOLT_ACTION: this.controller = new BoltActionAnimationControllerJS(i);
        }
    }
    public TimelessItemBuilder maxDamage(int durability) {
        this.maxDamage = durability;
        return this;
    }
    public TimelessItemBuilder parentModel(String modelPath) {
        this.parentModel = modelPath;
        return this;
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
    public TimelessItemBuilder addRenderPart(String partName, int partIndex, AnimationPartType partType, Consumer<AnimationRenderPart> callback) {
        AnimationRenderPart renderPart = AnimationPartType.getPartByType(partName, partIndex, partType);
        renderPart.setGun(this.id.getPath());
        callback.accept(renderPart);
        this.overrideModel.partSet.add(renderPart);
        ((CustomController)this.controller).registerPart(partName, partIndex);
        return this;
    }
    public TimelessItemBuilder addAnimation(GunAnimationController.AnimationLabel label, ResourceLocation animPath) {
        AnimationMeta meta = new AnimationMeta(animPath);
        ((CustomController)this.controller).registerAnimation(label, meta);
        return this;
    };
    public TimelessItemBuilder addAnimation(String label, String animPath) {
        ResourceLocation location = new ResourceLocation(animPath);
        GunAnimationController.AnimationLabel animLabel = AnimationLabelJS.getLabelFromName(label);
        return addAnimation(animLabel, location);
    }

    public Item.Properties applyProperties(Item.Properties properties) {
        properties.tab(this.group);
        if (this.maxDamage > 0) {
            properties.durability(maxDamage);
        }
        return properties;
    }
}
