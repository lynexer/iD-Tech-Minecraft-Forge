package com.example.examplemod.core.init.utility;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BiomeUtils {
    @Nullable
    private static final Music NORMAL_MUSIC = null;
    public  static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, ExampleMod.MODID);

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier) {
        return BIOMES.register(key.location().getPath(), biomeSupplier);
    }

    public static ResourceKey<Biome> createBiomeKey(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ExampleMod.MODID, name));
    }

    private static int calculateSkyColour(float colour) {
        float $$1 = colour/3.0f;
        $$1 = Mth.approach($$1, -1.0f, 1.0f);
        return Mth.color(0.62222224f - $$1 + 0.05f, 0.5f + $$1 + 0.1f, 1.0f);
    }

    public static Biome biome(Biome.Precipitation precipitation, float temp, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return biome(precipitation, temp, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
    }

    public static Biome biome(Biome.Precipitation precipitation, float temp, float downfall, int waterColour, int waterFogColour, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return biome(precipitation, temp, downfall, waterColour, waterFogColour, 12638463, calculateSkyColour(temp), spawnBuilder, biomeBuilder, music);
    }

    public static Biome biome(Biome.Precipitation precipitation, float temp, float downfall, int waterColour, int waterFogColour, int fogColour, int skyColour, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temp).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(skyColour).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome biomeWithColourOverrides(Biome.Precipitation precipitation, float temp, float downfall, int grassColour, int foliageColour, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return biomeWithColourOverrides(precipitation, temp, downfall, 4159204, 329011, grassColour, foliageColour, spawnBuilder, biomeBuilder, music);
    }

    public static Biome biomeWithColourOverrides(Biome.Precipitation precipitation, float temp, float downfall, int waterColour, int waterFogColour, int grassColour, int foliageColour, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return biomeWithColourOverrides(precipitation, temp, downfall, waterColour, waterFogColour, 12638463, grassColour, foliageColour, calculateSkyColour(temp), spawnBuilder, biomeBuilder, music);
    }

    public static Biome biomeWithColourOverrides(Biome.Precipitation precipitation, float temp, float downfall, int waterColour, int waterFogColour, int fogColour, int grassColour, int foliageColour, int skyColour, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temp).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).grassColorOverride(grassColour).foliageColorOverride(foliageColour).skyColor(skyColour).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome biomeWithColourOverridesAndParticles(Biome.Precipitation precipitation, float temp, float downfall, int waterColour, int waterFogColour, int fogColor, int grassColour, int foliageColour, int skyColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, ParticleOptions particleOptions, float particleProbability, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temp).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColor).grassColorOverride(grassColour).foliageColorOverride(foliageColour).skyColor(skyColor).ambientParticle(new AmbientParticleSettings(particleOptions, particleProbability)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static void globalOverworldGenerationNoLavaLakes(BiomeGenerationSettings.Builder builder) {
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        builder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}
