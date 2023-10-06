package net.iegeliers.themakkersmod.block.custom.entity;

import net.iegeliers.themakkersmod.block.custom.menu.MenuKnakworstOven;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockEntityKnakworstOven extends AbstractFurnaceBlockEntity {

    public BlockEntityKnakworstOven(BlockPos blockPos, BlockState blockState) {
        super(TMMBlockEntity.KNAKWORST_OVEN.get(), blockPos, blockState, RecipeType.SMOKING);
    }

    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.themakkersmod.knakworst_oven");
    }

    protected @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
        return new MenuKnakworstOven(id, inventory, this, this.dataAccess);
    }

    @Override
    protected int getBurnDuration(@NotNull ItemStack itemStack) {
        return (super.getBurnDuration(itemStack) * 3) / 2;
    }
}