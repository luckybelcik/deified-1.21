package com.luckybelcik.deified.block;

import com.luckybelcik.deified.Deified;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLESSED_DIRT = registerBlock("blessed_dirt",
            new Block(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.GRAVEL)));
        public static final Block PROTECTED_BLESSED_DIRT = registerBlock("protected_blessed_dirt",
            new Block(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block BLESSED_GRASS_BLOCK = registerBlock("blessed_grass_block",
            new Block(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.GRASS)));
        public static final Block PROTECTED_BLESSED_GRASS_BLOCK = registerBlock("protected_blessed_grass_block",
            new Block(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.GRASS)));

        // STONES AND STUFF

    public static final VeldableBlock LIMESTONE = (VeldableBlock) registerBlock("limestone",
            new VeldableBlock(AbstractBlock.Settings.create()
                    .strength(0.8f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final VeldableBlock LIMESTONE_BRICKS = (VeldableBlock) registerBlock("limestone_bricks",
            new VeldableBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final VeldableBlock COBBLED_LIMESTONE = (VeldableBlock) registerBlock("cobbled_limestone",
            new VeldableBlock(AbstractBlock.Settings.create()
                    .strength(1.2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));

    public static final Block MARBLE = registerBlock("marble",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final Block SMOOTH_MARBLE = registerBlock("smooth_marble",
            new Block(AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final Block SMOOTH_MARBLE_SLAB = registerBlock("smooth_marble_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final Block SMOOTH_MARBLE_STAIRS = registerBlock("smooth_marble_stairs",
            new StairsBlock(SMOOTH_MARBLE.getDefaultState()
                    , AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final Block MARBLE_BRICKS = registerBlock("marble_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.4f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));
    public static final Block CHISELED_MARBLE = registerBlock("chiseled_marble",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(1.4f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));


        // PLANTS AND STUFF

    public static final FlowerBlock HYDRANGEA_FLOWER = (FlowerBlock) registerBlock("hydrangea_flower",
            new FlowerBlock(
                    SuspiciousStewEffectsComponent.DEFAULT,
                    AbstractBlock.Settings.create()
                        .breakInstantly()
                        .noCollision()
                        .breakInstantly()
                        .sounds(BlockSoundGroup.GRASS)
                        .offset(AbstractBlock.OffsetType.XZ)
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .nonOpaque()
            ));

    public static final BushyLeafBlock HYDRANGEA_LEAVES = (BushyLeafBlock) registerBlock("hydrangea_leaves",
            new BushyLeafBlock(AbstractBlock.Settings.create()));

    public static final MultipleFlowerBlock SPIDER_LILY = (MultipleFlowerBlock) registerBlock("spider_lily", new MultipleFlowerBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_RED)
    ));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Deified.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Deified.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks() {
        Deified.LOGGER.info("Registering Mod Blocks for " + Deified.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {

        });
    }
}
