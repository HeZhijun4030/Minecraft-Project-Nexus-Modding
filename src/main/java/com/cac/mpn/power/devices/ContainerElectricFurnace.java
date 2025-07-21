package com.cac.mpn.power.devices;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerElectricFurnace extends Container {
    private final ElectricFurnace tile;

    public ContainerElectricFurnace(InventoryPlayer playerInv, ElectricFurnace tile) {
        this.tile = tile;
        // 输入槽
        this.addSlotToContainer(new Slot(tile, 0, 56, 17));
        // 燃料槽（无用，仅占位）
        this.addSlotToContainer(new Slot(tile, 1, 56, 53));
        // 输出槽
        this.addSlotToContainer(new Slot(tile, 2, 116, 35) {
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
        // shift点击物品转移逻辑，可后续补充
        return ItemStack.EMPTY;
    }
} 