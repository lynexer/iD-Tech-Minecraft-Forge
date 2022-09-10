package com.example.examplemod.core.init;

import com.example.examplemod.core.init.utility.BiomeUtils;
import com.example.examplemod.core.world.ModOverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;

public class BiomeMod {
    public static final ResourceKey<Biome> TEST_KEY = BiomeUtils.createBiomeKey("test");
    public static final RegistryObject<Biome> TEST = BiomeUtils.register(TEST_KEY, ModOverworldBiomes::testBiome);
}
