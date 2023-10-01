package net.iegeliers.themakkersmod;

import com.mojang.logging.LogUtils;
import net.iegeliers.themakkersmod.block.TMMBlocks;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.iegeliers.themakkersmod.misc.TMMCreativeModeTabs;
import net.iegeliers.themakkersmod.sound.TMMSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    private static final Logger LOGGER = LogUtils.getLogger();

    public TheMakkersMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        TMMItems.register(modEventBus);
        TMMBlocks.register(modEventBus);
        TMMSounds.SOUNDEVENT.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == TMMCreativeModeTabs.TMM_TAB) {
            // Items
            event.accept(TMMItems.KNAKWORST);
            event.accept(TMMItems.HOT_KNAKWORST);
            event.accept(TMMItems.BREAD_WITH_KNAKWORST);
            event.accept(TMMItems.MICROPHONE);
            event.accept(TMMItems.EATEN_MICROPHONE);
            event.accept(TMMItems.CAN_OPENER);
            event.accept(TMMItems.CAN_OF_KNAKWORST);
            event.accept(TMMItems.MUSIC_DISC_DON);
            // Blocks
            event.accept(TMMBlocks.BLOCK_OF_KNAKWORST);
        }
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
        }
    }
}
