package com.example.examplemod;

import com.example.examplemod.core.init.BiomeMod;
import com.example.examplemod.core.init.BlockMod;
import com.example.examplemod.core.init.ItemMod;
import com.example.examplemod.core.init.utility.BiomeUtils;
import com.example.examplemod.core.init.utility.BlockUtils;
import com.example.examplemod.core.init.utility.ItemUtils;
import com.example.examplemod.core.networking.ModMessages;
import com.example.examplemod.core.world.region.OverworldRegion;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;
import terrablender.api.Regions;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "examplemod";
    public enum GUI_ENUM {
        TEST_CRAFTING
    }

    public ExampleMod() {
        final var bus = FMLJavaModLoadingContext.get().getModEventBus();

        new ItemMod();
        new BlockMod();
        new BiomeMod();
        ItemUtils.ITEMS.register(bus);
        BlockUtils.BLOCKS.register(bus);
        BiomeUtils.BIOMES.register(bus);

        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new OverworldRegion(new ResourceLocation(MODID, "overworld"), 2));
        });

        ModMessages.register();
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }
}
