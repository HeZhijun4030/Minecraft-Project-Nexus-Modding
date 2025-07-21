package com.cac.mpn.Block;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class ModWorldGen {

    public static void registerWorldGen() {

        WorldGenMinable yourOreGen = new WorldGenMinable(
                new ItemBlock(RegisterBlock.TITANIUM).getBlock().getDefaultState(),
                8,
                BlockMatcher.forBlock(Blocks.STONE)
        );

        // 注册到世界生成
        GameRegistry.registerWorldGenerator(new IWorldGenerator() {
            @Override
            public void generate(Random random, int chunkX, int chunkZ, World world,
                                 IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
                if (world.provider.getDimension() == 0) { // 0 = 主世界
                    runGenerator(yourOreGen, world, random, chunkX, chunkZ, 20, 0, 64);
                }
            }
        }, 0);
    }

    // 辅助方法：控制生成频率和高度
    private static void runGenerator(WorldGenerator generator, World world, Random rand,
                                     int chunkX, int chunkZ, int spawnChance, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("矿物生成高度错误！");

        // 每个区块尝试生成 spawnChance 次
        for (int i = 0; i < spawnChance; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = rand.nextInt(maxHeight - minHeight) + minHeight;
            int z = chunkZ * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}