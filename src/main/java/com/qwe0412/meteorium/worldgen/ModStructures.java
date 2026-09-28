package com.qwe0412.meteorium.worldgen;

import com.qwe0412.meteorium.Meteorium;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class ModStructures {
    public static final ResourceKey<Structure> METEORITE_STRUCTURE = registerKey("meteorite");

    public static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                METEORITE_STRUCTURE,
                new JigsawStructure(
                        new Structure.StructureSettings(
                                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                                Map.of(),
                                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                                TerrainAdjustment.NONE
                        ),
                        pools.getOrThrow(ModTemplatePools.METEORITE_POOL),
                        1,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        false
                )
        );
    }

    public static ResourceKey<Structure> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, name));
    }
}
