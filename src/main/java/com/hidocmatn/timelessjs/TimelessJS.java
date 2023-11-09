package com.hidocmatn.timelessjs;

import com.hidocmatn.timelessjs.custom.animation.AnimationLoader;
import com.hidocmatn.timelessjs.custom.animation.model.IBakedModelsJS;
import com.hidocmatn.timelessjs.custom.animation.model.GunOverrideModelsJS;
import com.tac.guns.client.render.gun.ModelOverrides;
import dev.latvian.kubejs.KubeJSRegistries;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TimelessJS.MOD_ID)
public class TimelessJS
{
    public static final String MOD_ID = "timelessjs";
//    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(TimelessJS.MOD_ID);

    public TimelessJS() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::onClientSetUp);
        bus.addListener(this::register);
        bus.addGenericListener(Item.class, this::registerGun);
    }

    private void registerGun(final RegistryEvent.Register<Item> event) {
        TimelessJSObjects.GUNS.forEach((id, builder) -> {
            Item gunItemJS = builder.type.createItem(builder);
            gunItemJS.setRegistryName(builder.id);
            event.getRegistry().register(gunItemJS);
        });
    }

    private void onClientSetUp(FMLClientSetupEvent event) {
        for (ResourceLocation gunID: GunOverrideModelsJS.CUSTOM_GUN_MAP.keySet()) {
            Item gunItem = (Item) KubeJSRegistries.items().get(gunID);
            ModelOverrides.register(gunItem, GunOverrideModelsJS.CUSTOM_GUN_MAP.get(gunID));
        }
        AnimationLoader.tryLoading();
    }

    @OnlyIn(Dist.CLIENT)
    private void register(ModelRegistryEvent event) {
        for (ResourceLocation modelPath : IBakedModelsJS.MODEL_REGISTER_MAP.values()) {
            ModelLoader.addSpecialModel(modelPath);
        }
    }
}
