package com.luckybelcik.deified.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import org.jetbrains.annotations.NotNull;

public class BushyLeafBlock extends Block {
    public BushyLeafBlock(@NotNull AbstractBlock.Settings settings) {
        super(settings.strength(0.5f)
                .sounds(BlockSoundGroup.GRASS)
                .nonOpaque());
    }
}
