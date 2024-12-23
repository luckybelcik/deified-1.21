package com.luckybelcik.deified;

import com.luckybelcik.deified.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

public class DeifiedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIMESTONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIMESTONE_BRICKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COBBLED_LIMESTONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPIDER_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WISTERIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_WISTERIA_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HYDRANGEA_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HYDRANGEA_LEAVES, RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xe6ca85, ModBlocks.VELD_CARPET);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xe6ca85, ModBlocks.VELD_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xe6ca85, ModBlocks.LIMESTONE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xe6ca85, ModBlocks.LIMESTONE_BRICKS);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xe6ca85, ModBlocks.COBBLED_LIMESTONE);
    }
}
