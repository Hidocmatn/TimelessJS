package com.hidocmatn.timelessjs.custom.animation.lib;

import com.tac.guns.client.handler.ShootingHandler;
import com.tac.guns.common.Gun;
import com.tac.guns.item.GunItem;
import com.tac.guns.item.attachment.IAttachment;
import com.tac.guns.util.GunModifierHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class GunStatusHelper {
    //Mostly of these methods were 'borrowed' from tac's source code ...
    public static Gun getGunFromItem(ItemStack stack) {
        Item stackItem = stack.getItem();
        if (stackItem instanceof GunItem) return ((GunItem) stackItem).getGun();
        else return null;
    }
    public static Gun getModifiedGunFromItem(ItemStack stack) {
        Item stackItem = stack.getItem();
        if (stackItem instanceof GunItem) return ((GunItem) stackItem).getModifiedGun(stack);
        else return null;
    }
    public static boolean hasAmmo(ItemStack stack) {
        return Gun.hasAmmo(stack);
    }
    public static int getAmmoCount(ItemStack stack) {
            CompoundNBT tag = stack.getOrCreateTag();
            return tag.getInt("AmmoCount");
    }
    public static int getAmmoCapacityCount(ItemStack stack) {
        return GunModifierHelper.getAmmoCapacity(stack, getModifiedGunFromItem(stack));
    }
    public static float getShootingCoolDownOg(ItemStack stack) {
        Gun gun = getGunFromItem(stack);
        float coolDownOg = ShootingHandler.get().getshootMsGap() / ShootingHandler.calcShootTickGap(gun.getGeneral().getRate()) < 0 ? 1 : ShootingHandler.get().getshootMsGap() / ShootingHandler.calcShootTickGap(gun.getGeneral().getRate());
        return coolDownOg;
    }
    public static ItemStack getAttachment(IAttachment.Type type, ItemStack stack) {
        return Gun.getAttachment(type, stack);
    }
    public static ItemStack getUnderBarrelAttachment(ItemStack stack) {
        return getAttachment(IAttachment.Type.UNDER_BARREL, stack);
    }
    public static ItemStack getBarrelAttachment(ItemStack stack) {
        return getAttachment(IAttachment.Type.BARREL, stack);
    }
    public static ItemStack getSideRailAttachment(ItemStack stack) {
        return getAttachment(IAttachment.Type.SIDE_RAIL, stack);
    }
    public static ItemStack getIRDeviceAttachment(ItemStack stack) {
        return getAttachment(IAttachment.Type.IR_DEVICE, stack);
    }
    public static ItemStack getStockAttachment(ItemStack stack) {
        return getAttachment(IAttachment.Type.STOCK, stack);
    }
    public static boolean isExtendedMagazineInstalled(ItemStack stack) {
        return (GunModifierHelper.getAmmoCapacity(stack) > -1);
    }
    public static boolean isScopeInstalled(ItemStack stack) {
        return (Gun.getScope(stack) == null);
    }
}
