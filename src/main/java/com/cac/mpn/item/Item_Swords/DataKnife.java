package com.cac.mpn.item.Item_Swords;

import com.cac.mpn.item.ModTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import com.cac.mpn.item.RegisterItem;
import static com.cac.mpn.item.RegisterItem.DATA_KNIFE_MATERIAL;
public class DataKnife extends ItemSword {

    public DataKnife() {
        super(DATA_KNIFE_MATERIAL);
        setRegistryName("data_knife");
        setUnlocalizedName("data_knife");
        setCreativeTab(ModTabs.MPN_TAB);
    }
} 