package com.hidocmatn.timelessjs.custom.animation.lib;

import com.hidocmatn.timelessjs.custom.animation.AnimationLabelJS;
import com.hidocmatn.timelessjs.custom.animation.model.IBakedModelsJS;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.tac.guns.client.handler.GunRenderingHandler;
import com.tac.guns.client.render.animation.module.AnimationMeta;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import com.tac.guns.client.util.RenderUtil;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class GunRenderBuilder {
    public GunAnimationController controller;
    public ItemCameraTransforms.TransformType transformType;
    public ItemStack stack;
    public LivingEntity player;
    public MatrixStack matrices;
    public IRenderTypeBuffer renderBuffer;
    public int light;
    public int overlay;
    public GunRenderBuilder(GunAnimationController controller, ItemCameraTransforms.TransformType transformType, ItemStack stack, LivingEntity player, MatrixStack matrices, IRenderTypeBuffer renderBuffer, int light, int overlay) {
        this.controller = controller;
        this.transformType = transformType;
        this.stack = stack;
        this.player = player;
        this.matrices = matrices;
        this.renderBuffer = renderBuffer;
        this.light = light;
        this.overlay = overlay;
    }
    public boolean isFirstPerson() {
        return this.transformType.firstPerson();
    }
    public boolean isAnimationRunning() {
        return controller.isAnimationRunning();
    }
    public boolean isAnimationNull(String anim) {
        return (controller.getAnimationFromLabel(AnimationLabelJS.getLabelFromName(anim)) == null);
    }
    public boolean equalsPreviousAnimation(String anim) {
        return (controller.getPreviousAnimation() == controller.getAnimationFromLabel(AnimationLabelJS.getLabelFromName(anim)));
    }
    public boolean gunHasAmmo() {
        return GunStatusHelper.hasAmmo(stack);
    }
    public boolean isExtendedMagInstalled() {
        return GunStatusHelper.isExtendedMagazineInstalled(stack);
    }
    public boolean isGunScopeInstalled() {
        return GunStatusHelper.isScopeInstalled(stack);
    }
    public boolean shouldOffsetPart() {
        AnimationMeta reloadEmpty = controller.getAnimationFromLabel(GunAnimationController.AnimationLabel.RELOAD_EMPTY);
        boolean flag = (reloadEmpty != null && reloadEmpty.equals(controller.getPreviousAnimation()) && controller.isAnimationRunning());
        return flag;
    }
    public int getGunAmmoCount() {
        return GunStatusHelper.getAmmoCount(stack);
    }
    public int getGunAmmoCapacity() {
        return GunStatusHelper.getAmmoCapacityCount(stack);
    }
    public int getGunFireMode() {
        return GunStatusHelper.getCurrentFireMode(stack);
    }
    public float getGunCoolDownOg() {
        return GunStatusHelper.getShootingCoolDownOg(stack);
    }
    public IBakedModel getIBakedModelFrom(String name) {
        return IBakedModelsJS.getIBakedModelByName(name);
    }
    public LivingEntity getPlayer() {
        return this.player;
    }
    public CompoundNBT getGunNBT() {
        return GunStatusHelper.getNBT(stack);
    }
    public ItemStack getGunItem() {
        return this.stack;
    }
    public ItemStack getUnderBarrelAttachment() {
        return GunStatusHelper.getUnderBarrelAttachment(stack);
    }
    public ItemStack getBarrelAttachment() {
        return GunStatusHelper.getBarrelAttachment(stack);
    }
    public ItemStack getSideRailAttachment() {
        return GunStatusHelper.getSideRailAttachment(stack);
    }
    public ItemStack getIRDeviceAttachment() {
        return GunStatusHelper.getIRDeviceAttachment(stack);
    }
    public ItemStack getStockAttachment() {
        return GunStatusHelper.getStockAttachment(stack);
    }
    public ItemStack getScopeAttachment() {
        return GunStatusHelper.getScopeAttachment(stack);
    }
    public void pushMatrices() {
        matrices.pushPose();
    }
    public void popMatrices() {
        matrices.popPose();
    }
    public void translateMatrices(double x, double y, double z) {
        matrices.translate(x, y, z);
    }
    public void scaleMatrices(float x, float y, float z) {
        matrices.scale(x, y, z);
    }
    public void applySpecialModelTransform(IBakedModel model, int index) {
        controller.applySpecialModelTransform(model, index, transformType, matrices);
    }
    public void renderModel(IBakedModel model, int light, int overlay) {
        RenderUtil.renderModel(model, stack, matrices, renderBuffer, light, overlay);
    }
    public void renderLaserModuleModel(IBakedModel model, int light, int overlay) {
        RenderUtil.renderLaserModuleModel(model, GunStatusHelper.getSideRailAttachment(stack), matrices, renderBuffer, light, overlay);
    }
    public void offsetOptic(double x) {
        GunRenderingHandler.get().opticMovement = x;
    }
}
