package com.dhammikepiyumal.aztec.graphics;

public class Sprite {
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}

/*
 * 'pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) *
 * sheet.SIZE]' - this is taking a small sprite of a gitven size from the bigger
 * SpriteSheet from the given coordinates by entering them into the pixels array
 * in SpriteSheet and draw that small sprite into the Sprite class's pixels
 * array in order to make a individual sprite from the collection of sprites in
 * the SpriteSheet.
 */