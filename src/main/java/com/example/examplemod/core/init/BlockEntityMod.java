package com.example.examplemod.core.init;

import com.example.examplemod.common.block.entity.TestCraftingBlockEntity;
import com.example.examplemod.core.init.utility.BlockEntityUtils;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityMod {
    public static final RegistryObject<BlockEntityType<TestCraftingBlockEntity>> TEST_CRAFTING_BLOCK_ENTITY = BlockEntityUtils.BLOCK_ENTITES.register("test_crafting_block_entity",
            () -> BlockEntityType.Builder.of(TestCraftingBlockEntity::new, BlockMod.TEST_CRAFTING_BLOCK.get()).build(null));
}
