package com.cac.mpn.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.cac.mpn.item.RegisterItem;
import com.cac.mpn.item.*;
import com.cac.mpn.Block.*;

public class FurnaceRecipeRegistryHandler {
    public static void register() {
        GameRegistry.addSmelting(RegisterBlock.TITANIUM,
                new ItemStack(RegisterItem.TITANIUM_INGOT), 0.1f);
        GameRegistry.addSmelting(RegisterBlock.COPPER,
                new ItemStack(RegisterItem.COPPER_INGOT), 0.1f);
        GameRegistry.addSmelting(RegisterBlock.ZINC,
                new ItemStack(RegisterItem.ZINC_INGOT), 0.1f);
        GameRegistry.addSmelting(RegisterBlock.ALUMINUM,
                new ItemStack(RegisterItem.ALUMINUM_INGOT), 0.1f);
        GameRegistry.addSmelting(RegisterBlock.TIN,
                new ItemStack(RegisterItem.TIN_INGOT), 0.1f);
    }
}