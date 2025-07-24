package com.cac.mpn.item.Armor;

import com.cac.mpn.item.ModTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import com.cac.mpn.item.RegisterItem;

public class TitaniumAlloyArmor {
    public static class Helmet extends ItemArmor {
        public Helmet() {
            super(RegisterItem.TITANIUM_ALLOY_ARMOR_MATERIAL, 0, EntityEquipmentSlot.HEAD);
            setUnlocalizedName("titanium_alloy_helmet");
            setRegistryName("titanium_alloy_helmet");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
    public static class Chestplate extends ItemArmor {
        public Chestplate() {
            super(RegisterItem.TITANIUM_ALLOY_ARMOR_MATERIAL, 0, EntityEquipmentSlot.CHEST);
            setUnlocalizedName("titanium_alloy_chestplate");
            setRegistryName("titanium_alloy_chestplate");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
    public static class Leggings extends ItemArmor {
        public Leggings() {
            super(RegisterItem.TITANIUM_ALLOY_ARMOR_MATERIAL, 0, EntityEquipmentSlot.LEGS);
            setUnlocalizedName("titanium_alloy_leggings");
            setRegistryName("titanium_alloy_leggings");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
    public static class Boots extends ItemArmor {
        public Boots() {
            super(RegisterItem.TITANIUM_ALLOY_ARMOR_MATERIAL, 0, EntityEquipmentSlot.FEET);
            setUnlocalizedName("titanium_alloy_boots");
            setRegistryName("titanium_alloy_boots");
            setCreativeTab(ModTabs.MPN_TAB);
        }
    }
} 