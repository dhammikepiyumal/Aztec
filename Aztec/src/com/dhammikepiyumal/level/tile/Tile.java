package com.dhammikepiyumal.level.tile;

import com.dhammikepiyumal.aztec.graphics.Screen;
import com.dhammikepiyumal.aztec.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

}

/*
 * 'Tile' objects can be initialized using 'GrassTile' class as 'GrassTile' is a
 * subclass of Tile. In other words, this is possible as the 'GrassTile' class
 * extends the 'Tile' class
 */