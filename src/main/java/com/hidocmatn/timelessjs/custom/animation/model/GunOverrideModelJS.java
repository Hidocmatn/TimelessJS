package com.hidocmatn.timelessjs.custom.animation.model;

import com.hidocmatn.timelessjs.custom.animation.part.AnimationRenderPart;
import com.hidocmatn.timelessjs.custom.animation.lib.GunRenderBuilder;
import com.hidocmatn.timelessjs.custom.animation.part.FunctionalAnimationRenderPart;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import com.tac.guns.client.render.animation.module.PlayerHandAnimation;
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
    public void render(float v, ItemCameraTransforms.TransformType transformType, ItemStack itemStack, ItemStack parent, LivingEntity livingEntity, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int light, int overlay) {
        GunAnimationController controller = GunAnimationController.fromRegistryName(ResourceLocation.tryParse("kubejs:" + this.id));
        GunRenderBuilder renderBuilder = new GunRenderBuilder(controller, transformType, itemStack, livingEntity, matrixStack, iRenderTypeBuffer, light, overlay);
        for (AnimationRenderPart part: partSet) {
            renderPart(part, renderBuilder);
        }
        PlayerHandAnimation.render(controller, transformType, matrixStack, iRenderTypeBuffer, light);
    }
    public void renderPart(AnimationRenderPart part, GunRenderBuilder renderBuilder) {
        if (part instanceof FunctionalAnimationRenderPart)
//        if (part.partType != AnimationPartType.RIGHT_HAND && part.partType != AnimationPartType.LEFT_HAND) {
            if (((FunctionalAnimationRenderPart) part).useCustomRenderMethod) {
                ((FunctionalAnimationRenderPart) part).customRenderMethod.accept(renderBuilder);
            }
            else {
//                switch (part.partType) {
//                    case BODY: renderBody(part, renderBuilder);
//                    case BOLT: renderBolt(part, renderBuilder);
//                    case SLIDE: renderSlide(part, renderBuilder);
//                    case MAGAZINE: renderMagazine(part, renderBuilder.controller, renderBuilder.transformType, renderBuilder.stack, renderBuilder.player, renderBuilder.matrices, renderBuilder.renderBuffer, renderBuilder.light, renderBuilder.overlay, renderBuilder.isExtendedMagInstalled());
//                    case CUSTOM: renderDefault(part, renderBuilder.controller, renderBuilder.transformType, renderBuilder.stack, renderBuilder.player, renderBuilder.matrices, renderBuilder.renderBuffer, renderBuilder.light, renderBuilder.overlay);
//                    default: renderDefault(part, renderBuilder.controller, renderBuilder.transformType, renderBuilder.stack, renderBuilder.player, renderBuilder.matrices, renderBuilder.renderBuffer, renderBuilder.light, renderBuilder.overlay);
//                }
            }
        }
    }
