package com.cac.mpn.power.devices;

import com.cac.mpn.power.core.IPowerDevice;
import com.cac.mpn.power.core.SimplePowerTileEntity;
import com.cac.mpn.power.core.IWaterHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;


public class SteamGenerator extends SimplePowerTileEntity implements ISidedInventory {
    public static final int WATER_CAPACITY = 20000;
    public static final int WATER_CONSUME_PER_TICK = 1;
    public static final long POWER_PER_SECOND = 10L;
    public static final long POWER_PER_TICK = POWER_PER_SECOND / 20L;
    public static final long POWER_CAPACITY = 10000L;

    private final net.minecraftforge.fluids.FluidTank waterTank = new net.minecraftforge.fluids.FluidTank(WATER_CAPACITY) {
        @Override
        public boolean canFillFluidType(net.minecraftforge.fluids.FluidStack fluid) {
            return fluid != null && fluid.getFluid() != null && "water".equals(fluid.getFluid().getName());
        }
    };
    private NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY); // 0:燃料 1:水桶 2:空桶
    private int burnTime = 0;
    private int burnTimeTotal = 0;
    private int waterTickCounter = 0;

    public SteamGenerator() {
        super(POWER_CAPACITY, IPowerDevice.DeviceType.GENERATOR);
    }

    @Override
    public void onTick() {
        boolean dirty = false;
        // 修正水桶加水逻辑
        ItemStack bucketIn = inventory.get(1);
        if (!bucketIn.isEmpty() && bucketIn.getItem() == net.minecraft.init.Items.WATER_BUCKET
            && waterTank.getFluidAmount() + 1000 <= WATER_CAPACITY
            && inventory.get(2).isEmpty()) {
            waterTank.fill(new net.minecraftforge.fluids.FluidStack(net.minecraftforge.fluids.FluidRegistry.WATER, 1000), true);
            inventory.set(1, ItemStack.EMPTY);
            inventory.set(2, new ItemStack(net.minecraft.init.Items.BUCKET));
            dirty = true;
        }
        // 燃烧逻辑
        if (burnTime > 0) {
            burnTime--;
            if (waterTank.getFluidAmount() >= WATER_CONSUME_PER_TICK) {
                waterTank.drain(WATER_CONSUME_PER_TICK, true);
                waterTickCounter++;
                if (waterTickCounter >= 20) {
                    waterTickCounter = 0;
                    setStoredPower(getStoredPower() + POWER_PER_SECOND);
                    dirty = true;
                }
            } else {
                waterTickCounter = 0;
            }
        } else {
            ItemStack fuel = inventory.get(0);
            if (!fuel.isEmpty() && waterTank.getFluidAmount() >= WATER_CONSUME_PER_TICK) {
                int time = net.minecraft.tileentity.TileEntityFurnace.getItemBurnTime(fuel);
                if (time > 0) {
                    burnTimeTotal = burnTime = time;
                    fuel.shrink(1);
                    dirty = true;
                }
            }
        }
        if (dirty) {
            markDirty();
            if (world != null && !world.isRemote) {
                world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 3);
            }
        }
    }

    /**
     * 从相邻的IWaterHandler拉取水（如管道）
     */
    private void tryPullWaterFromAdjacent() {
        for (EnumFacing facing : EnumFacing.values()) {
            TileEntity te = world.getTileEntity(pos.offset(facing));
            if (te instanceof IWaterHandler) {
                IWaterHandler handler = (IWaterHandler) te;
                int needed = this.getWaterCapacity() - this.getWaterAmount();
                if (needed > 0) {
                    int pulled = handler.drainWater(Math.min(needed, 10000)); // 每次最多拉10L=10000mL
                    if (pulled > 0) {
                        this.fillWater(pulled);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 获取当前水量（毫升）
     */
    public int getWaterAmount() {
        return waterTank.getFluidAmount();
    }

    /**
     * 获取最大水量（毫升）
     */
    public int getWaterCapacity() {
        return WATER_CAPACITY;
    }

    /**
     * 向水箱注入水（毫升），返回实际注入量
     */
    public int fillWater(int amount) {
        if (amount <= 0) return 0;
        int filled = waterTank.fill(new net.minecraftforge.fluids.FluidStack(net.minecraftforge.fluids.FluidRegistry.WATER, amount), true);
        return filled;
    }

    @Override
    public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, net.minecraft.util.EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(waterTank);
        return super.getCapability(capability, facing);
    }

    // ISidedInventory实现
    private static final int[] SLOTS_TOP = new int[] {1}; // 水桶输入
    private static final int[] SLOTS_BOTTOM = new int[] {2}; // 空桶输出
    private static final int[] SLOTS_SIDE = new int[] {0}; // 燃料输入
    @Override
    public int getSizeInventory() { return inventory.size(); }
    @Override
    public boolean isEmpty() {
        for (ItemStack stack : inventory) if (!stack.isEmpty()) return false;
        return true;
    }
    @Override
    public ItemStack getStackInSlot(int index) { return inventory.get(index); }
    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stack = inventory.get(index);
        if (!stack.isEmpty()) {
            if (stack.getCount() <= count) {
                inventory.set(index, ItemStack.EMPTY);
                markDirty();
                return stack;
            } else {
                ItemStack result = stack.splitStack(count);
                if (stack.getCount() == 0) inventory.set(index, ItemStack.EMPTY);
                markDirty();
                return result;
            }
        }
        return ItemStack.EMPTY;
    }
    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = inventory.get(index);
        inventory.set(index, ItemStack.EMPTY);
        markDirty();
        return stack;
    }
    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory.set(index, stack);
        markDirty();
    }
    @Override
    public int getInventoryStackLimit() { return 64; }
    @Override
    public boolean isUsableByPlayer(net.minecraft.entity.player.EntityPlayer player) { return true; }
    @Override
    public void openInventory(net.minecraft.entity.player.EntityPlayer player) {}
    @Override
    public void closeInventory(net.minecraft.entity.player.EntityPlayer player) {}
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 0) return TileEntityFurnace.isItemFuel(stack);
        if (index == 1) return stack.getItem() == Items.WATER_BUCKET;
        return false;
    }
    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        if (side == EnumFacing.UP) return SLOTS_TOP;
        if (side == EnumFacing.DOWN) return SLOTS_BOTTOM;
        return SLOTS_SIDE;
    }
    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return isItemValidForSlot(index, itemStackIn);
    }
    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return index == 2;
    }
    @Override
    public void clear() { inventory.clear(); }
    @Override
    public String getName() { return "container.steam_generator"; }
    @Override
    public boolean hasCustomName() { return false; }
    @Override
    public net.minecraft.util.text.ITextComponent getDisplayName() {
        return new net.minecraft.util.text.TextComponentTranslation(getName());
    }

    // --- NBT ---
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

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        waterTank.readFromNBT(compound.getCompoundTag("WaterTank"));
        burnTime = compound.getInteger("BurnTime");
        burnTimeTotal = compound.getInteger("BurnTimeTotal");
        waterTickCounter = compound.getInteger("WaterTickCounter");
        net.minecraft.inventory.ItemStackHelper.loadAllItems(compound, inventory);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("WaterTank", waterTank.writeToNBT(new NBTTagCompound()));
        compound.setInteger("BurnTime", burnTime);
        compound.setInteger("BurnTimeTotal", burnTimeTotal);
        compound.setInteger("WaterTickCounter", waterTickCounter);
        net.minecraft.inventory.ItemStackHelper.saveAllItems(compound, inventory);
        return compound;
    }

    // --- Getter/Setter for GUI ---
    public net.minecraftforge.fluids.FluidTank getWaterTank() { return waterTank; }
    public ItemStack getFuelStack() { return inventory.get(0); }
    public int getBurnTime() { return burnTime; }
    public int getBurnTimeTotal() { return burnTimeTotal; }
    public int getWaterTickCounter() { return waterTickCounter; }
    public long getMaxPower() {
        return POWER_CAPACITY;
    }

    public void setFuelStack(ItemStack stack) { inventory.set(0, stack); }

    @Override
    public int getField(int id) { return 0; }
    @Override
    public void setField(int id, int value) {}
    @Override
    public int getFieldCount() { return 0; }
} 