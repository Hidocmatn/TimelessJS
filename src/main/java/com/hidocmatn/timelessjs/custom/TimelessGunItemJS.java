package com.hidocmatn.timelessjs.custom;

import com.tac.guns.item.TransitionalTypes.TimelessGunItem;

public class TimelessGunItemJS extends TimelessGunItem {
    public TimelessGunItemJS(TimelessItemBuilder builder) {
        super((properties) -> {return builder.createItemProperties();}, builder.createIGunModifier());
    }
}
