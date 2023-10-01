package net.iegeliers.themakkersmod.block.custom.entity;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.level.block.Block;

public class TMMFurnaceMenu extends FurnaceMenu {
    private final Block workbench;
    private final ContainerLevelAccess worldPos;

    public TMMFurnaceMenu(int id, Inventory playerInv, ContainerLevelAccess worldPos, Block workbench) {
        super(id, playerInv);
        this.workbench = workbench;
        this.worldPos = worldPos;
    }

    protected static boolean isWithinUsableDistance(ContainerLevelAccess worldPos, Player playerIn, Block targetBlock) {
        return worldPos.evaluate((world, pos) ->
        {
            return world.getBlockState(pos).getBlock() == targetBlock && playerIn.distanceToSqr((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D;
        }, true);
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return isWithinUsableDistance(this.worldPos, playerIn, this.workbench);
    }
}