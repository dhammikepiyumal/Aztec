package com.dhammikepiyumal.aztec.graphics;

import java.util.Random;

import com.dhammikepiyumal.level.tile.Tile;

public class Screen {
    public int width, height;
    private Random random = new Random();
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int xOffset, yOffset;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    // public void render(int xOffset, int yOffset) {
    // for (int y = 0; y < height; y++) {
    // int yp = y + yOffset;

    // if (yp < 0 || yp >= height) {
    // continue;
    // }

    // for (int x = 0; x < width; x++) {
    // int xp = x + xOffset;

    // if (xp < 0 || xp >= width) {
    // continue;
    // }

    // pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) *
    // Sprite.grass.SIZE];
    // }
    // }
    // }

    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;

        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xa = x + xp;
                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) {
                    break;
                }
                if (xa < 0)
                    xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}

/*
 * 'tiles[i] = random.nextInt(0xffffff)' this provides a random color code for
 * the tile index value
 */
/*
 * 'int tileIndex = (x >> 4) + (y >> 4) * 64' this is somewhat complex to
 * understand. But this is doing assigning the same color for 16 * 16 squares in
 * the window. 16 is 2^4. therefore 'int tileIndex = (x / 16) + (y / 16) * 64'
 * is also the same meaning for shifting 4 places of x and y values. This
 * shifting method can be used to divide from the powers of 2. The reason to use
 * this is to increase the speed of the rendering.
 */
/*
 * 'pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + (y & 15) *
 * Sprite.grass.SIZE]' is the way to fill all of the pixels in the window with
 * the clors of the defined tiles. 'x + y * width' is the way to access the
 * relevent pixel and it is always true for any kind of a rectangular coordinate
 * system dealing with single dimensional arrays. 'FF00FF' is the pink color in
 * Hexadecimal. But in Java, to convert this Hexadecimal into Decimal before we
 * store it as an integer, it should be prefixed wiht '0x'. In order to save a
 * binary value in an integer array, '0b' should be used as a prefix. Note:
 * These Hexadecimal values are not case sensitive. 'ff00ff' and 'FF00FF' are
 * the same. x & 15 means basically to loop from the initial value of the x to
 * 15.
 */
