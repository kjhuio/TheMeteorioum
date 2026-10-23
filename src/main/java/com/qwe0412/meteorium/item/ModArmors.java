package com.qwe0412.meteorium.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModArmors {
    private static final int DURABILITY = 1073741824;

    public static final DeferredItem<Item> METEORIUM_BOOTS
            = ModItems.ITEMS.register(
                    "meteorium_boots",
            () -> new ArmorItem(
                    ModArmorMaterials.METEORIUM_ARMOR_MATERIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(DURABILITY)
            )
    );
    public static final DeferredItem<Item> METEORIUM_LEGGINGS
            = ModItems.ITEMS.register(
            "meteorium_leggings",
            () -> new ArmorItem(
                    ModArmorMaterials.METEORIUM_ARMOR_MATERIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(DURABILITY)
            )
    );
    public static final DeferredItem<Item> METEORIUM_CHESTPLATE
            = ModItems.ITEMS.register(
            "meteorium_chestplate",
            () -> new ArmorItem(
                    ModArmorMaterials.METEORIUM_ARMOR_MATERIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(DURABILITY)
            )
    );
    public static final DeferredItem<Item> METEORIUM_HELMET
            = ModItems.ITEMS.register(
            "meteorium_helmet",
            () -> new ArmorItem(
                    ModArmorMaterials.METEORIUM_ARMOR_MATERIAL,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().durability(DURABILITY)
            )
    );

    public static void addArmors() {
    }
}
