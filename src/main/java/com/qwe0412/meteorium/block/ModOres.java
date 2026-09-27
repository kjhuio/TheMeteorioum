package com.qwe0412.meteorium.block;

import com.qwe0412.meteorium.item.ModItems;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class ModOres {

    public static final DeferredBlock<Block> METEORIUM_ORE = registerBlock(
            "meteorium_ore",
            () -> new DropExperienceBlock(
                    ConstantInt.of(4),
                    BlockBehaviour.Properties.of()
                            .sound(SoundType.STONE)
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3f, 3f)
            )
    );

    public static final DeferredBlock<Block> DEEPSLATE_METEORIUM_ORE = registerBlock(
            "deepslate_meteorium_ore",
            () -> new DropExperienceBlock(
                    ConstantInt.of(4),
                    BlockBehaviour.Properties.of()
                            .sound(SoundType.DEEPSLATE)
                            .mapColor(MapColor.DEEPSLATE)
                            .requiresCorrectToolForDrops()
                            .strength(4.5f, 3f)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void addOres() {}
}
