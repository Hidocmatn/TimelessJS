package com.hidocmatn.timelessjs;

import com.hidocmatn.timelessjs.custom.animation.part.AnimationPartType;
import com.hidocmatn.timelessjs.custom.animation.AnimationType;
import com.hidocmatn.timelessjs.custom.animation.model.IBakedModelRegistryEventJS;
import com.hidocmatn.timelessjs.custom.registry.TimelessGunRegistryEventJS;
import com.hidocmatn.timelessjs.custom.registry.TimelessItemBuilder;
import com.hidocmatn.timelessjs.recipe.TimelessRecipeJS;
import dev.latvian.kubejs.KubeJSPlugin;
import dev.latvian.kubejs.generator.AssetJsonGenerator;
import dev.latvian.kubejs.recipe.RegisterRecipeHandlersEvent;
import dev.latvian.kubejs.script.BindingsEvent;

public class TimelessKubeJSPlugin extends KubeJSPlugin {
    @Override
    public void init() {}
    @Override
    public void initStartup() {
        new TimelessGunRegistryEventJS().post("gun.registry");
        new IBakedModelRegistryEventJS().post("ibakedmodel.registry");
    }
    @Override
    public void addRecipes(RegisterRecipeHandlersEvent event) {
        event.register("tac:workbench", TimelessRecipeJS::new);
    }
    @Override
    public void addBindings(BindingsEvent event) {
        event.add("AnimationType", AnimationType.class);
        event.add("AnimationPartType", AnimationPartType.class);
//        event.add("ANIM_PART_BODY", AnimationPartType.BODY);
//        event.add("ANIM_PART_CAPS", AnimationPartType.CAPS);
//        event.add("ANIM_PART_BOLT", AnimationPartType.BOLT);
//        event.add("ANIM_PART_SLIDE", AnimationPartType.SLIDE);
//        event.add("ANIM_PART_PUMP", AnimationPartType.PUMP);
//        event.add("ANIM_PART_LEFT_HAND", AnimationPartType.LEFT_HAND);
//        event.add("ANIM_PART_RIGHT_HAND", AnimationPartType.RIGHT_HAND);
//        event.add("ANIM_PART_MAGAZINE", AnimationPartType.MAGAZINE);
//        event.add("ANIM_PART_BULLET", AnimationPartType.BULLET);
//        event.add("ANIM_PART_CHAIN", AnimationPartType.CHAIN);
//        event.add("ANIM_PART_CUSTOM", AnimationPartType.CUSTOM);
    }

    public void generateAssetJsons(AssetJsonGenerator generator) {
        for (TimelessItemBuilder builder: TimelessJSObjects.GUNS.values()) {
            builder.type.generateAssets(builder, generator);
        }
    }
}
