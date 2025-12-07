package com.cac.mpn.world;

import com.cac.mpn.Block.RegisterBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOres implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) { // Overworld
            generateOverworld(random, chunkX, chunkZ, world);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
        // 参数: 方块, 世界, 随机, 块X, 块Z, 最低Y, 最高Y(含), 脉冲大小, 每区块脉冲次数
        generateOre(RegisterBlock.TITANIUM, world, random, chunkX, chunkZ, 4, 32, 6, 16);
        generateOre(RegisterBlock.COPPER_ORE, world, random, chunkX, chunkZ, 20, 64, 8, 16);
        generateOre(RegisterBlock.ZINC_ORE, world, random, chunkX, chunkZ, 12, 48, 6, 16);
        generateOre(RegisterBlock.TIN_ORE, world, random, chunkX, chunkZ, 16, 56, 7, 16);
    }

    private void generateOre(net.minecraft.block.Block block, World world, Random random, int chunkX, int chunkZ,
                              int minY, int maxY, int veinSize, int veinsPerChunk) {
        if (minY > maxY || minY < 0 || maxY > 255) {
            return;
        }
        int heightDiff = maxY - minY + 1;
        for (int i = 0; i < veinsPerChunk; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = minY + random.nextInt(heightDiff);
            int z = chunkZ * 16 + random.nextInt(16);
            new WorldGenMinable(block.getDefaultState(), veinSize).generate(world, random, new net.minecraft.util.math.BlockPos(x, y, z));
        }
    }
}
