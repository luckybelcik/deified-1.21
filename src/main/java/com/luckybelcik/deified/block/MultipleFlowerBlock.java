package com.luckybelcik.deified.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;


public class MultipleFlowerBlock extends FlowerbedBlock {
    	private static final BiFunction<Direction, Integer, VoxelShape> FACING_AND_AMOUNT_TO_SHAPE = Util.memoize(
		(BiFunction<Direction, Integer, VoxelShape>)((facing, flowerAmount) -> {
			VoxelShape[] voxelShapes = new VoxelShape[]{
				Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
				Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
				Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
				Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0)
			};
			VoxelShape voxelShape = VoxelShapes.empty();

			for (int i = 0; i < flowerAmount; i++) {
				int j = Math.floorMod(i - facing.getHorizontal(), 4);
				voxelShape = VoxelShapes.union(voxelShape, voxelShapes[j]);
			}

			return voxelShape.asCuboid();
		})
	);

	public MultipleFlowerBlock(@NotNull Settings settings) {
        super(
                settings.breakInstantly()
                        .noCollision()
                        .breakInstantly()
                        .sounds(BlockSoundGroup.GRASS)
                        .offset(AbstractBlock.OffsetType.XYZ)
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .nonOpaque()
        );
        setDefaultState(getDefaultState().with(FLOWER_AMOUNT, 1));
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return (VoxelShape)FACING_AND_AMOUNT_TO_SHAPE.apply((Direction)state.get(FACING), (Integer)state.get(FLOWER_AMOUNT));
	}
}