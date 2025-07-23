package com.cac.mpn.power.devices;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlloyMachine extends Container {
    private final AlloyMachineTileEntity tile;

    public ContainerAlloyMachine(InventoryPlayer playerInv, AlloyMachineTileEntity tile) {
        this.tile = tile;
        // 输入槽：0-锡丝，1-铜丝，2-钛锭
        this.addSlotToContainer(new Slot(tile, 0, 44, 35));
        this.addSlotToContainer(new Slot(tile, 1, 62, 35));
        this.addSlotToContainer(new Slot(tile, 2, 80, 35));
        this.addSlotToContainer(new Slot(tile, 4, 116, 17)); // 电池槽
        // 输出槽
        this.addSlotToContainer(new Slot(tile, 3, 134, 35) {
            @Override
            public boolean isItemValid(ItemStack stack) { return false; }
        });
        // 玩家背包
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
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            itemstack = stack.copy();
            int tileSlots = 5; // 0-4为机器槽
            if (index < tileSlots) {
                if (!this.mergeItemStack(stack, tileSlots, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // 电池
                if (com.cac.mpn.item.ItemPrimaryBattery.class.isInstance(stack.getItem())) {
                    if (!this.mergeItemStack(stack, 4, 5, false)) return ItemStack.EMPTY;
                } else if (stack.getItem() == com.cac.mpn.item.RegisterItem.TIN_WIRE) {
                    if (!this.mergeItemStack(stack, 0, 1, false)) return ItemStack.EMPTY;
                } else if (stack.getItem() == com.cac.mpn.item.RegisterItem.COPPER_WIRE) {
                    if (!this.mergeItemStack(stack, 1, 2, false)) return ItemStack.EMPTY;
                } else if (stack.getItem() == com.cac.mpn.item.RegisterItem.TITANIUM_INGOT) {
                    if (!this.mergeItemStack(stack, 2, 3, false)) return ItemStack.EMPTY;
                } else {
                    return ItemStack.EMPTY;
                }
            }
            if (stack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, stack);
        }
        return itemstack;
    }
} 