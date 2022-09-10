package com.example.examplemod.core.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> TREES_SAVANNA =
            PlacementUtils.register("trees_savanna", ModConfiguredFeatures.TREES_SAVANNA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));

    public static final Holder<PlacedFeature> TREES_SPARSE_JUNGLE =
            PlacementUtils.register("trees_sparse_jungle", ModConfiguredFeatures.TREES_SPARSE_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> TREES_SNOWY =
            PlacementUtils.register("trees_snowy", TreeFeatures.SPRUCE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1), Blocks.SPRUCE_SAPLING));
}
