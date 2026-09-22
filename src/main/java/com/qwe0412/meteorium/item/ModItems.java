package com.qwe0412.meteorium.item;

import com.qwe0412.meteorium.Meteorium;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Meteorium.MODID);

    //private static final ResourceLocation EMPTY_SLOTS_METEORIUM_UPGRADE = ResourceLocation.fromNamespaceAndPath("meteorium", "empty_slots_meteorium_upgrade");

    public static final DeferredItem<Item> METEORIUM_UPGRADE = ITEMS.register(
            "meteorium_upgrade",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.minecraft.smithing_template.netherite_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.meteorium.meteorium_ingot").withStyle(ChatFormatting.BLUE),
                    Component.translatable("upgrade.meteorium.meteorium_upgrade").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.minecraft.smithing_template.netherite_upgrade.base_slot_description"),
                    Component.translatable("item.meteorium.meteorium_ingot.add"),
                    List.of(),
                    List.of()
            )
    );

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

    public static final DeferredItem<Item> METEORIUM_INGOT = ITEMS.register(
            "meteorium_ingot",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
