package com.example.examplemod.core.init.utility;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockUtils {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static RegistryObject<Block> createBasicBlock(String name, Material material, float strength) {
        return createBasicBlock(name, material, strength, CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static RegistryObject<Block> createBasicBlock(String name, Material material, float hardness, float resistance) {
        return createBasicBlock(name, material, hardness, resistance, CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static RegistryObject<Block> createBasicBlock(String name, Material material, float strength, CreativeModeTab tab) {
        return createBasicBlock(name, material, strength, strength, tab);
    }

    public static RegistryObject<Block> createBasicBlock(String name, Material material, float hardness, float resistance, CreativeModeTab tab) {
        return register(name, () -> new Block(props(material).strength(hardness, resistance).requiresCorrectToolForDrops()), ItemUtils.props(tab));
    }

    public static BlockBehaviour.Properties props() { return props(Material.STONE); }
    public static BlockBehaviour.Properties props(Material material) {
        return BlockBehaviour.Properties.of(material);
    }
    public static BlockBehaviour.Properties props(Block copyBlock) {
        return BlockBehaviour.Properties.copy(copyBlock);
    }

    public static <T extends Block>RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemUtils.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
