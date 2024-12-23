package com.luckybelcik.deified.block;

import com.luckybelcik.deified.Deified;
import com.luckybelcik.deified.block.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModBlocks {

    public static final Block BLESSED_DIRT = registerBlock("blessed_dirt",
            new Block(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.GRAVEL)));
        public static final Block PROTECTED_BLESSED_DIRT = registerBlock("protected_blessed_dirt",
            new Block(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block BLESSED_GRASS_BLOCK = registerBlock("blessed_grass_block",
            new Block(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.GRASS)));
        public static final Block PROTECTED_BLESSED_GRASS_BLOCK = registerBlock("protected_blessed_grass_block",
            new Block(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.GRASS)));

        // BUILDING BLOCKS

    public static final ModDirectionalSlab ROOF_TILES = (ModDirectionalSlab) registerBlock("roof_tiles",
            new ModDirectionalSlab(AbstractBlock.Settings.create().strength(0.8f).sounds(BlockSoundGroup.STONE).requiresTool()));

        // STONES AND STUFF

    public static final VeldableBlock LIMESTONE = (VeldableBlock) registerBlock("limestone",
            new VeldableBlock(AbstractBlock.Settings.create().strength(0.8f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final VeldableBlock LIMESTONE_BRICKS = (VeldableBlock) registerBlock("limestone_bricks",
            new VeldableBlock(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final VeldableBlock DAMAGED_LIMESTONE_BRICKS = (VeldableBlock) registerBlock("damaged_limestone_bricks",
            new VeldableBlock(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final VeldableBlock COBBLED_LIMESTONE = (VeldableBlock) registerBlock("cobbled_limestone",
            new VeldableBlock(AbstractBlock.Settings.create().strength(1.2f).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block MARBLE = registerBlock("marble",
            new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SMOOTH_MARBLE = registerBlock("smooth_marble",
            new Block(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SMOOTH_MARBLE_SLAB = registerBlock("smooth_marble_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SMOOTH_MARBLE_STAIRS = registerBlock("smooth_marble_stairs",
            new StairsBlock(SMOOTH_MARBLE.getDefaultState()
                    ,AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block MARBLE_BRICKS = registerBlock("marble_bricks",
            new Block(AbstractBlock.Settings.create().strength(1.4f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block CHISELED_MARBLE = registerBlock("chiseled_marble",
            new PillarBlock(AbstractBlock.Settings.create().strength(1.4f).sounds(BlockSoundGroup.STONE).requiresTool()));

        // WOOD

    public static final PillarBlock WISTERIA_LOG = (PillarBlock) registerBlock("wisteria_log",
            createModLogBlock(MapColor.PALE_PURPLE, MapColor.TERRACOTTA_PURPLE));
    public static final PillarBlock STRIPPED_WISTERIA_LOG = (PillarBlock) registerBlock("stripped_wisteria_log",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block WISTERIA_PLANKS = registerBlock("wisteria_planks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

        // PLANTS AND STUFF

    public static final CarpetBlock VELD_CARPET = (CarpetBlock) registerBlock("veld_carpet",
            new CarpetBlock(
                    AbstractBlock.Settings.create()
                            .hardness(0.2f)
                            .sounds(BlockSoundGroup.MOSS_CARPET)
            ));
    public static final Block VELD_BLOCK = registerBlock("veld_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .hardness(0.4f)
                            .sounds(BlockSoundGroup.MOSS_CARPET)
            ));

    public static final FlowerBlock HYDRANGEA_FLOWER = (FlowerBlock) registerBlock("hydrangea_flower",
            new FlowerBlock(
                    SuspiciousStewEffectsComponent.DEFAULT,
                    AbstractBlock.Settings.create()
                            .breakInstantly()
                            .noCollision()
                            .sounds(BlockSoundGroup.GRASS)
                            .offset(AbstractBlock.OffsetType.XZ)
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .nonOpaque()
            ));
    public static final BushyLeafBlock HYDRANGEA_LEAVES = (BushyLeafBlock) registerBlock("hydrangea_leaves",
            new BushyLeafBlock(AbstractBlock.Settings.create()));

    public static final Block WISTERIA_LEAVES = registerBlock("wisteria_leaves",
            createModLeavesBlock(BlockSoundGroup.CHERRY_LEAVES));
    public static final Block WISTERIA_SAPLING = registerBlock("wisteria_sapling",
            new SaplingBlock(SaplingGenerator.OAK, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HANGING_WISTERIA_VINES = registerBlock("hanging_wisteria_vines",
            new ModHangingWisteriaVinesBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));

    public static final MultipleFlowerBlock SPIDER_LILY = (MultipleFlowerBlock) registerBlock("spider_lily", new MultipleFlowerBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_RED)
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Deified.MOD_ID, name), block);
    }

    public static Block createModLogBlock(MapColor topMapColor, MapColor sideMapColor) {
		return new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> {
			return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor;
		}).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable());
	}

    public static Block createModLeavesBlock(BlockSoundGroup soundGroup) {
		return new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly().sounds(soundGroup).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
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
