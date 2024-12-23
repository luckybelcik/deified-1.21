package com.luckybelcik.deified.block.custom;

import com.luckybelcik.deified.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ModHangingWisteriaVinesBlock extends AbstractPlantStemBlock {
	public static final BooleanProperty IS_BOTTOM = BooleanProperty.of("is_bottom");
    public static final MapCodec<ModHangingWisteriaVinesBlock> CODEC = createCodec(ModHangingWisteriaVinesBlock::new);
	protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);

    public MapCodec<ModHangingWisteriaVinesBlock> getCodec() {
		return CODEC;
	}

	public ModHangingWisteriaVinesBlock(Settings settings) {
		super(settings, Direction.DOWN, SHAPE, false, 0.1);
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(IS_BOTTOM, true));
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
	}

	protected int getGrowthLength(Random random) {
		return VineLogic.getGrowthLength(random);
	}

	protected Block getPlant() {
		return ModBlocks.HANGING_WISTERIA_VINES;
	}

	protected boolean chooseStemState(BlockState state) {
		return VineLogic.isValidForWeepingStem(state);
	}

	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(AGE);
	builder.add(IS_BOTTOM);
    }

	@Override
	protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		BlockPos blockPos = pos.offset(this.growthDirection.getOpposite());
		BlockState blockState = world.getBlockState(blockPos);
		if (!this.canAttachTo(blockState)) {
			return false;
		} else {
			return blockState.isOf(this.getStem()) || blockState.isOf(this.getPlant()) || blockState.isSideSolidFullSquare(world, blockPos, this.growthDirection) || blockState.isIn(BlockTags.LEAVES);
		}
	}

	@Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
		if (world.getBlockState(pos.down()).isOf(ModBlocks.HANGING_WISTERIA_VINES)) {
			world.setBlockState(pos, state.with(IS_BOTTOM, false));
		} else {
			world.setBlockState(pos, state.with(IS_BOTTOM, true));
		}
	}

	@Override
	protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (direction == this.growthDirection.getOpposite() && !state.canPlaceAt(world, pos)) {
			world.scheduleBlockTick(pos, this, 1);
		}

		if (direction != this.growthDirection || !neighborState.isOf(this) && !neighborState.isOf(this.getPlant())) {
			if (this.tickWater) {
				world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}

			return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
		} else {
			if (world.getBlockState(pos.down()).isOf(ModBlocks.HANGING_WISTERIA_VINES)) {
				return this.copyState(state, this.getPlant().getDefaultState().with(IS_BOTTOM, false));
			} else {
				return this.copyState(state, this.getPlant().getDefaultState());
			}
		}
	}
}
