package net.iegeliers.themakkersmod.client.gui;

import com.github.alexthe666.citadel.client.gui.GuiBasicBook;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GUIUpdateBook extends GuiBasicBook {

    private static final ResourceLocation ROOT = new ResourceLocation("themakkersmod:book/update_book/root.json");

    public GUIUpdateBook(ItemStack bookStack) {
        super(bookStack, Component.translatable("book.themakkersmod.update_book.root.title"));
    }

    public GUIUpdateBook(ItemStack bookStack, String page) {
        super(bookStack, Component.translatable("book.themakkersmod.update_book.root.title"));
        this.currentPageJSON = new ResourceLocation(this.getTextFileDirectory() + page + ".json");
    }

    protected int getBindingColor() {
        return 0X606B26;
    }

    public ResourceLocation getRootPage() {
        return ROOT;
    }

    public String getTextFileDirectory() {
        return "themakkersmod:book/update_book/";
    }
}