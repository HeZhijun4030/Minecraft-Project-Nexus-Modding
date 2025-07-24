package com.cac.mpn.item.Armor;

import com.cac.mpn.item.ModTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import com.cac.mpn.item.RegisterItem;

public class DataIngotArmor {
    public static class Helmet extends ItemArmor {
        public Helmet() {
            super(RegisterItem.DATA_INGOT_ARMOR_MATERIAL, 0, EntityEquipmentSlot.HEAD);
            setUnlocalizedName("data_ingot_helmet");
            setRegistryName("data_ingot_helmet");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
    public static class Chestplate extends ItemArmor {
        public Chestplate() {
            super(RegisterItem.DATA_INGOT_ARMOR_MATERIAL, 0, EntityEquipmentSlot.CHEST);
            setUnlocalizedName("data_ingot_chestplate");
            setRegistryName("data_ingot_chestplate");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
    public static class Leggings extends ItemArmor {
        public Leggings() {
            super(RegisterItem.DATA_INGOT_ARMOR_MATERIAL, 0, EntityEquipmentSlot.LEGS);
            setUnlocalizedName("data_ingot_leggings");
            setRegistryName("data_ingot_leggings");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
    public static class Boots extends ItemArmor {
        public Boots() {
            super(RegisterItem.DATA_INGOT_ARMOR_MATERIAL, 0, EntityEquipmentSlot.FEET);
            setUnlocalizedName("data_ingot_boots");
            setRegistryName("data_ingot_boots");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
} 