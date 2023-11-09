package com.hidocmatn.timelessjs.custom.registry;

import com.hidocmatn.timelessjs.TimelessJSObjects;
import dev.latvian.kubejs.generator.AssetJsonGenerator;
import dev.latvian.kubejs.item.ItemBuilder;
import dev.latvian.kubejs.item.custom.ItemType;
import net.minecraft.item.Item;
public class TimelessGunItemType{
    public final String name;
    public TimelessGunItemType(String n) {
        this.name = n;
    }

    public static final TimelessGunItemType INSTANCE = new TimelessGunItemType("gun");
    public Item createItem(TimelessItemBuilder itemBuilder) {
        return new TimelessGunItemJS(itemBuilder);
    }
    public void generateAssets(TimelessItemBuilder builder, AssetJsonGenerator generator) {
        generator.itemModel(builder.id, (assetGenerator) -> {
            assetGenerator.parent(builder.parentModel);
        });
    }
}
