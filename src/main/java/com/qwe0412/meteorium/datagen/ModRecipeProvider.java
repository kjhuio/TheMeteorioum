package com.qwe0412.meteorium.datagen;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.block.ModBlocks;
import com.qwe0412.meteorium.item.ModArmors;
import com.qwe0412.meteorium.item.ModItems;
import com.qwe0412.meteorium.item.ModTools;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        // Upgrade Diamond Tools to Meteorium Tools
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_AXE, ModTools.METEORIUM_AXE, RecipeCategory.COMBAT);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_SWORD, ModTools.METEORIUM_SWORD, RecipeCategory.COMBAT);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_PICKAXE, ModTools.METEORIUM_PICKAXE, RecipeCategory.TOOLS);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_SHOVEL, ModTools.METEORIUM_SHOVEL, RecipeCategory.TOOLS);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_HOE, ModTools.METEORIUM_HOE, RecipeCategory.TOOLS);

        // Upgrade Diamond Armor to Meteorium Armor
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_HELMET, ModArmors.METEORIUM_HELMET, RecipeCategory.COMBAT);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_CHESTPLATE, ModArmors.METEORIUM_CHESTPLATE, RecipeCategory.COMBAT);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_LEGGINGS, ModArmors.METEORIUM_LEGGINGS, RecipeCategory.COMBAT);
        upgradeToMeteorium(recipeOutput, Items.DIAMOND_BOOTS, ModArmors.METEORIUM_BOOTS, RecipeCategory.COMBAT);

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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "shapeless/meteorium_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METEORIUM_INGOT.get())
                .requires(Items.COPPER_INGOT)
                .requires(ModItems.METEORIUM_DUST.get())
                .unlockedBy("has_meteorium_dust", has(ModItems.METEORIUM_DUST.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "shapeless/dust_to_meteorium_ingot"));


    }

    private void upgradeToMeteorium(RecipeOutput recipeOut, Item base, DeferredItem<Item> result, RecipeCategory category) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(
                                ModItems.METEORIUM_UPGRADE.get()
                        ),
                        Ingredient.of(
                                base
                        ),
                        Ingredient.of(
                                ModItems.METEORIUM_INGOT.get()
                        ),
                        category,
                        result.get()
                ).unlocks("has_meteorium_ingot", has(ModItems.METEORIUM_INGOT.get()))
                .save(recipeOut, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, "smithing/" + getItemName(result.get())));
    }
}
