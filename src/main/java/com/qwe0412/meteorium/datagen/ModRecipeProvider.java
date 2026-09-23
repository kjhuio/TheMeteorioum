package com.qwe0412.meteorium.datagen;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.block.ModBlocks;
import com.qwe0412.meteorium.item.ModItems;
import com.qwe0412.meteorium.item.ModTools;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.METEORIUM_UPGRADE.get()),
                        Ingredient.of(Items.DIAMOND_AXE),
                        Ingredient.of(ModItems.METEORIUM_INGOT.get()),
                        RecipeCategory.MISC, ModTools.METEORIUM_AXE.get()
                ).unlocks("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "smithing/meteorium_axe"));
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(
                        ModItems.METEORIUM_UPGRADE.get()
                ),
                Ingredient.of(
                        Items.DIAMOND_PICKAXE
                ),
                Ingredient.of(
                        ModItems.METEORIUM_INGOT.get()
                ),
                RecipeCategory.MISC,
                ModTools.METEORIUM_PICKAXE.get()
                ).unlocks("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "smithing/meteorium_pickaxe"));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(
                                ModItems.METEORIUM_UPGRADE.get()
                        ),
                        Ingredient.of(
                                Items.DIAMOND_SHOVEL
                        ),
                        Ingredient.of(
                                ModItems.METEORIUM_INGOT.get()
                        ),
                        RecipeCategory.MISC,
                        ModTools.METEORIUM_SHOVEL.get()
                ).unlocks("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "smithing/meteorium_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.METEORIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.METEORIUM_INGOT.get())
                .unlockedBy("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "shaped/meteorium_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METEORIUM_INGOT.get(), 9)
                .requires(ModBlocks.METEORIUM_BLOCK.get())
                .unlockedBy("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "shapeless/meteorium_ingot"));
    }
}
