package net.iegeliers.themakkersmod.block.custom;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class BlockMoosStatue extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public BlockMoosStatue(BlockBehaviour.Properties p_53627_) {
        super(p_53627_);
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Shapes.or(box(5, 7.5, 13, 11, 13.5, 17), box(9, 13.5, 14, 11, 15.5, 15), box(5, 13.5, 14, 7, 15.5, 15), box(6.5, 7.52, 16, 9.5, 10.52, 20), box(5, 8, -1, 11, 14.25, 8), box(4, 8, 8, 12, 14.75, 13), box(5.5, 0, 0, 7.5, 8, 2),
                    box(8.5, 0, 0, 10.5, 8, 2), box(5.5, 0, 11, 7.5, 8, 13), box(8.5, 0, 11, 10.5, 8, 13), box(7, 4, -3, 9, 12, -1));
            case NORTH -> Shapes.or(box(5, 7.5, -1, 11, 13.5, 3), box(5, 13.5, 1, 7, 15.5, 2), box(9, 13.5, 1, 11, 15.5, 2), box(6.5, 7.52, -4, 9.5, 10.52, 0), box(5, 8, 8, 11, 14.25, 17), box(4, 8, 3, 12, 14.75, 8), box(8.5, 0, 14, 10.5, 8, 16),
                    box(5.5, 0, 14, 7.5, 8, 16), box(8.5, 0, 3, 10.5, 8, 5), box(5.5, 0, 3, 7.5, 8, 5), box(7, 4, 17, 9, 12, 19));
            case EAST -> Shapes.or(box(13, 7.5, 5, 17, 13.5, 11), box(14, 13.5, 5, 15, 15.5, 7), box(14, 13.5, 9, 15, 15.5, 11), box(16, 7.52, 6.5, 20, 10.52, 9.5), box(-1, 8, 5, 8, 14.25, 11), box(8, 8, 4, 13, 14.75, 12), box(0, 0, 8.5, 2, 8, 10.5),
                    box(0, 0, 5.5, 2, 8, 7.5), box(11, 0, 8.5, 13, 8, 10.5), box(11, 0, 5.5, 13, 8, 7.5), box(-3, 4, 7, -1, 12, 9));
            case WEST -> Shapes.or(box(-1, 7.5, 5, 3, 13.5, 11), box(1, 13.5, 9, 2, 15.5, 11), box(1, 13.5, 5, 2, 15.5, 7), box(-4, 7.52, 6.5, 0, 10.52, 9.5), box(8, 8, 5, 17, 14.25, 11), box(3, 8, 4, 8, 14.75, 12), box(14, 0, 5.5, 16, 8, 7.5),
                    box(14, 0, 8.5, 16, 8, 10.5), box(3, 0, 5.5, 5, 8, 7.5), box(3, 0, 8.5, 5, 8, 10.5), box(17, 4, 7, 19, 12, 9));
        };
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }
}
