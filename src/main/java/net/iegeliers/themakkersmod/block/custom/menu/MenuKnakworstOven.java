package net.iegeliers.themakkersmod.block.custom.menu;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.RecipeType;

public class MenuKnakworstOven extends AbstractFurnaceMenu {

    public MenuKnakworstOven(int p_39532_, Inventory p_39533_) {
        super(TMMMenuType.KNAKWORST_OVEN_MENU.get(), RecipeType.SMOKING, RecipeBookType.SMOKER, p_39532_, p_39533_);
    }

    public MenuKnakworstOven(int p_39535_, Inventory p_39536_, Container p_39537_, ContainerData p_39538_) {
        super(TMMMenuType.KNAKWORST_OVEN_MENU.get(), RecipeType.SMOKING, RecipeBookType.SMOKER, p_39535_, p_39536_, p_39537_, p_39538_);
    }
}