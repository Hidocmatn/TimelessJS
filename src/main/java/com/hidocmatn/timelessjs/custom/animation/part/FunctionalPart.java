package com.hidocmatn.timelessjs.custom.animation.part;

import com.hidocmatn.timelessjs.custom.animation.lib.GunRenderBuilder;

import java.util.function.Consumer;

public interface FunctionalPart<T> {
    T setBodyModel(String modelName);
    T useCustomRenderMethod(boolean flag);
    T customRenderMethod(Consumer<GunRenderBuilder> callback);
}
