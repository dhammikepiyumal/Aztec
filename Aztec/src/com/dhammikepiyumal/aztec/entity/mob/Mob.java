package com.dhammikepiyumal.aztec.entity.mob;

import com.dhammikepiyumal.aztec.entity.Entity;
import com.dhammikepiyumal.aztec.graphics.Sprite;

public abstract class Mob extends Entity {
    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move() {

    }

    public void update() {

    }

    private boolean collision() {
        return false;
    }

    public void render() {

    }

}
