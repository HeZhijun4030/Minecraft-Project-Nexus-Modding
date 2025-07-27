package com.cac.mpn.item.Armor;

import com.cac.mpn.item.ModTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class DataIngotArmor extends ItemArmor {
    
    // 下界合金护具保护值：头盔3，胸甲8，护腿6，靴子3
    // 数据锭护具保护值：头盔4.5，胸甲12，护腿9，靴子4.5（1.5倍）
    public static final ItemArmor.ArmorMaterial DATA_ARMOR_MATERIAL = EnumHelper.addArmorMaterial(
        "DATA_ARMOR", 
        "mpn:data_armor", 
        4096, // 耐久度
        new int[]{5, 12, 9, 5}, // 保护值：头盔5，胸甲12，护腿9，靴子5
        15, // 附魔能力
        net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, // 装备音效
        3.0F // 韧性
    );
    
    public DataIngotArmor(EntityEquipmentSlot equipmentSlotIn) {
        super(DATA_ARMOR_MATERIAL, 0, equipmentSlotIn);
        setCreativeTab(ModTabs.MPN_TAB);
        
        switch (equipmentSlotIn) {
            case HEAD:
                setRegistryName("data_ingot_helmet");
                setUnlocalizedName("data_ingot_helmet");
                break;
            case CHEST:
                setRegistryName("data_ingot_chestplate");
                setUnlocalizedName("data_ingot_chestplate");
                break;
            case LEGS:
                setRegistryName("data_ingot_leggings");
                setUnlocalizedName("data_ingot_leggings");
                break;
            case FEET:
                setRegistryName("data_ingot_boots");
                setUnlocalizedName("data_ingot_boots");
                break;
        }
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "mpn:textures/models/armor/data_armor_layer_2.png";
        } else {
            return "mpn:textures/models/armor/data_armor_layer_1.png";
        }
    }
} 