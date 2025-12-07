package com.cac.mpn;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import com.cac.mpn.crafting.FurnaceRecipeRegistryHandler;
import com.cac.mpn.power.TileEntityPower;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import com.cac.mpn.gui.GuiHandler;

@Mod(modid = Mod_Main.MODID, name = Mod_Main.NAME, version = Mod_Main.VERSION)
public class Mod_Main
{
    public static final String MODID = "mpn";
    public static final String NAME = "Minecraft Project Nexues";
    public static final String VERSION = "Test-0.1";

    private static Logger logger;
    
    @Mod.Instance
    public static Mod_Main instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        // 注册世界矿石生成器
        GameRegistry.registerWorldGenerator(new com.cac.mpn.world.WorldGenOres(), 0);
        // 注册通用电力 TileEntity（供实现了 IPowerBlock 的方块使用）
        GameRegistry.registerTileEntity(TileEntityPower.class, new ResourceLocation(MODID, "tile_power"));
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FurnaceRecipeRegistryHandler.register();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
