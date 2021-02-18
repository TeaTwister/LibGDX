package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.math.Rect;

public class Ship extends Sprite {
    private final float CRUISING_SPEED = 0.01f;

    private Vector2 spd;
    private Vector2 movementTarget;
    private Vector2 route = new Vector2();

    private boolean moving = false;

    public Ship(Texture texture) {
        super(new TextureRegion(texture));
    }

    public Ship(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.pos.set(worldBounds.pos);
        setHeightProportion(0.1f);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void update(float delta) {
        if (moving) move();
    }

    private void move() {
        route.set(movementTarget);
        if (route.sub(pos).len2() <= spd.len2()) {
            pos.add(route);
            moving = false;
        } else {
            pos.add(spd);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        setMovementTarget(touch);
        return false;
    }

    public void setMovementTarget(Vector2 v2) {
        movementTarget = v2;
        spd = v2.cpy()
                .sub(pos)
                .setLength(CRUISING_SPEED);
        moving = true;
    }
}
