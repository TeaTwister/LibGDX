package ru.geekbrains.stargame.wip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    private Texture img;
    private Vector2 pos;
    private Vector2 movementTarget;
    private boolean moving = false;

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

    public Texture getImg() {
        return img;
    }

    public void tick() {
        if (moving) moveTo(movementTarget);
        x = pos.x;
        y = pos.y;
    }

    public void dispose() {
        img.dispose();
    }

    public void setMovementTarget(float x, float y) {
        this.movementTarget = new Vector2(x - (float) img.getWidth() / 2, y - (float) img.getHeight() / 2);
        moving = true;
    }

    private void moveTo(Vector2 target) {
        pos = target.cpy();
        if (pos.epsilonEquals(target)) moving = false;
    }
}
