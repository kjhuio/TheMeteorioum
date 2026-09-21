package com.qwe0412.meteorium.item;

import com.qwe0412.meteorium.Meteorium;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Meteorium.MODID);

    public static final DeferredItem<Item> METEORIUM_UPGRADE = ITEMS.register(
            "meteorium_upgrade",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
