package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.geekbrains.stargame.base.BaseScreen;
import ru.geekbrains.stargame.wip.Ship;

public class MainScreen extends BaseScreen {
    private Texture img;
    private Ship ship;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("planets.jpg");
        ship = new Ship(new Texture("ship.png"), 100, 100);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        drawShip();
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        ship.dispose();
        super.dispose();
    }

    private void drawShip() {
        batch.draw(ship.tick(), ship.x, ship.y);
    }
}
