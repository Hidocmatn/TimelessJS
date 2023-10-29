package com.hidocmatn.timelessjs.custom;

import com.tac.guns.interfaces.IGunModifier;
import dev.latvian.kubejs.item.ItemBuilder;

public class TimelessItemBuilder extends ItemBuilder {
    public transient double radiusMultiplier;
    public transient double speedMultiplier;
    public transient double additionalGravity;
    public TimelessItemBuilder(String i) {
        super(i);
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
}
