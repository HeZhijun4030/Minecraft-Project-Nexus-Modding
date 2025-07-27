package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import com.cac.mpn.item.RegisterItem;
import com.cac.mpn.Block.RegisterBlock;

public class AlloyMachineTileEntity extends SimplePowerTileEntity implements ISidedInventory {
    public static final int POWER_PER_SECOND = 250;
    public static final int POWER_PER_TICK = POWER_PER_SECOND / 20;
    public static final int POWER_CAPACITY = 10000;
    public static final int WORK_TIME = 100; // 5秒

    private NonNullList<ItemStack> inventory = NonNullList.withSize(6, ItemStack.EMPTY); // 0:锡丝 1:铜丝 2:钛锭 3:输出 4:电池 5:预留
    private int workTime = 0;

    public AlloyMachineTileEntity() {
        super(POWER_CAPACITY, IPowerDevice.DeviceType.CONSUMER);
    }

    @Override
    public void onTick() {
        // 电池能量拉取逻辑
        ItemStack battery = inventory.get(4);
        if (battery != null && battery.getItem() instanceof com.cac.mpn.item.ItemPrimaryBattery) {
            long batteryEnergy = com.cac.mpn.item.ItemPrimaryBattery.getEnergy(battery);
            long need = Math.min(POWER_PER_TICK * 2, getCapacity() - getStoredPower()); // 一次最多拉2tick能量
            if (batteryEnergy > 0 && need > 0) {
                long transfer = Math.min(need, batteryEnergy);
                setStoredPower(getStoredPower() + transfer);
                com.cac.mpn.item.ItemPrimaryBattery.setEnergy(battery, batteryEnergy - transfer);
                if (com.cac.mpn.item.ItemPrimaryBattery.getEnergy(battery) <= 0) {
                    inventory.set(4, ItemStack.EMPTY);
                }
                markDirty();
            }
        }
        
        boolean canWork = canWork();
        boolean dirty = false;
        if (canWork) {
            // 持续消耗电力
            if (isDataIngotRecipe()) {
                // 数据锭配方：每秒消耗11,000K ZF
                long powerPerTick = 11000000 / 20; // 11,000K ZF / 20 ticks = 550K RF/tick
                if (getStoredPower() >= powerPerTick) {
                    setStoredPower(getStoredPower() - powerPerTick);
                    workTime++;
                    if (workTime >= WORK_TIME) {
                        doWork();
                        workTime = 0;
                        dirty = true;
                    }
                }
            } else if (isTitaniumAlloyRecipe()) {
                // 钛合金锭配方：每秒消耗20K ZF
                long powerPerTick = 20000 / 20; // 20K ZF / 20 ticks = 1K RF/tick
                if (getStoredPower() >= powerPerTick) {
                    setStoredPower(getStoredPower() - powerPerTick);
                    workTime++;
                    if (workTime >= WORK_TIME) {
                        doWork();
                        workTime = 0;
                        dirty = true;
                    }
                }
            }
        } else {
            workTime = 0;
        }
        if (dirty) markDirty();
    }

    private boolean isDataIngotRecipe() {
        ItemStack slot0 = inventory.get(0);
        ItemStack slot1 = inventory.get(1);
        ItemStack slot2 = inventory.get(2);
        ItemStack output = inventory.get(3);
        
        boolean hasMaterials = !slot0.isEmpty() && slot0.getItem() == net.minecraft.init.Items.DIAMOND &&
                             !slot1.isEmpty() && slot1.getItem() == net.minecraft.init.Items.EMERALD &&
                             !slot2.isEmpty() && slot2.getItem() == net.minecraft.item.Item.getItemFromBlock(RegisterBlock.TITANIUM_ALLOY_BLOCK);
        
        boolean canOutput = output.isEmpty() || (output.getItem() == RegisterItem.DATA_INGOT && output.getCount() < output.getMaxStackSize());
        
        return hasMaterials && canOutput;
    }

    private boolean isTitaniumAlloyRecipe() {
        ItemStack slot0 = inventory.get(0);
        ItemStack slot1 = inventory.get(1);
        ItemStack slot2 = inventory.get(2);
        ItemStack output = inventory.get(3);
        
        boolean hasMaterials = !slot0.isEmpty() && slot0.getItem() == RegisterItem.COPPER_WIRE &&
                             !slot1.isEmpty() && slot1.getItem() == RegisterItem.ZINC_WIRE &&
                             !slot2.isEmpty() && slot2.getItem() == RegisterItem.TITANIUM_INGOT && slot2.getCount() >= 3;
        
        boolean canOutput = output.isEmpty() || (output.getItem() == RegisterItem.TITANIUM_ALLOY_INGOT && output.getCount() < output.getMaxStackSize());
        
        return hasMaterials && canOutput;
    }

