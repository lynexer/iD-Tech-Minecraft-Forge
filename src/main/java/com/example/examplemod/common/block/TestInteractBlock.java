package com.example.examplemod.common.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;
import java.util.Objects;

public class TestInteractBlock extends Block {
    public TestInteractBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState pState, @Nonnull Level pLevel, @Nonnull BlockPos pPos, @Nonnull Player pPlayer, @Nonnull InteractionHand pHand, @Nonnull BlockHitResult pHit) {
        ServerLevel sLevel = Objects.requireNonNull(Minecraft.getInstance().getSingleplayerServer()).getLevel(pLevel.dimension());
        pLevel.getLevelData().setRaining(false);
        pLevel.setThunderLevel(0.0f);
        pLevel.setRainLevel(0.0f);
        sLevel.setDayTime(1000);
        sLevel.setRainLevel(0.0f);
        // 13000 for night
        pPlayer.sendMessage(new TextComponent("Cleared Weather").plainCopy(), pPlayer.getUUID());
        return InteractionResult.SUCCESS;
    }
}
