package com.example.examplemod.core.init;

import com.example.examplemod.common.screen.TestCraftingMenu;
import com.example.examplemod.core.init.utility.MenuTypesUtils;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypesMod {
    public static final RegistryObject<MenuType<TestCraftingMenu>> TEST_CRAFTING_MENU = MenuTypesUtils.registerMenuType("test_crafting_menu", TestCraftingMenu::new);
}
