package net.iegeliers.themakkersmod.item;

import net.minecraft.world.food.FoodProperties;

public class TMMEdibleItems {
    // Raw/Cold food
    public static final FoodProperties KNAKWORST =
            (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).build();

    // Cooked/Warm food
    public static final FoodProperties HOT_KNAKWORST =
            (new FoodProperties.Builder()).nutrition(8).saturationMod(3.0F).build();

    //Other food
    public static final FoodProperties BREAD_WITH_KNAKWORST =
            (new FoodProperties.Builder()).nutrition(12).saturationMod(4.5F).build();

    // "Food" hehe
    public static final FoodProperties MICROPHONE =
            (new FoodProperties.Builder()).nutrition(1).saturationMod(0.5F).build();
}
