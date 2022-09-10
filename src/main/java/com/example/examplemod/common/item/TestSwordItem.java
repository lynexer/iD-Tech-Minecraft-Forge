package com.example.examplemod.common.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class TestSwordItem extends SwordItem {
    public TestSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
}
