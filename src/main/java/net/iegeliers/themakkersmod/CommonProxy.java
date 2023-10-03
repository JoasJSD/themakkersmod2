package net.iegeliers.themakkersmod;


import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import static net.iegeliers.themakkersmod.TheMakkersMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {
    public void openUpdateBookGUI(ItemStack itemStackIn) {
    }
}
