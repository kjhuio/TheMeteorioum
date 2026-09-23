package com.qwe0412.meteorium.item;

import net.minecraft.world.item.*;
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
                                    7,
                                    -2.8f
                            )
                    )
            )
    );

    public static final DeferredItem<Item> METEORIUM_SHOVEL = ITEMS.register(
            "meteorium_shovel",
            () -> new ShovelItem(
                    ModTiers.METEORIUM,
                    new Item.Properties().attributes(
                            ShovelItem.createAttributes(
                                    ModTiers.METEORIUM,
                                    1.5F,
                                    -3.0F
                            )
                    )
            )
    );

    public static final DeferredItem<Item> METEORIUM_SWORD = ITEMS.register(
            "meteorium_sword",
            () -> new SwordItem(
                    ModTiers.METEORIUM,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    ModTiers.METEORIUM,
                                    6F,
                                    -2.4F
                            )
                    )
            )
    );

    public static final DeferredItem<Item> METEORIUM_HOE = ITEMS.register(
            "meteorium_hoe",
            () -> new HoeItem(
                    ModTiers.METEORIUM,
                    new Item.Properties().attributes(
                            HoeItem.createAttributes(
                                    ModTiers.METEORIUM,
                                    3F,
                                    0F
                            )
                    )
            )
    );

    public static void addTools() {

    }
}
