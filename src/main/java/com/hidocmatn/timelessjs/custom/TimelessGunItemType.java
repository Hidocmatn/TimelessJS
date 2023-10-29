package com.hidocmatn.timelessjs.custom;

import dev.latvian.kubejs.item.ItemBuilder;
import dev.latvian.kubejs.item.custom.ItemType;
import net.minecraft.item.Item;

public class TimelessGunItemType extends ItemType {
    public TimelessGunItemType(String n) {
        super(n);
    }
    public static final TimelessGunItemType INSTANCE = new TimelessGunItemType("gun");
    @Override
    public Item createItem(ItemBuilder itemBuilder) {
        if (itemBuilder instanceof TimelessItemBuilder) {
            return new TimelessGunItemJS((TimelessItemBuilder)itemBuilder);
        }
        return null;
    }
    @Override
    public void applyDefaults(ItemBuilder builder) {
        super.applyDefaults(builder);
        builder.unstackable();
    }
}
