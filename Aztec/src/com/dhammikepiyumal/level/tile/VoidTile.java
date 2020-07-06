package com.dhammikepiyumal.level.tile;

import com.dhammikepiyumal.aztec.graphics.Screen;
import com.dhammikepiyumal.aztec.graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

}
