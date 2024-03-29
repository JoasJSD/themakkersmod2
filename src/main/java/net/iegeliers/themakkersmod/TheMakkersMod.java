package net.iegeliers.themakkersmod;

import com.mojang.logging.LogUtils;
import net.iegeliers.themakkersmod.block.TMMBlocks;
import net.iegeliers.themakkersmod.block.custom.entity.TMMBlockEntity;
import net.iegeliers.themakkersmod.block.custom.menu.TMMMenuType;
import net.iegeliers.themakkersmod.block.custom.screen.ScreenKnakworstOven;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.iegeliers.themakkersmod.misc.TMMCreativeModeTabs;
import net.iegeliers.themakkersmod.sound.TMMSounds;
import net.iegeliers.themakkersmod.villager.TMMVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheMakkersMod.MODID)
public class TheMakkersMod
{
    public static final String MODID = "themakkersmod";
    public static final CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public TheMakkersMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);

        TMMItems.register(modEventBus);
        TMMBlocks.register(modEventBus);
        TMMMenuType.register(modEventBus);
        TMMBlockEntity.register(modEventBus);
        TMMVillagers.register(modEventBus);
        TMMSounds.SOUNDEVENT.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(TMMVillagers::registerPOIs);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(TMMMenuType.KNAKWORST_OVEN_MENU.get(), ScreenKnakworstOven::new);
        }
    }
}
