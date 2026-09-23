package com.qwe0412.meteorium.block;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Meteorium.MODID);

    public static final DeferredBlock<Block> STARDUST_REVERIE = registerBlock("stardust_reverie",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6.0F, 3600000.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .mapColor(MapColor.COLOR_BLACK)
                    .lightLevel(state -> 4)
            ));

    public static final DeferredBlock<Block> STAR_CINDER = registerBlock("star_cinder",
        () -> new Block(
                BlockBehaviour.Properties.of()
                        .strength(12.0F, 3600000.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)
                        .mapColor(MapColor.COLOR_BLACK)
        )
    );

    public static final DeferredBlock<Block> METEORIUM_BLOCK = registerBlock("meteorium_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(5.0F, 6.0F)
                            .mapColor(MapColor.METAL)
                            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .sound(SoundType.METAL)
                )
            );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
