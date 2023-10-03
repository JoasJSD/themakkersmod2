package net.iegeliers.themakkersmod.block.custom.entity;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.block.TMMBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TMMBlockEntity {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheMakkersMod.MODID);

    public static final RegistryObject<BlockEntityType<BlockEntityKnakworstOven>> KNAKWORST_OVEN =
            BLOCK_ENTITIES.register("knakworst_oven", () -> BlockEntityType.Builder.of
                    (BlockEntityKnakworstOven::new, TMMBlocks.KNAKWORST_OVEN.get()).build(null)
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
