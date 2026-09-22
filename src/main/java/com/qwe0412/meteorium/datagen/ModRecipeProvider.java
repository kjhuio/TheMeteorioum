package com.qwe0412.meteorium.datagen;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.METEORIUM_UPGRADE.get()), Ingredient.of(Items.DIAMOND_AXE), Ingredient.of(ModItems.METEORIUM_INGOT.get()), RecipeCategory.MISC,ModItems.METEORIUM_AXE.get())
                .unlocks("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "smithing/meteorium_axe"));
    }
}
