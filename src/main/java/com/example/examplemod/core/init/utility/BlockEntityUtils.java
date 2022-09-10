package com.example.examplemod.core.init.utility;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityUtils {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ExampleMod.MODID);
}
