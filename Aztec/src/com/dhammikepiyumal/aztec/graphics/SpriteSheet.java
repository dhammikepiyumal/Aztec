package com.dhammikepiyumal.aztec.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int pixels[];

    public static SpriteSheet tiles = new SpriteSheet("Aztec/res/textures/spritesheet.png", 256);

    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
 * 'final' means that it can only be declared once. It can be when creating or
 * in somewhere else. But it can only be declared once. So, basically it is not
 * a variable. It is a constant
 */
/*
 * 'BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path))' is
 * to load the image from the provided location to the 'image' variable of type
 * 'BufferedImage'.
 */
