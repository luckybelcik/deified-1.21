package com.luckybelcik.deified.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.luckybelcik.deified.block.ModBlockTags.IS_VELD;

public class VeldableBlock extends Block {
    public static final BooleanProperty VELDED = BooleanProperty.of("velded");

    public VeldableBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(VELDED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(VELDED);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.getBlockState(pos.up()).isIn(IS_VELD)) {
            world.setBlockState(pos, state.with(VELDED, true));
        } else {
            world.setBlockState(pos, state.with(VELDED, false));
        }
    }
}
