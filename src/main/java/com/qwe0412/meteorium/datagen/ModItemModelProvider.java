package com.qwe0412.meteorium.datagen;

import com.qwe0412.meteorium.Meteorium;
import com.qwe0412.meteorium.item.ModArmor;
import com.qwe0412.meteorium.item.ModItems;
import com.qwe0412.meteorium.item.ModTools;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Meteorium.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.METEORIUM_UPGRADE.get());
        basicItem(ModItems.METEORIUM_INGOT.get());
        basicItem(ModItems.METEORIUM_DUST.get());

        basicItem(ModArmor.METEORIUM_HELMET.get());
        basicItem(ModArmor.METEORIUM_CHESTPLATE.get());
        basicItem(ModArmor.METEORIUM_LEGGINGS.get());
        basicItem(ModArmor.METEORIUM_BOOTS.get());

        handheldItem(ModTools.METEORIUM_AXE.get());
        handheldItem(ModTools.METEORIUM_PICKAXE.get());
        handheldItem(ModTools.METEORIUM_SHOVEL.get());
        handheldItem(ModTools.METEORIUM_SWORD.get());
        handheldItem(ModTools.METEORIUM_HOE.get());
    }
}
