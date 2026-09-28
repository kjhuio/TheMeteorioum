package com.qwe0412.meteorium.worldgen;

import com.qwe0412.meteorium.Meteorium;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSets {
    public static final ResourceKey<StructureSet> METEORITE_STRUCTURE_SET = registerKey("meteorite_structure");

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

        context.register(
                METEORITE_STRUCTURE_SET,
                new StructureSet(
                        structures.getOrThrow(ModStructures.METEORITE_STRUCTURE),
                        new RandomSpreadStructurePlacement(
                                8,
                                4,
                                RandomSpreadType.LINEAR,
                                262143
                        )
                )
        );
    }

    public static ResourceKey<StructureSet> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, name));
    }
}
