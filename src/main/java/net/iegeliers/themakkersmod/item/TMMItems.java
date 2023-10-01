package net.iegeliers.themakkersmod.item;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.item.custom.ItemMicrophone;
import net.iegeliers.themakkersmod.sound.TMMSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TMMItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheMakkersMod.MODID);

    // Food
    public static final RegistryObject<Item> KNAKWORST = ITEMS.register("knakworst",
            () -> new Item(new Item.Properties().food(TMMEdibleItems.KNAKWORST)));
    public static final RegistryObject<Item> HOT_KNAKWORST = ITEMS.register("hot_knakworst",
            () -> new Item(new Item.Properties().food(TMMEdibleItems.HOT_KNAKWORST)));
    public static final RegistryObject<Item> BREAD_WITH_KNAKWORST = ITEMS.register("bread_with_knakworst",
            () -> new Item(new Item.Properties().food(TMMEdibleItems.BREAD_WITH_KNAKWORST)));

    // Normal Items
    public static final RegistryObject<Item> MICROPHONE = ITEMS.register("microphone",
            () -> new ItemMicrophone((new Item.Properties()).stacksTo(1).food(TMMEdibleItems.MICROPHONE)));
    public static final RegistryObject<Item> EATEN_MICROPHONE = ITEMS.register("eaten_microphone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAN_OF_KNAKWORST = ITEMS.register("can_of_knakworst",
            () -> new Item(new Item.Properties()));

    // Semi-tools
    public static final RegistryObject<Item> CAN_OPENER = ITEMS.register("can_opener",
            () -> new Item(new Item.Properties().stacksTo(1)));

    // Music Disks
    public static final RegistryObject<Item> MUSIC_DISC_DON = ITEMS.register("music_disc_don",
            () -> new RecordItem(8, TMMSounds.MUSIC_DISC_DON, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1160));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}