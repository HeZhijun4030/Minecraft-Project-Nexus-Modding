package com.cac.mpn.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.cac.mpn.item.RegisterItem;
import com.cac.mpn.item.*;
import com.cac.mpn.Block.*;

public class FurnaceRecipeRegistryHandler {
    public static void register() {
        GameRegistry.addSmelting(RegisterBlock.TITANIUM,
                new ItemStack(RegisterItem.TITANIUM_INGOT), 1.0f);
        GameRegistry.addSmelting(RegisterBlock.COPPER_ORE,
                new ItemStack(RegisterItem.COPPER_INGOT), 1.0f);
        GameRegistry.addSmelting(RegisterBlock.ZINC_ORE,
                new ItemStack(RegisterItem.ZINC_INGOT), 1.0f);
        GameRegistry.addSmelting(RegisterBlock.TIN_ORE,
                new ItemStack(RegisterItem.TIN_INGOT), 1.0f);

    }
}