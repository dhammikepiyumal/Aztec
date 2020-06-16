package com.dhammikepiyumal.aztec.graphics;

public class Screen {
    private int width, height;
    private int xtime = 50, ytime = 50;
    private int counter = 0;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render() {
        counter++;

        if (counter % 100 == 0) {
            ytime--;
        }

        if (counter % 100 == 0) {
            xtime--;
        }

        for (int y = 0; y < height; y++) {
            if (ytime < 0 || ytime >= height) {
                break;
            }

            for (int x = 0; x < width; x++) {
                if (xtime < 0 || xtime >= height) {
                    break;
                }

                pixels[xtime + ytime * width] = 0xff00ff;
            }
        }
    }
}

/*
 * 'pixels[x + y * width] = 0xff0ff' is the way to fill all of the pixels in the
 * window with pink color. 'x + y * width' is the way to access the relevent
 * pixel and it is always true for any kind of a rectangular coordinate system
 * dealing with single dimensional arrays. 'FF00FF' is the pink color in
 * Hexadecimal. But in Java, to convert this Hexadecimal into Decimal before we
 * store it as an integer, it should be prefixed wiht '0x'. In order to save a
 * binary value in an integer array, '0b' should be used as a prefix. Note:
 * These Hexadecimal values are not case sensitive. 'ff00ff' and 'FF00FF' are
 * the same.
 */
