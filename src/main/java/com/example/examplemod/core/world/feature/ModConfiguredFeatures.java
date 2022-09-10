package com.example.examplemod.core.world.feature;

import com.example.examplemod.core.init.BlockMod;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TEST_TREE =
            FeatureUtils.register("test_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.NETHERRACK),
                    new StraightTrunkPlacer(5,6,3),
                    BlockStateProvider.simple(Blocks.ACACIA_PLANKS),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.SAND)).build());

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_SAVANNA =
            FeatureUtils.register("trees_plains", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                    List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(TreeFeatures.FANCY_OAK_BEES_005), 0.33333334F)),
                    PlacementUtils.inlinePlaced(TreeFeatures.OAK_BEES_005)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_TAIGA =
            FeatureUtils.register("trees_taiga", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                    List.of(new WeightedPlacedFeature(TreePlacements.PINE_CHECKED, 0.33333334F)), TreePlacements.SPRUCE_CHECKED));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_SPARSE_JUNGLE =
            FeatureUtils.register("trees_sparse_jungle", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                    List.of(new WeightedPlacedFeature(TreePlacements.FANCY_OAK_CHECKED, 0.1F),
                            new WeightedPlacedFeature(TreePlacements.JUNGLE_BUSH, 0.5F)),
                    TreePlacements.JUNGLE_TREE_CHECKED));
}
