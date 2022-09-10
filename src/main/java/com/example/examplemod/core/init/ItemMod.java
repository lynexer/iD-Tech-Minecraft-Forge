package com.example.examplemod.core.init;

import com.example.examplemod.common.item.TestArmourItem;
import com.example.examplemod.common.item.TestFoodItem;
import com.example.examplemod.common.item.TestSwordItem;
import com.example.examplemod.core.init.utility.ItemUtils;
import com.example.examplemod.common.item.armour.ModArmourMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.RegistryObject;

public class ItemMod {
    public static final RegistryObject<Item> TEST_SWORD = ItemUtils.ITEMS.register("test_sword",
            () -> new TestSwordItem(ToolTiers.TEST, 3, -2.2f, ItemUtils.props(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> TEST_FOOD = ItemUtils.ITEMS.register("test_food",
            () -> new TestFoodItem(ItemUtils.props(CreativeModeTab.TAB_FOOD).food(Foods.TEST_FOOD)));

    public static final RegistryObject<Item> TEST_HELMET = ItemUtils.ITEMS.register("test_helmet",
            () -> new TestArmourItem(ArmourTiers.EXAMPLE, EquipmentSlot.HEAD, ItemUtils.props(CreativeModeTab.TAB_COMBAT)));

    public static class Foods {
        public static final FoodProperties TEST_FOOD = new FoodProperties.Builder().nutrition(8).saturationMod(1.4f).build();
    }

    public static class ToolTiers {
        public static final ForgeTier TEST = new ForgeTier(60, 156, 50f, 100f, 0, null, () -> Ingredient.of(Items.ACACIA_BOAT));
    }

    public static class ArmourTiers {
        public static final ArmorMaterial EXAMPLE = new ModArmourMaterial("example", 500, new int[] { 20, 40, 50, 10 }, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.of(TEST_FOOD.get()));
    }
}
