package com.example.examplemod.core.init;

import com.example.examplemod.common.block.TestCraftingBlock;
import com.example.examplemod.common.block.TestInteractBlock;
import com.example.examplemod.core.init.utility.BlockUtils;
import com.example.examplemod.core.init.utility.ItemUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class BlockMod {
    public static final RegistryObject<Block> TEST_BASIC_BLOCK = BlockUtils.createBasicBlock("test_basic_block", Material.WOOD, 0.5f, CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> TEST_PILLAR_BLOCK = BlockUtils.register("test_pillar_block",
            () -> new RotatedPillarBlock(BlockUtils.props(Material.WOOD).strength(20.f)),
            ItemUtils.props(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final RegistryObject<Block> TEST_CRAFTING_BLOCK = BlockUtils.register("test_crafting_block",
            () -> new TestCraftingBlock(BlockUtils.props()),
            ItemUtils.props(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final RegistryObject<Block> TEST_INTERACT_BLOCK = BlockUtils.register("test_interact_block",
            () -> new TestInteractBlock(BlockUtils.props()),
            ItemUtils.props(CreativeModeTab.TAB_BUILDING_BLOCKS));
}
