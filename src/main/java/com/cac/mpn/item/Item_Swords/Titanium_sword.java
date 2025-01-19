package com.cac.mpn.item.Item_Swords;
import com.cac.mpn.item.ModTabs;
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import com.cac.mpn.item.ModTabs;
public class Titanium_sword extends ItemSword {
    public static final Item.ToolMaterial TITANIUM_SWORD = EnumHelper.addToolMaterial("TITAN",3, 2048, 10.0F, 1.5F, 14);
    public Titanium_sword() {
        super(TITANIUM_SWORD);
        setRegistryName("titanium_sword");
        setUnlocalizedName("titanium_sword");
        setCreativeTab(ModTabs.MPN_TAB);

    }
}
