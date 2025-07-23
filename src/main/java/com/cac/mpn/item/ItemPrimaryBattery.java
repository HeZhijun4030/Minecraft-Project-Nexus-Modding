package com.cac.mpn.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemPrimaryBattery extends Item {
    public static final String ENERGY_KEY = "Energy";
    public static final long MAX_ENERGY = 500L;

    public ItemPrimaryBattery() {
        this.setUnlocalizedName("primary_battery");
        this.setRegistryName("primary_battery");
        this.setCreativeTab(ModTabs.MPN_TAB);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1.0 - ((double)getEnergy(stack) / (double)MAX_ENERGY);
    }

    public static long getEnergy(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null || !tag.hasKey(ENERGY_KEY)) return MAX_ENERGY;
        return tag.getLong(ENERGY_KEY);
    }

    public static void setEnergy(ItemStack stack, long energy) {
        if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setLong(ENERGY_KEY, Math.max(0, Math.min(energy, MAX_ENERGY)));
    }

    @Override
    public void onCreated(ItemStack stack, net.minecraft.world.World worldIn, net.minecraft.entity.player.EntityPlayer playerIn) {
        setEnergy(stack, MAX_ENERGY);
    }
} 