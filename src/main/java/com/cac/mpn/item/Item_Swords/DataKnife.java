package com.cac.mpn.item.Item_Swords;

import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class DataKnife extends ItemSword {
    public static final Item.ToolMaterial DATA_SWORD= EnumHelper.addToolMaterial("DATA",3, 255, 5.5F, 1.5F, 14);
    public DataKnife() {
        super(DATA_SWORD);
        this.setUnlocalizedName("data_knife");
        this.setRegistryName("data_knife");
    }
}
