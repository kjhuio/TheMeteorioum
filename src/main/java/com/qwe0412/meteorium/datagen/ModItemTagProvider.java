package com.qwe0412.meteorium.datagen;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.item.ModTools;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Meteorium.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.AXES)
                .add(ModTools.METEORIUM_AXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModTools.METEORIUM_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModTools.METEORIUM_SHOVEL.get());
        tag(ItemTags.SWORDS)
                .add(ModTools.METEORIUM_SWORD.get());
        tag(ItemTags.HOES)
                .add(ModTools.METEORIUM_HOE.get());
    }
}
