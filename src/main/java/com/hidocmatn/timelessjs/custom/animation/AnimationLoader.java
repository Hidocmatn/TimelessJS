package com.hidocmatn.timelessjs.custom.animation;

import com.hidocmatn.timelessjs.custom.animation.controller.CustomController;

import java.util.HashSet;
import java.util.Set;

public class AnimationLoader {
    public static final Set<CustomController> customControllerSet = new HashSet<>();
    public static void registerController(CustomController controller) {
        customControllerSet.add(controller);
    }
    public static void tryLoading() {
        customControllerSet.forEach(controller -> {
            controller.tryLoadAnimation();
        });
    }
}
