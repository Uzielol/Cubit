/* 
 * The MIT License
 *
 * Copyright 2014 Bartosz Skrzypczak.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.barteks2x.cubit.world.chunk;

import com.github.barteks2x.cubit.world.chunk.IChunk;
import com.github.barteks2x.cubit.block.Block;
import com.github.barteks2x.cubit.location.ChunkLocation;
import com.github.barteks2x.cubit.location.Vec3I;
import com.github.barteks2x.cubit.util.ArrayUtil;
import com.github.barteks2x.cubit.util.logging.LoggerFactory;
import com.github.barteks2x.cubit.world.CubitWorld;
import java.util.logging.Logger;

/**
 *
 * @author Bartosz Skrzypczak
 */
//and here is how it's used
//I extend IChunk<ChunKCube8>
//T is ChunkCube8 extends IChunk<T>
public class ChunkCube8 implements IChunk {

    private static final Logger logger = LoggerFactory.getLogger(ChunkCube8.class);
    private static final Vec3I SIZE = new Vec3I(8, 8, 8);
    private static final Block EMPTY_BLOCK = Block.AIR;

    private final ChunkLocation<ChunkCube8> location;
    private final int[][][] blocks;
    private boolean isLoaded;
    private boolean canLoad;

    public ChunkCube8(ChunkLocation<ChunkCube8> location) {
        this(location, EMPTY_BLOCK);
    }

    public ChunkCube8(ChunkLocation<ChunkCube8> location, Block fill) {
        this.blocks = new int[SIZE.getX()][SIZE.getY()][SIZE.getZ()];
        CubitWorld<ChunkCube8> world = location.getWorld();
        this.location = location;
        ArrayUtil.fill(this.blocks, world.getBlockRegistry().getID(EMPTY_BLOCK));
    }

    public ChunkCube8(ChunkLocation<ChunkCube8> location, Block[][][] data) {
        this.blocks = new int[SIZE.getX()][SIZE.getY()][SIZE.getZ()];
        CubitWorld<ChunkCube8> world = location.getWorld();
        this.location = location;
        ArrayUtil.clone(blocks, this.blocks);
    }
    
    @Override
    public String toString() {
        return new StringBuilder(100).append("Position: (").append(this.location.toString()).toString();
    }

    @Override
    public int getX() {
        return this.location.getX();
    }

    @Override
    public int getY() {
        return this.location.getY();
    }

    @Override
    public int getZ() {
        return this.location.getZ();
    }

    protected void setBlocks(int[][][] data) {
        ArrayUtil.clone(data, this.blocks);
    }

    @Override
    public boolean setBlockAt(int x, int y, int z, Block b) {
        this.blocks[x][y][z] = this.getWorld().getBlockRegistry().getID(b);
        return true;
    }

    @Override
    public Block getBlockAt(int x, int y, int z) {
        return this.getWorld().getBlockRegistry().fromID(this.blocks[x][y][z]);
    }

    @Override
    public ChunkLocation<ChunkCube8> getLocation() {
        return this.location;
    }

    @Override
    public CubitWorld<ChunkCube8> getWorld() {
        return this.getLocation().getWorld();
    }

    @Override
    public Block getDefaultBlock() {
        return EMPTY_BLOCK;
    }

    @Override
    public boolean isLoaded() {
        return this.isLoaded;
    }

    @Override
    public void unload() {
        this.isLoaded = false;
        this.canLoad = false;
    }

    @Override
    public void load() {
        if (this.isLoaded) {
            throw new RuntimeException("Chunk already loaded!");
        }
        if (this.canLoad) {
            this.isLoaded = true;
        }
    }

    @Override
    public Vec3I getSize() {
        return SIZE;
    }
    
    public static Vec3I chunkSize() {
        return SIZE;
    }
}