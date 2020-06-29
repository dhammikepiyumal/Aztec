package com.dhammikepiyumal.level;

import com.dhammikepiyumal.aztec.graphics.Screen;

public class Level {
    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.widht = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
    }

    protected void generateLevel() {

    }

    private void loadLevel(String path) {

    }

    public void update() {

    }

    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {

    }
}

/*
 * 'generateLevel()' is generating a level randomly form a given set of levels.
 * For now, is has levels from 0 to 4
 */