//    public void renderBody(AnimationRenderPart part, GunRenderBuilder renderBuilder) {
//        renderBuilder.pushMatrices();
//        {
//            renderBuilder.applySpecialModelTransform(IBakedModelsJS.getIBakedModelByName(part.bodyModelName), part.index);
//            if (part.shouldRenderAttachments) {
//                if (renderBuilder.getStockAttachment().getItem() == ModItems.LIGHT_STOCK.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_light_Stock"), renderBuilder.light, renderBuilder.overlay);
//                }
//                if (renderBuilder.getStockAttachment().getItem() == ModItems.TACTICAL_STOCK.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_tactical_Stock"), renderBuilder.light, renderBuilder.overlay);
//                }
//                if (renderBuilder.getStockAttachment().getItem() == ModItems.WEIGHTED_STOCK.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_weighted_Stock"), renderBuilder.light, renderBuilder.overlay);
//                }
//                if (renderBuilder.getUnderBarrelAttachment().getItem() == ModItems.LIGHT_GRIP.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_light_grip"), renderBuilder.light, renderBuilder.overlay);
//                } else if (renderBuilder.getUnderBarrelAttachment().getItem() == ModItems.SPECIALISED_GRIP.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_specialised_grip"), renderBuilder.light, renderBuilder.overlay);
//                }
//                if (renderBuilder.getBarrelAttachment().getItem() == ModItems.SILENCER.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_silencer"), renderBuilder.light, renderBuilder.overlay);
//                } else if (renderBuilder.getBarrelAttachment().getItem() == ModItems.MUZZLE_COMPENSATOR.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_muzzle_compensator"), renderBuilder.light, renderBuilder.overlay);
//                } else if (renderBuilder.getBarrelAttachment().getItem() == ModItems.MUZZLE_BRAKE.orElse(ItemStack.EMPTY.getItem())) {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_muzzle_brake"), renderBuilder.light, renderBuilder.overlay);
//                } else {
//                    renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(this.id + "_default_barrel"), renderBuilder.light, renderBuilder.overlay);
//                }
//            }
//            renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(part.candidateModels.getOrDefault("body", this.id + "body")), ((part.isPartEmissive) ? part.light : renderBuilder.light), renderBuilder.overlay);
//        }
//        renderBuilder.popMatrices();
//    }
//    public void renderBolt(AnimationRenderPart part, GunRenderBuilder renderBuilder) {
//        renderBuilder.pushMatrices();
//        {
//            renderBuilder.applySpecialModelTransform(IBakedModelsJS.getIBakedModelByName(part.bodyModelName), part.index);
//            if (renderBuilder.shouldOffsetPart()) {
//                renderBuilder.translateMatrices(0, 0, 0.225f * (-4.5 * Math.pow(renderBuilder.getGunCoolDownOg() - 0.5, 2) + 1.0));
//            } else {
//                renderBuilder.translateMatrices(0, 0, 0.225f * (-4.5 * Math.pow(0.5 - 0.5, 2) + 1.0));
//            }
//            renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(part.candidateModels.getOrDefault("bolt", this.id + "bolt")), ((part.isPartEmissive) ? part.light : renderBuilder.light), renderBuilder.overlay);
//        }
//        renderBuilder.popMatrices();
//    }
//    public void renderSlide(AnimationRenderPart part, GunRenderBuilder renderBuilder) {
//        renderBuilder.pushMatrices();
//        {
//            renderBuilder.applySpecialModelTransform(IBakedModelsJS.getIBakedModelByName(part.bodyModelName), part.index);
//            if (renderBuilder.shouldOffsetPart()) {
//                renderBuilder.translateMatrices(0, 0, 0.185f * (-4.5 * Math.pow(renderBuilder.getGunCoolDownOg() - 0.5, 2) + 1.0));
//                renderBuilder.offsetOptic(0.185f * (-4.5 * Math.pow(renderBuilder.getGunCoolDownOg() - 0.5, 2) + 1.0));
//            } else {
//                renderBuilder.translateMatrices(0, 0, 0.185f * (-4.5 * Math.pow(0.5 - 0.5, 2) + 1.0));
//                renderBuilder.offsetOptic(0.185f * (-4.5 * Math.pow(0.5 - 0.5, 2) + 1.0));
//            }
//            renderBuilder.renderModel(IBakedModelsJS.getIBakedModelByName(part.candidateModels.getOrDefault("bolt", this.id + "bolt")), ((part.isPartEmissive) ? part.light : renderBuilder.light), renderBuilder.overlay);
//        }
//        renderBuilder.popMatrices();
//    };
//    public void renderMagazine(AnimationRenderPart part, GunAnimationController controller, ItemCameraTransforms.TransformType transformType, ItemStack stack, LivingEntity player, MatrixStack matrices, IRenderTypeBuffer renderBuffer, int light, int overlay, boolean isExMag) {
//        matrices.pushPose();
//        {
//            controller.applySpecialModelTransform(IBakedModelsJS.getIBakedModelByName(part.bodyModelName), part.index, transformType, matrices);
//            if (isExMag) RenderUtil.renderModel(IBakedModelsJS.getIBakedModelByName(part.candidateModels.getOrDefault("standard_magazine", this.id + "standard_magazine")), stack, matrices, renderBuffer, ((part.isPartEmissive) ? part.light : light), overlay);
//            else RenderUtil.renderModel(IBakedModelsJS.getIBakedModelByName(part.candidateModels.getOrDefault("extended_magazine", this.id + "extended_magazine")), stack, matrices, renderBuffer, ((part.isPartEmissive) ? part.light : light), overlay);
//        }
//        matrices.popPose();
//    }
//    public void renderDefault(AnimationRenderPart part, GunAnimationController controller, ItemCameraTransforms.TransformType transformType, ItemStack stack, LivingEntity player, MatrixStack matrices, IRenderTypeBuffer renderBuffer, int light, int overlay) {
//        matrices.pushPose();
//        {
//            controller.applySpecialModelTransform(IBakedModelsJS.getIBakedModelByName(part.bodyModelName), part.index, transformType, matrices);
//            RenderUtil.renderModel(IBakedModelsJS.getIBakedModelByName(part.candidateModels.getOrDefault("default", this.id + part.name)), stack, matrices, renderBuffer, ((part.isPartEmissive) ? part.light : light), overlay);
//        }
//        matrices.popPose();
//    }
//}
