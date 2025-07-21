package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricFurnace extends SimplePowerTileEntity implements ISidedInventory {
    public static final int POWER_PER_SECOND = 100;
    public static final int POWER_PER_TICK = POWER_PER_SECOND / 20;
    public static final int POWER_CAPACITY = 10000;
    public static final int COOK_TIME = 200;

    private NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY); // 0:输入 1:燃料(无用) 2:输出
    private int cookTime = 0;
    private int cookTimeTotal = COOK_TIME;
    private boolean wasBurning = false;

    public ElectricFurnace() {
        super(POWER_CAPACITY, IPowerDevice.DeviceType.CONSUMER);
    }

    @Override
    public void onTick() {
        boolean dirty = false;
        ItemStack input = inventory.get(0);
        ItemStack output = inventory.get(2);
        ItemStack result = input.isEmpty() ? ItemStack.EMPTY : FurnaceRecipes.instance().getSmeltingResult(input);
        boolean canSmelt = !input.isEmpty() && !result.isEmpty() && (output.isEmpty() || (output.isItemEqual(result) && output.getCount() + result.getCount() <= output.getMaxStackSize()));
        boolean burning = getStoredPower() >= POWER_PER_TICK && canSmelt;
        if (burning) {
            setStoredPower(getStoredPower() - POWER_PER_TICK);
            cookTime++;
            if (cookTime >= cookTimeTotal) {
                if (canSmelt) {
                    if (output.isEmpty()) {
                        inventory.set(2, result.copy());
                    } else {
                        output.grow(result.getCount());
                    }
                    input.shrink(1);
                }
                cookTime = 0;
                dirty = true;
            }
        } else if (!canSmelt) {
            cookTime = 0;
        }
        if (wasBurning != burning) {
            dirty = true;
            wasBurning = burning;
        }
        if (dirty) {
            markDirty();
            if (world != null && !world.isRemote) {
                world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 3);
            }
        }
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public net.minecraft.network.play.server.SPacketUpdateTileEntity getUpdatePacket() {
        return new net.minecraft.network.play.server.SPacketUpdateTileEntity(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
    }


    @Override public int getSizeInventory() { return inventory.size(); }
    @Override public boolean isEmpty() { for (ItemStack stack : inventory) if (!stack.isEmpty()) return false; return true; }
    @Override public ItemStack getStackInSlot(int index) { return inventory.get(index); }
    @Override public ItemStack decrStackSize(int index, int count) { ItemStack stack = inventory.get(index); if (!stack.isEmpty()) { if (stack.getCount() <= count) { inventory.set(index, ItemStack.EMPTY); markDirty(); return stack; } else { ItemStack result = stack.splitStack(count); if (stack.getCount() == 0) inventory.set(index, ItemStack.EMPTY); markDirty(); return result; } } return ItemStack.EMPTY; }
    @Override public ItemStack removeStackFromSlot(int index) { ItemStack stack = inventory.get(index); inventory.set(index, ItemStack.EMPTY); markDirty(); return stack; }
    @Override public void setInventorySlotContents(int index, ItemStack stack) { inventory.set(index, stack); markDirty(); }
    @Override public int getInventoryStackLimit() { return 64; }
    @Override public boolean isUsableByPlayer(net.minecraft.entity.player.EntityPlayer player) { return true; }
    @Override public void openInventory(net.minecraft.entity.player.EntityPlayer player) {}
    @Override public void closeInventory(net.minecraft.entity.player.EntityPlayer player) {}
    @Override public boolean isItemValidForSlot(int index, ItemStack stack) { return index == 0; }
    @Override public int[] getSlotsForFace(EnumFacing side) { return new int[]{0,2}; }
    @Override public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) { return index == 0; }
    @Override public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) { return index == 2; }
    @Override public void clear() { inventory.clear(); }
    @Override public String getName() { return "container.electric_furnace"; }
    @Override public boolean hasCustomName() { return false; }
    @Override public net.minecraft.util.text.ITextComponent getDisplayName() { return new net.minecraft.util.text.TextComponentTranslation(getName()); }


    @Override
    public int getField(int id) {
        if (id == 0) return cookTime;
        if (id == 1) return cookTimeTotal;
        return 0;
    }
    @Override
    public void setField(int id, int value) {
        if (id == 0) cookTime = value;
        if (id == 1) cookTimeTotal = value;
    }
    @Override
    public int getFieldCount() {
        return 2;
    }
} 