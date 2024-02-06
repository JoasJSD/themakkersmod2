package net.iegeliers.themakkersmod.misc;

import net.iegeliers.themakkersmod.block.TMMBlocks;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TMMCreativeModeTabs {
    @SubscribeEvent
    public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation( "themakkersmod_tab"),
                builder -> builder.title(Component.translatable("tab.themakkersmod_tab")).icon(() ->
                        new ItemStack(TMMItems.KNAKWORST.get())).displayItems((parameters, tabData) -> {

                    tabData.accept(TMMItems.KNAKWORST.get());
                    tabData.accept(TMMItems.HOT_KNAKWORST.get());
                    tabData.accept(TMMItems.BREAD_WITH_KNAKWORST.get());
                    tabData.accept(TMMItems.MUSIC_DISC_DON.get());
                    tabData.accept(TMMBlocks.KNAKWORST_OVEN.get().asItem());
                    tabData.accept(TMMBlocks.BLOCK_OF_KNAKWORST.get().asItem());
                    tabData.accept(TMMItems.CAN_OF_KNAKWORST.get());
                    tabData.accept(TMMItems.CAN_OPENER.get());
                    tabData.accept(TMMItems.EATEN_MICROPHONE.get());
                    tabData.accept(TMMItems.MICROPHONE.get());
                    tabData.accept(TMMBlocks.MOOS_STATUE.get().asItem());
                    tabData.accept(TMMItems.CAT_FOOD.get());
                    tabData.accept(TMMBlocks.SALESMAN_BLOCK.get().asItem());
                }));
    }
}
