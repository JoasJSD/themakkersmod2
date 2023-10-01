package net.iegeliers.themakkersmod.sound;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TMMSounds {
    public static final DeferredRegister<SoundEvent> SOUNDEVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheMakkersMod.MODID);
    public static final RegistryObject<SoundEvent> MUSIC_DISC_DON = createSoundEvent("music_disc_don");
    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return SOUNDEVENT.register(soundName, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TheMakkersMod.MODID, soundName)));
    }
}
