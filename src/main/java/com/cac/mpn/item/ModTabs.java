package com.cac.mpn.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModTabs {
    public static final CreativeTabs MPN_TAB = new CreativeTabs(CreativeTabs.getNextID(),"mpn_tab") {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Blocks.COMMAND_BLOCK).setUnlocalizedName("mpn_tab"));
        }
    }; }