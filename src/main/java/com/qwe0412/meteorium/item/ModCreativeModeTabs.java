package com.qwe0412.meteorium.item;

import com.qwe0412.meteorium.Meteorium;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Meteorium.MODID);

    public static final Supplier<CreativeModeTab> THE_METEORIUM = CREATIVE_MODE_TAB.register(
            "the_meteorium",
            () -> CreativeModeTab.builder()
                    .icon(ModItems.METEORIUM_INGOT::toStack)
                    .displayItems((itemDisplayParameters, output) ->
                            ModItems.ITEMS.getEntries().stream()
                                    .map(DeferredHolder::get)
                                    .forEach(output::accept)
                    )
                    .title(Component.translatable("itemGroup.meteorium.the_meteorium").withStyle(Meteorium.MOD_THEME_COLOR))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}