package net.iegeliers.themakkersmod.block;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.block.custom.BlockKnakworstOven;
import net.iegeliers.themakkersmod.block.custom.BlockMoosStatue;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class TMMBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheMakkersMod.MODID);


    // Blocks

    public static final RegistryObject<Block> BLOCK_OF_KNAKWORST = registerBlock("block_of_knakworst",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1.0F, 1.5F)
                    .sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> KNAKWORST_OVEN = registerBlock("knakworst_oven",
            () -> new BlockKnakworstOven(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 1.5F)
                    .sound(SoundType.STONE).randomTicks().requiresCorrectToolForDrops().lightLevel(litBlockEmission(13))));

    // Villagers job site blocks
    public static final RegistryObject<Block> SALESMAN_BLOCK = registerBlock("salesman_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 1.5F)
                    .sound(SoundType.WOOD)));

    // Models
    public static final RegistryObject<Block> MOOS_STATUE = registerBlock("moos_statue",
            () -> new BlockMoosStatue(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 3.0F)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));


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
    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }

    // Event bus
    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}