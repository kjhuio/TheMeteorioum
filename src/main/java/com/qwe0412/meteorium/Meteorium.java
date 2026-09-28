package com.qwe0412.meteorium;

import com.mojang.logging.LogUtils;
import com.qwe0412.meteorium.block.ModBlocks;
import com.qwe0412.meteorium.item.ModCreativeModeTabs;
import com.qwe0412.meteorium.item.ModItems;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Meteorium.MODID)
public class Meteorium {
    public static final String MODID = "meteorium";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Style MOD_THEME_COLOR = Style.EMPTY.withColor(TextColor.fromRgb(0xC7C7FF));

    public Meteorium(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("The Meteorium is loaded(common)");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        LOGGER.info("The Meteorium is loaded(client)");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("The Meteorium is loaded(server)");
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
