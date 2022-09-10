package com.example.examplemod.common.block.entity;

import com.example.examplemod.common.screen.TestCraftingMenu;
import com.example.examplemod.core.init.BlockEntityMod;
import com.example.examplemod.core.init.ItemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TestCraftingBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public TestCraftingBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BlockEntityMod.TEST_CRAFTING_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Test Crafting Bench");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new TestCraftingMenu(pContainerId, pInventory, this);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? lazyItemHandler.cast() : super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, TestCraftingBlockEntity blockEntity) {
        if (hasRecipe(blockEntity) && hasNotReachedStackLimit(blockEntity)) {
            craftItem(blockEntity);
        }
    }

    private static void craftItem(TestCraftingBlockEntity blockEntity) {
        blockEntity.itemHandler.extractItem(0, 1, false);
        blockEntity.itemHandler.extractItem(2, 1, false);
        blockEntity.itemHandler.getStackInSlot(1).hurt(1, new Random(), null);

        blockEntity.itemHandler.setStackInSlot(3, new ItemStack(Items.DIAMOND, blockEntity.itemHandler.getStackInSlot(3).getCount() + 1));
    }

    private static boolean hasRecipe(TestCraftingBlockEntity blockEntity) {
        boolean hasItemInWaterSlot = PotionUtils.getPotion(blockEntity.itemHandler.getStackInSlot(0)) == Potions.WATER;
        boolean hasItemInFirstSlot = blockEntity.itemHandler.getStackInSlot(1).getItem() == ItemMod.TEST_SWORD.get();
        boolean hasItemInSecondSlot = blockEntity.itemHandler.getStackInSlot(2).getItem() == Items.ACACIA_BOAT;

        return hasItemInWaterSlot && hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static boolean hasNotReachedStackLimit(TestCraftingBlockEntity blockEntity) {
        return blockEntity.itemHandler.getStackInSlot(3).getCount() < blockEntity.itemHandler.getStackInSlot(3).getMaxStackSize();
    }
}
