package com.hidocmatn.timelessjs.custom.animation.lib;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.tac.guns.client.render.animation.module.GunAnimationController;
import com.tac.guns.client.util.RenderUtil;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;

public class GunRenderBuilder {
    public GunAnimationController controller;
    public ItemCameraTransforms.TransformType transformType;
    public ItemStack stack;
    public MatrixStack matrices;
    public IRenderTypeBuffer renderBuffer;
    public transient int light;
    public transient int overlay;
    public GunRenderBuilder(GunAnimationController controller, ItemCameraTransforms.TransformType transformType, ItemStack stack, MatrixStack matrices, IRenderTypeBuffer renderBuffer, int light, int overlay) {
        this.controller = controller;
        this.transformType = transformType;
        this.stack = stack;
        this.matrices = matrices;
        this.renderBuffer = renderBuffer;
        this.light = light;
        this.overlay = overlay;
    }
    public boolean isFirstPerson() {
        return this.transformType.firstPerson();
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
}
