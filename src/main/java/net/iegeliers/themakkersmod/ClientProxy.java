package net.iegeliers.themakkersmod;

import net.iegeliers.themakkersmod.client.gui.GUIUpdateBook;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = TheMakkersMod.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public void openUpdateBookGUI(ItemStack itemStackIn) {
        Minecraft.getInstance().setScreen(new GUIUpdateBook(itemStackIn));
    }
}
