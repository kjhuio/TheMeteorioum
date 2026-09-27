package com.qwe0412.meteorium.datagen;

import com.qwe0412.meteorium.block.ModBlocks;
import com.qwe0412.meteorium.block.ModOres;
import com.qwe0412.meteorium.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.STAR_CINDER.get());
        add(ModBlocks.STARDUST_REVERIE.get(),
                block -> createSingleItemTable(ModItems.METEORIUM_UPGRADE.get())
                );
        dropSelf(ModBlocks.METEORIUM_BLOCK.get());
        add(
                ModOres.METEORIUM_ORE.get(),
                this::createMeteoriumOreDrops
        );
        add(
                ModOres.DEEPSLATE_METEORIUM_ORE.get(),
                this::createMeteoriumOreDrops
        );
    }

    protected LootTable.Builder createMeteoriumOreDrops(Block block) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
        return
                createSilkTouchDispatchTable(
                        block,
                        applyExplosionDecay(
                                block,
                                LootItem.lootTableItem(
                                        ModItems.METEORIUM_DUST.get()).apply(SetItemCountFunction.setCount(
                                            UniformGenerator.between(1.0f, 8.0f)
                                        )
                                ).apply(
                                        ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))
                                )
                        )
                );
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
