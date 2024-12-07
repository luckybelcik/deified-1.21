package com.luckybelcik.deified;

import com.luckybelcik.deified.block.ModBlocks;
import com.luckybelcik.deified.item.ModItemGroups;
import com.luckybelcik.deified.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deified implements ModInitializer {
	public static final String MOD_ID = "deified";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}