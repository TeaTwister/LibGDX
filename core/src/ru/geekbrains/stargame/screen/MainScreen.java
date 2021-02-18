package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.sprite.Background;
import ru.geekbrains.stargame.sprite.Ship;

public class MainScreen extends BaseScreen {

    private TextureAtlas atlas;
    private Texture bg;
    private Background back;
    private Ship ship;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        bg = new Texture("planets.jpg");
        back = new Background(bg);
        atlas = new TextureAtlas("astero.atlas");
        ship = new Ship(atlas.findRegion("astero"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        back.draw(batch);
        ship.update(delta);
        ship.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        ship.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        ship.resize(worldBounds);
        back.resize(worldBounds);
    }
}
