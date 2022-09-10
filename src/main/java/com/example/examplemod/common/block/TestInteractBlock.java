package com.example.examplemod.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;

public class TestInteractBlock extends Block {
    public TestInteractBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState pState, @Nonnull Level pLevel, @Nonnull BlockPos pPos, @Nonnull Player pPlayer, @Nonnull InteractionHand pHand, @Nonnull BlockHitResult pHit) {
//        Minecraft.getInstance().player.sendMessage(new TranslatableComponent("test",  0));
        return InteractionResult.SUCCESS;
    }
}
