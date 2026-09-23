package com.qwe0412.meteorium.item;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Meteorium.MODID);

    public static final Supplier<CreativeModeTab> THE_METEORIUM = CREATIVE_MODE_TAB.register(
            "the_meteorium",
            () -> CreativeModeTab.builder()
                    .icon(
                            () -> new ItemStack(ModItems.METEORIUM_INGOT.get())
                    )
                    .displayItems(
                            (itemDisplayParameters, output) -> {
                                output.accept(ModItems.METEORIUM_INGOT);
                                output.accept(ModBlocks.METEORIUM_BLOCK);
                                output.accept(ModItems.METEORIUM_UPGRADE);
                                output.accept(ModTools.METEORIUM_SWORD);
                                output.accept(ModTools.METEORIUM_AXE);
                                output.accept(ModTools.METEORIUM_PICKAXE);
                                output.accept(ModTools.METEORIUM_SHOVEL);
                            }
                    )
                    .title(Component.translatable("itemGroup.meteorium.the_meteorium").withStyle(Meteorium.MOD_THEME_COLOR))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}