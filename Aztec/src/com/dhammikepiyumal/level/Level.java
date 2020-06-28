package com.dhammikepiyumal.level;

public class Level {
    private int width, height;
    private int[] tiles;

    public Level(int width, int height) {
        this.widht = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    private void generateLevel() {

    }
}
