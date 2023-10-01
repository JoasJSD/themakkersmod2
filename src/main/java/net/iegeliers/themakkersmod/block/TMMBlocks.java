package net.iegeliers.themakkersmod.block;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.block.custom.KnakworstOven;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TMMBlocks{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheMakkersMod.MODID);


    // Blocks
    public static final RegistryObject<Block> MOOS_STATUE = registerBlock("moos_statue",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLOCK_OF_KNAKWORST = registerBlock("block_of_knakworst",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1.0F, 1.5F)
                    .sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> KNAKWORST_OVEN = registerBlock("knakworst_oven",
            () -> new KnakworstOven(BlockBehaviour.Properties.of(Material.STONE).strength(1.0F, 1.5F)
                    .sound(SoundType.STONE).randomTicks()));



    // Block registry object
    private static <T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return TMMItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    // Event bus
    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}