package com.cac.mpn.item.Armor;

import com.cac.mpn.item.ModTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class TitaniumAlloyArmor extends ItemArmor {
    
    public static final ItemArmor.ArmorMaterial TITANIUM_ALLOY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial(
        "TITANIUM_ALLOY_ARMOR", 
        "mpn:titanium_alloy_armor", 
        3072, // 耐久度
        new int[]{4, 10, 8, 4}, // 保护值：头盔4，胸甲10，护腿8，靴子4
        12, // 附魔能力
        net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, // 装备音效
        2.0F // 韧性
    );
    
    public TitaniumAlloyArmor(EntityEquipmentSlot equipmentSlotIn) {
        super(TITANIUM_ALLOY_ARMOR_MATERIAL, 0, equipmentSlotIn);
        setCreativeTab(ModTabs.MPN_TAB);
        
        switch (equipmentSlotIn) {
            case HEAD:
                setRegistryName("titanium_alloy_helmet");
                setUnlocalizedName("titanium_alloy_helmet");
                break;
            case CHEST:
                setRegistryName("titanium_alloy_chestplate");
                setUnlocalizedName("titanium_alloy_chestplate");
                break;
            case LEGS:
                setRegistryName("titanium_alloy_leggings");
                setUnlocalizedName("titanium_alloy_leggings");
                break;
            case FEET:
                setRegistryName("titanium_alloy_boots");
                setUnlocalizedName("titanium_alloy_boots");
                break;
        }
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "mpn:textures/models/armor/titanium_alloy_armor_layer_2.png";
        } else {
            return "mpn:textures/models/armor/titanium_alloy_armor_layer_1.png";
        }
    }
} 