package com.luckybelcik.deified.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

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
}
