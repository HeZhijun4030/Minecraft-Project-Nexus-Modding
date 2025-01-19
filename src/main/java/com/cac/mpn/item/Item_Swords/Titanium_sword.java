package com.cac.mpn.item.Item_Swords;
import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import com.cac.mpn.item.ModTabs;
public class Titanium_sword extends ItemSword {
    public static final Item.ToolMaterial TITAN = EnumHelper.addToolMaterial("TITAN",1,44,3.0f,2.0f,5);
    public Titanium_sword() {
        super(TITAN);
        setRegistryName("titanium_sword");
        setUnlocalizedName("titanium_sword");
        setCreativeTab(ModTabs.MPN_TAB);

    }
}
