package com.luckybelcik.deified.block;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> IS_VELD = TagKey.of(RegistryKeys.BLOCK, Identifier.of("deified", "is_veld"));
}
