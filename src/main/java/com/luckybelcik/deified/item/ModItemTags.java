package com.luckybelcik.deified.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> WISTERIA_LOGS = TagKey.of(RegistryKeys.ITEM, Identifier.of("deified", "wisteria_logs"));
}
