package com.example.examplemod.core.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.core.init.utility.BiomeUtils;
import com.example.examplemod.core.world.ModOverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeMod {

    public static final ResourceKey<Biome> TEST = BiomeUtils.createBiomeKey("test");

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().register(ModOverworldBiomes.testBiome().setRegistryName(TEST.location()));
    }
}
