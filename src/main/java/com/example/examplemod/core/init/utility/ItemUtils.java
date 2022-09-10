package com.example.examplemod.core.init.utility;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemUtils {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static RegistryObject<Item> createBasicItem(String name, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new Item(props(tab)));
    }

    public static RegistryObject<Item> createFoodItem(String name, FoodProperties food) {
        return ITEMS.register(name, () -> new Item(props(CreativeModeTab.TAB_FOOD).food(food)));
    }

    public static Item.Properties props() { return props(CreativeModeTab.TAB_MISC); }
    public static Item.Properties props(CreativeModeTab tab) {
        return new Item.Properties().tab(tab);
    }
}
