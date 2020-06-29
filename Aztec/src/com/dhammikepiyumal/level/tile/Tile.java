package com.dhammikepiyumal.level.tile;

import com.dhammikepiyumal.aztec.graphics.Screen;
import com.dhammikepiyumal.aztec.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

}
