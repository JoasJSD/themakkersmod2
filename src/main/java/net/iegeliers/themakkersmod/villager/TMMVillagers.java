package net.iegeliers.themakkersmod.villager;

        import com.google.common.collect.ImmutableSet;
        import net.iegeliers.themakkersmod.TheMakkersMod;
        import net.iegeliers.themakkersmod.block.TMMBlocks;
        import net.minecraft.sounds.SoundEvents;
        import net.minecraft.world.entity.ai.village.poi.PoiType;
        import net.minecraft.world.entity.npc.VillagerProfession;
        import net.minecraftforge.eventbus.api.IEventBus;
        import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
        import net.minecraftforge.registries.DeferredRegister;
        import net.minecraftforge.registries.ForgeRegistries;
        import net.minecraftforge.registries.RegistryObject;

        import java.lang.reflect.InvocationTargetException;

public class TMMVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TheMakkersMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TheMakkersMod.MODID);

    public static final RegistryObject<PoiType> KNAKWORST_OVEN_POI = POI_TYPES.register("knakworst_oven_poi",
            () -> new PoiType(ImmutableSet.copyOf(TMMBlocks.KNAKWORST_OVEN.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> KNAKWORST_BUTCHER = VILLAGER_PROFESSIONS.register("knakworst_butcher",
            () -> new VillagerProfession("knakworst_butcher", x -> x.get() == KNAKWORST_OVEN_POI.get(),
                    x -> x.get() == KNAKWORST_OVEN_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, KNAKWORST_OVEN_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}