package com.luckybelcik.deified.item;

import com.luckybelcik.deified.Deified;
import com.luckybelcik.deified.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup EDEN_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Deified.MOD_ID, "eden_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.BLESSED_GRASS_BLOCK))
                    .displayName(Text.translatable("itemgroup.deified.eden_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModBlocks.BLESSED_GRASS_BLOCK);
                      entries.add(ModBlocks.BLESSED_DIRT);
                      entries.add(ModBlocks.PROTECTED_BLESSED_GRASS_BLOCK);
                      entries.add(ModBlocks.PROTECTED_BLESSED_DIRT);
                      entries.add(ModBlocks.LIMESTONE);
                      entries.add(ModBlocks.LIMESTONE_BRICKS);
                      entries.add(ModBlocks.COBBLED_LIMESTONE);
                      entries.add(ModBlocks.SPIDER_LILY);
                      entries.add(ModBlocks.HYDRANGEA_FLOWER);
                      entries.add(ModBlocks.HYDRANGEA_LEAVES);
                      entries.add(ModItems.HOLY_WATER_BOTTLE);
                    }).build());

    public static final ItemGroup DEIFIED_DEBUG = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Deified.MOD_ID, "deified_debug"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.DEBUG_TOOLS))
                    .displayName(Text.translatable("itemgroup.deified.deified_debug"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.DEBUG_TOOLS);
                    }).build());

    public static void registerItemGroups() {
        Deified.LOGGER.info("Registering Item Groups for " + Deified.MOD_ID);
    }
}
