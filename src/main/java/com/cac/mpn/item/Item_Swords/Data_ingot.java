package com.cac.mpn.item.Item_Swords;
import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import com.cac.mpn.item.ModTabs;
public class Data_ingot extends Item {
    public Data_ingot() {
        this.setUnlocalizedName("Data_ingot");
        this.setRegistryName("Data_ingot");
        this.setMaxStackSize(16);
        setCreativeTab(ModTabs.MPN_TAB);

    }
}

