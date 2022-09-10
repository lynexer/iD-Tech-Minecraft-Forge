package com.example.examplemod.core.world.feature.trees;

import com.example.examplemod.core.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TestTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?,?>> getConfiguredFeature(@NotNull Random random, boolean bool) {
        return ModConfiguredFeatures.TEST_TREE;
    }
}
