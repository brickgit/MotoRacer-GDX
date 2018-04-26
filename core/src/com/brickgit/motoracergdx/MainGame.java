package com.brickgit.motoracergdx;

import com.badlogic.gdx.Game;
import com.brickgit.motoracergdx.utils.Assets;

public class MainGame extends Game {

	@Override
	public void create() {
		Assets.init();
		setScreen(new GameScreen());
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		Assets.dispose();
	}
}
