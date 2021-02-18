package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.math.Rect;

public class Background extends Sprite {
    public Background(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void resize(Rect worldBounds) {
        this.pos.set(worldBounds.pos);
        setHeightProportion(worldBounds.getHeight());
    }
}
