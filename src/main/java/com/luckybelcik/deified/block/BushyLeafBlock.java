package com.luckybelcik.deified.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BushyLeafBlock extends Block {
    public static final IntProperty BUSH_VARIANT = IntProperty.of("bush_variant", 0, 6);

    public BushyLeafBlock(@NotNull AbstractBlock.Settings settings) {
        super(settings.strength(0.5f)
                .sounds(BlockSoundGroup.GRASS)
                .nonOpaque());
        setDefaultState(getDefaultState().with(BUSH_VARIANT, 0));
    }

    @Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(BUSH_VARIANT);
	}

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (Random.create().nextBetween(1, 3) == 3) {
            world.setBlockState(pos, state.with(BUSH_VARIANT, Random.create().nextBetween(1, 6))); }
        else {
            world.setBlockState(pos, state.with(BUSH_VARIANT, 0));
        }
    }
}
