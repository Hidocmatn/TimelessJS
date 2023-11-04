package com.hidocmatn.timelessjs;

import com.hidocmatn.timelessjs.custom.animation.AnimationLoader;
import com.hidocmatn.timelessjs.custom.animation.controller.CustomController;
import com.hidocmatn.timelessjs.custom.animation.lib.IBakedModelsJS;
import com.hidocmatn.timelessjs.custom.animation.model.GunOverrideModelsJS;
import com.tac.guns.client.render.gun.ModelOverrides;
import dev.latvian.kubejs.KubeJSRegistries;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
//        // Register the setup method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
//        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onClientSetUp(FMLClientSetupEvent event) {
        for (ResourceLocation gunID: GunOverrideModelsJS.CUSTOM_GUN_MAP.keySet()) {
            Item gunItem = (Item) KubeJSRegistries.items().get(gunID);
            ModelOverrides.register(gunItem, GunOverrideModelsJS.CUSTOM_GUN_MAP.get(gunID));
        }
        AnimationLoader.tryLoading();
    }

    @OnlyIn(Dist.CLIENT)
    public void register(ModelRegistryEvent event) {
        for (ResourceLocation modelPath : IBakedModelsJS.MODEL_REGISTER_MAP.values()) {
            ModelLoader.addSpecialModel(modelPath);
        }
    }

//    private void setup(final FMLCommonSetupEvent event)
//    {
////        // some preinit code
////        LOGGER.info("HELLO FROM PREINIT");
////        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//    }

//    private void doClientStuff(final FMLClientSetupEvent event) {
//        // do something that can only be done on the client
//        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
//    }

//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }

//    private void processIMC(final InterModProcessEvent event)
//    {
//        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
//    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }
}
