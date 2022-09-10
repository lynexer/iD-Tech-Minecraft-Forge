package com.example.examplemod.core.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.common.entity.RaccoonEntity;
import com.example.examplemod.core.init.utility.EntityUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;

public class EntityMod {
    public static final RegistryObject<EntityType<RaccoonEntity>> RACCOON =
            EntityUtils.ENTITY_TYPES.register("raccoon",
                    () -> EntityType.Builder.of(RaccoonEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(ExampleMod.MODID, "raccoon").toString()));
}
