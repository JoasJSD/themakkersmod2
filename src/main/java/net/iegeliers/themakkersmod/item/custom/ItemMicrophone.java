package net.iegeliers.themakkersmod.item.custom;

import net.iegeliers.themakkersmod.item.TMMItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemMicrophone extends Item {
    public ItemMicrophone(Item.Properties p_40682_) {
        super(p_40682_);
    }

    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack p_40684_, @NotNull Level p_40685_, @NotNull LivingEntity p_40686_) {
        ItemStack itemstack = super.finishUsingItem(p_40684_, p_40685_, p_40686_);
        return p_40686_ instanceof Player && ((Player)p_40686_).getAbilities().instabuild ? itemstack : new ItemStack(TMMItems.EATEN_MICROPHONE.get());
    }
}
