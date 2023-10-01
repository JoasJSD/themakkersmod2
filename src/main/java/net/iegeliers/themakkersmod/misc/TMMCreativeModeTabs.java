package net.iegeliers.themakkersmod.misc;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheMakkersMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TMMCreativeModeTabs {
    public static CreativeModeTab TMM_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TMM_TAB = event.registerCreativeModeTab(new ResourceLocation(TheMakkersMod.MODID, "themakkersmod_tab"),
                builder -> builder.icon(() -> new ItemStack(TMMItems.KNAKWORST.get())).title(Component.translatable("tab.themakkersmod_tab")));
    }
}
