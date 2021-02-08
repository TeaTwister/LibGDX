package ru.geekbrains.stargame;

import com.badlogic.gdx.Game;

import ru.geekbrains.stargame.screen.MainScreen;

public class StarGame extends Game {
	@Override
	public void create () {
		setScreen(new MainScreen());
	}
}
