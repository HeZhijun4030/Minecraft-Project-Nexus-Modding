package com.cac.mpn.item.Armor;

import com.cac.mpn.item.ModTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class TitaniumArmor extends ItemArmor {
    
    public static final ItemArmor.ArmorMaterial TITANIUM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial(
        "TITANIUM_ARMOR", 
        "mpn:titanium_armor", 
        2048, // 耐久度
        new int[]{3, 8, 6, 3}, // 保护值：头盔3，胸甲8，护腿6，靴子3
        10, // 附魔能力
        net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_IRON, // 装备音效
        1.0F // 韧性
    );
    
    public TitaniumArmor(EntityEquipmentSlot equipmentSlotIn) {
        super(TITANIUM_ARMOR_MATERIAL, 0, equipmentSlotIn);
        setCreativeTab(ModTabs.MPN_TAB);
        
        switch (equipmentSlotIn) {
            case HEAD:
                setRegistryName("titanium_helmet");
                setUnlocalizedName("titanium_helmet");
                break;
            case CHEST:
                setRegistryName("titanium_chestplate");
                setUnlocalizedName("titanium_chestplate");
                break;
            case LEGS:
                setRegistryName("titanium_leggings");
                setUnlocalizedName("titanium_leggings");
                break;
            case FEET:
                setRegistryName("titanium_boots");
                setUnlocalizedName("titanium_boots");
                break;
        }
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "mpn:textures/models/armor/titanium_armor_layer_2.png";
        } else {
            return "mpn:textures/models/armor/titanium_armor_layer_1.png";
        }
    }
} 