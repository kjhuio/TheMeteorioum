package com.qwe0412.meteorium.worldgen;

import com.mojang.datafixers.util.Pair;
import com.qwe0412.meteorium.Meteorium;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public class ModTemplatePools {
    public static final ResourceKey<StructureTemplatePool> METEORITE_POOL = registerKey("meteorite");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);

        context.register(
                METEORITE_POOL,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                Pair.of(
                                        StructurePoolElement
                                                .single("meteorium:meteorite")
                                                .apply(StructureTemplatePool.Projection.RIGID),
                                        1
                                )
                        )
                )
        );
    }

    public static ResourceKey<StructureTemplatePool> registerKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation.fromNamespaceAndPath(Meteorium.MODID, name));
    }
}
