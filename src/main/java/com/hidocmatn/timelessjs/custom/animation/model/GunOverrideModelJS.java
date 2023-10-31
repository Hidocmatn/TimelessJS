package com.hidocmatn.timelessjs.custom.animation.model;

import com.hidocmatn.timelessjs.custom.animation.AnimationRenderPart;
import com.hidocmatn.timelessjs.custom.animation.lib.GunRenderBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import com.tac.guns.client.render.gun.IOverrideModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class GunOverrideModelJS implements IOverrideModel {
    public Set<AnimationRenderPart> partSet = new HashSet<>();
    public String id;
    public GunOverrideModelJS(String modelID) {
        this.id = modelID;
    }
    @Override
    public void render(float v, ItemCameraTransforms.TransformType transformType, ItemStack itemStack, ItemStack itemStack1, LivingEntity livingEntity, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int light, int overlay) {
        GunAnimationController controller = GunAnimationController.fromRegistryName(ResourceLocation.tryParse("kubejs:" + this.id));
        GunRenderBuilder renderBuilder = new GunRenderBuilder(controller, transformType, itemStack, matrixStack, iRenderTypeBuffer, light, overlay);
        for(AnimationRenderPart part: partSet) {
            renderPart(part, renderBuilder);
        }
    }
    public void renderPart(AnimationRenderPart part, GunRenderBuilder renderBuilder) {
        if(part.useCustomRenderMethod) {
            part.customRenderMethod.accept(renderBuilder);
        }
        else {}
    }
}
