package com.dhammikepiyumal.aztec.graphics;

import java.util.Random;

public class Screen {
    private int width, height;
    private Random random = new Random();
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
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

    public void render(int xOffset, int yOffset) {
        for (int y = 0; y < height; y++) {
            int yy = y + yOffset;
            // if (yy < 0 || yy >= height) {
            // break;
            // }
            for (int x = 0; x < width; x++) {
                int xx = x + xOffset;
                // if (xx < 0 || xx >= width) {
                // break;
                // }
                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = tiles[tileIndex];
            }
        }
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
 * 'pixels[x + y * width] = tiles[tileIndex' is the way to fill all of the
 * pixels in the window with the clors of the defined tiles. 'x + y * width' is
 * the way to access the relevent pixel and it is always true for any kind of a
 * rectangular coordinate system dealing with single dimensional arrays.
 * 'FF00FF' is the pink color in Hexadecimal. But in Java, to convert this
 * Hexadecimal into Decimal before we store it as an integer, it should be
 * prefixed wiht '0x'. In order to save a binary value in an integer array, '0b'
 * should be used as a prefix. Note: These Hexadecimal values are not case
 * sensitive. 'ff00ff' and 'FF00FF' are the same.
 */
