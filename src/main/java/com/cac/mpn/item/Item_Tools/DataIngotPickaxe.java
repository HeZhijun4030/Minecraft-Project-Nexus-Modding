package com.cac.mpn.item.Item_Tools;

import com.cac.mpn.item.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import static com.cac.mpn.item.RegisterItem.DATA_TOOL_MATERIAL;

public class DataIngotPickaxe extends ItemPickaxe {
    
    public DataIngotPickaxe() {
        super(DATA_TOOL_MATERIAL);
        setRegistryName("data_ingot_pickaxe");
        setUnlocalizedName("data_ingot_pickaxe");
        setCreativeTab(ModTabs.MPN_TAB);
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            // 3x3挖矿功能
            ItemStack stack = player.getHeldItem(hand);
            if (stack.getItem() == this) {
                IBlockState targetState = worldIn.getBlockState(pos);
                if (targetState.getBlock() != Blocks.AIR && canHarvestBlock(targetState, stack)) {
                    // 3x3挖矿
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            for (int z = -1; z <= 1; z++) {
                                BlockPos currentPos = pos.add(x, y, z);
                                IBlockState currentState = worldIn.getBlockState(currentPos);
                                if (currentState.getBlock() != Blocks.AIR && canHarvestBlock(currentState, stack)) {
                                    // 应用时运效果
                                    int fortuneLevel = 3; // 时运III
                                    worldIn.destroyBlock(currentPos, false);
                                    if (currentState.getBlock().canSilkHarvest(worldIn, currentPos, currentState, player)) {
                                        // 精准采集
                                        if (player.capabilities.isCreativeMode) {
                                            currentState.getBlock().dropBlockAsItem(worldIn, currentPos, currentState, fortuneLevel);
                                        } else {
                                            currentState.getBlock().dropBlockAsItem(worldIn, currentPos, currentState, fortuneLevel);
                                        }
                                    } else {
                                        // 普通挖掘，应用时运
                                        currentState.getBlock().dropBlockAsItem(worldIn, currentPos, currentState, fortuneLevel);
                                    }
                                    
                                    // 消耗耐久
                                    stack.damageItem(1, player);
                                    if (stack.getCount() <= 0) {
                                        player.setHeldItem(hand, ItemStack.EMPTY);
                                        return EnumActionResult.SUCCESS;
                                    }
                                }
                            }
                        }
                    }
                    return EnumActionResult.SUCCESS;
                }
            }
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
    
    @Override
    public boolean canHarvestBlock(IBlockState blockIn, ItemStack stack) {
        return super.canHarvestBlock(blockIn, stack);
    }
} 