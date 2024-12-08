package com.luckybelcik.deified.item;

import com.luckybelcik.deified.Deified;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.item.Items.GLASS_BOTTLE;

public class ModItems {
    public static final Item NEXUS = registerItem("nexus", new Item(new Item.Settings()));
    public static final Item DEBUG_TOOLS = registerItem("debug_tools", new Item(new Item.Settings()));
    public static final Item HOLY_WATER_BOTTLE = registerItem("holy_water_bottle", new Item(
            new Item.Settings().recipeRemainder(GLASS_BOTTLE)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Deified.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Deified.LOGGER.info("Registering Mod Items for " + Deified.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(NEXUS);
        });
    }
}
