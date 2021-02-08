package ru.geekbrains.stargame.wip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    private Texture img;
    private Vector2 pos;

    public float x;
    public float y;

    public Ship(Texture img, float x, float y) {
        this.img = img;
        pos = new Vector2(x, y);
        tick();
    }

    public Ship(Texture img, Vector2 pos) {
        this.img = img;
        this.pos = pos;
        tick();
    }

    public Texture tick() {
        x = pos.x;
        y = pos.y;
        return img;
    }

    public void dispose() {
        img.dispose();
    }
}
