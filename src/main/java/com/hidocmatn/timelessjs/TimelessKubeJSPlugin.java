package com.hidocmatn.timelessjs;

import com.hidocmatn.timelessjs.custom.TimelessGunRegistryEventJS;
import com.hidocmatn.timelessjs.recipe.TimelessRecipeJS;
import dev.latvian.kubejs.KubeJSPlugin;
import dev.latvian.kubejs.recipe.RegisterRecipeHandlersEvent;

public class TimelessKubeJSPlugin extends KubeJSPlugin {
    @Override
    public void init() {}
    @Override
    public void initStartup() {
        new TimelessGunRegistryEventJS().post("gun.registry");
    }
    @Override
    public void addRecipes(RegisterRecipeHandlersEvent event) {
        event.register("tac:workbench", TimelessRecipeJS::new);
    }
}