    private boolean canWork() {
        return isDataIngotRecipe() || isTitaniumAlloyRecipe();
    }

    private void doWork() {
        ItemStack slot0 = inventory.get(0);
        ItemStack slot1 = inventory.get(1);
        ItemStack slot2 = inventory.get(2);
        ItemStack output = inventory.get(3);
        
        // 检查数据锭配方
        if (!slot0.isEmpty() && slot0.getItem() == net.minecraft.init.Items.DIAMOND &&
            !slot1.isEmpty() && slot1.getItem() == net.minecraft.init.Items.EMERALD &&
            !slot2.isEmpty() && slot2.getItem() == net.minecraft.item.Item.getItemFromBlock(RegisterBlock.TITANIUM_ALLOY_BLOCK)) {
            
            // 消耗输入材料
            inventory.get(0).shrink(1); // 钻石
            inventory.get(1).shrink(1); // 绿宝石
            inventory.get(2).shrink(1); // 钛合金块
            
            // 产出数据锭
            if (output.isEmpty()) {
                inventory.set(3, new ItemStack(RegisterItem.DATA_INGOT));
            } else {
                output.grow(1);
            }
        }
        // 检查钛合金锭配方
        else if (!slot0.isEmpty() && slot0.getItem() == RegisterItem.COPPER_WIRE &&
                 !slot1.isEmpty() && slot1.getItem() == RegisterItem.ZINC_WIRE &&
                 !slot2.isEmpty() && slot2.getItem() == RegisterItem.TITANIUM_INGOT && slot2.getCount() >= 3) {
            
            // 消耗输入材料
            inventory.get(0).shrink(1); // 铜线
            inventory.get(1).shrink(1); // 锌线
            inventory.get(2).shrink(3); // 3个钛锭
            
            // 产出钛合金锭
            if (output.isEmpty()) {
                inventory.set(3, new ItemStack(RegisterItem.TITANIUM_ALLOY_INGOT));
            } else {
                output.grow(1);
            }
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (world != null && !world.isRemote) {
            world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 3);
        }
    }
    @Override
    public net.minecraft.nbt.NBTTagCompound getUpdateTag() {
        return writeToNBT(new net.minecraft.nbt.NBTTagCompound());
    }
    @Override
    public net.minecraft.network.play.server.SPacketUpdateTileEntity getUpdatePacket() {
        return new net.minecraft.network.play.server.SPacketUpdateTileEntity(pos, 1, getUpdateTag());
    }
    @Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
    }

    // ISidedInventory实现（略，后续可补充）
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
    @Override public boolean isItemValidForSlot(int index, ItemStack stack) { return index < 3 || index == 4; }
    @Override public int[] getSlotsForFace(EnumFacing side) { return new int[]{0,1,2,3,4}; }
    @Override public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) { return index < 3 || index == 4; }
    @Override public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) { return index == 3; }
    @Override public void clear() { inventory.clear(); }
    @Override public String getName() { return "container.alloy_machine"; }
    @Override public boolean hasCustomName() { return false; }
    @Override public net.minecraft.util.text.ITextComponent getDisplayName() { return new net.minecraft.util.text.TextComponentTranslation(getName()); }
    @Override public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("WorkTime", workTime);
        net.minecraft.inventory.ItemStackHelper.saveAllItems(compound, inventory);
        return compound;
    }
    @Override public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        workTime = compound.getInteger("WorkTime");
        net.minecraft.inventory.ItemStackHelper.loadAllItems(compound, inventory);
    }
    public int getWorkTime() { return workTime; }
    public int getWorkTimeTotal() { return WORK_TIME; }
    @Override public int getField(int id) {
        if (id == 0) return workTime;
        if (id == 1) return getWorkTimeTotal();
        if (id == 2) return (int) getStoredPower();
        if (id == 3) return (int) getCapacity();
        return 0;
    }
    @Override public void setField(int id, int value) {
        if (id == 0) workTime = value;
        // 其他字段只读
    }
    @Override public int getFieldCount() { return 4; }
} 