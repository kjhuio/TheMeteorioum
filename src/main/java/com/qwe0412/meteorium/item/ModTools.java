package com.qwe0412.meteorium.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.qwe0412.meteorium.item.ModItems.ITEMS;

public class ModTools {

    public static final DeferredItem<Item> METEORIUM_AXE = ITEMS.register(
            "meteorium_axe",
            () -> new AxeItem(
                    ModTiers.METEORIUM,
                    new Item.Properties().attributes(
                            AxeItem.createAttributes(
                                    ModTiers.METEORIUM,
                                    15,
                                    -3.5f
                            )
                    ).durability(Integer.MAX_VALUE)
            )
    );

    public static final DeferredItem<Item> METEORIUM_PICKAXE = ITEMS.register(
            "meteorium_pickaxe",
            () -> new PickaxeItem(
                    ModTiers.METEORIUM,
                    new Item.Properties().attributes(
                            PickaxeItem.createAttributes(
                                    ModTiers.METEORIUM,
                                    4,
                                    -2.8f
                            )
                    )
            )
    );

    public static void addTools() {

    }
}
