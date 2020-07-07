package com.dhammikepiyumal.aztec.entity;

import java.util.Random;

import com.dhammikepiyumal.aztec.graphics.Screen;

public abstract class Entity {
    public int x, y;
    private boolean removed = false;
    protected final Random random = new Random();

    public void update() {

    }

    public void render(Screen screen) {

    }

    public void remove() {
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }
}
