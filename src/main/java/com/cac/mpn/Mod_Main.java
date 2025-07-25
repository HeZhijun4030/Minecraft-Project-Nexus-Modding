package com.cac.mpn;

import com.cac.mpn.power.SimplePowerRegistry;
import com.cac.mpn.power.devices.ContainerSteamGenerator;
import com.cac.mpn.power.devices.GuiSteamGenerator;
import com.cac.mpn.power.devices.SteamGenerator;
import com.cac.mpn.crafting.FurnaceRecipeRegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;

@Mod(modid = Mod_Main.MODID, name = Mod_Main.NAME, version = Mod_Main.VERSION)
public class Mod_Main implements IGuiHandler {
    public static final String MODID = "mpn";
    public static final String NAME = "Minecraft Project Nexus";
    public static final String VERSION = "Test-0.1";

    @Mod.Instance(MODID)
    public static Mod_Main instance;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        SimplePowerRegistry.initialize();
        net.minecraftforge.fml.common.network.NetworkRegistry.INSTANCE.registerGuiHandler(this, this);
        logger.info("Power system initialized");
        // 注册TileEntity，防止崩溃
        GameRegistry.registerTileEntity(com.cac.mpn.power.devices.SteamGenerator.class, new ResourceLocation(MODID, "steam_generator_tile"));
        GameRegistry.registerTileEntity(com.cac.mpn.power.devices.ElectricFurnace.class, new ResourceLocation(MODID, "electric_furnace_tile"));
        GameRegistry.registerTileEntity(com.cac.mpn.power.devices.AlloyMachineTileEntity.class, new ResourceLocation(MODID, "alloy_machine_tile"));
        GameRegistry.registerTileEntity(com.cac.mpn.power.devices.ZincWire.class, new ResourceLocation(MODID, "zinc_wire_tile"));
        GameRegistry.registerTileEntity(com.cac.mpn.power.devices.CopperWire.class, new ResourceLocation(MODID, "copper_cable_tile"));
        GameRegistry.registerTileEntity(com.cac.mpn.power.devices.BasicSolarGenerator.class, new ResourceLocation(MODID, "basic_solar_generator_tile"));
        // 注册矿石生成
        com.cac.mpn.Block.ModWorldGen.registerWorldGen();
        // 注册熔炼配方
        FurnaceRecipeRegistryHandler.register();
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) {
            event.player.sendMessage(new TextComponentString(
                "§a本模组由CIP&CMS团队创作，遵循双方开发者的意志，任何商业服不得魔改，修改或调整矿物生成。配方表问题，如有违反，请在Github上找到Minecraft-Nexus仓库，提交issus，我们将审查该服务器。本mod是CIP&CMS产品，任何人未经允许不得修改。\n当前版本为A轮内测版本，安装该MOD视为同意以上条款，若不同意，请使用录像设备，录制关闭游戏并卸载Mod的视频。"
            ));
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        logger.info("Active power networks: {}",
                com.cac.mpn.power.core.SimplePowerSystem.getInstance().getNetworkCount());
    }

    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event) {
        logger.info("Power system shutdown");
    }

    public static Logger getLogger() {
        return logger;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        net.minecraft.tileentity.TileEntity te = world.getTileEntity(new net.minecraft.util.math.BlockPos(x, y, z));
        if (te instanceof com.cac.mpn.power.devices.SteamGenerator) {
            return new com.cac.mpn.power.devices.ContainerSteamGenerator(player.inventory, (com.cac.mpn.power.devices.SteamGenerator) te);
        }
        if (te instanceof com.cac.mpn.power.devices.ElectricFurnace) {
            return new com.cac.mpn.power.devices.ContainerElectricFurnace(player.inventory, (com.cac.mpn.power.devices.ElectricFurnace) te);
        }
        if (te instanceof com.cac.mpn.power.devices.AlloyMachineTileEntity) {
            return new com.cac.mpn.power.devices.ContainerAlloyMachine(player.inventory, (com.cac.mpn.power.devices.AlloyMachineTileEntity) te);
        }
        return null;
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        net.minecraft.tileentity.TileEntity te = world.getTileEntity(new net.minecraft.util.math.BlockPos(x, y, z));
        if (te instanceof com.cac.mpn.power.devices.SteamGenerator) {
            return new com.cac.mpn.power.devices.GuiSteamGenerator(player.inventory, (com.cac.mpn.power.devices.SteamGenerator) te);
        }
        if (te instanceof com.cac.mpn.power.devices.ElectricFurnace) {
            return new com.cac.mpn.power.devices.GuiElectricFurnace(player.inventory, (com.cac.mpn.power.devices.ElectricFurnace) te);
        }
        if (te instanceof com.cac.mpn.power.devices.AlloyMachineTileEntity) {
            return new com.cac.mpn.power.devices.GuiAlloyMachine(player.inventory, (com.cac.mpn.power.devices.AlloyMachineTileEntity) te);
        }
        return null;
    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FurnaceRecipeRegistryHandler.register();
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}