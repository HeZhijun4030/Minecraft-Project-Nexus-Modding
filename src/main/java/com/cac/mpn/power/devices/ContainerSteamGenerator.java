package com.cac.mpn.power.devices;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerSteamGenerator extends Container {
    private final SteamGenerator tile;

    public ContainerSteamGenerator(InventoryPlayer playerInv, SteamGenerator tile) {
        this.tile = tile;

        this.addSlotToContainer(new Slot(tile, 0, 56, 53));

        this.addSlotToContainer(new Slot(tile, 1, 26, 53));
        this.addSlotToContainer(new Slot(tile, 2, 134, 53) {
            @Override
            public boolean isItemValid(ItemStack stack) { return false; }
        });
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlotToContainer(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlotToContainer(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tile.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        // shift点击物品转移逻辑，可后续补充
        return ItemStack.EMPTY;
    }
} 