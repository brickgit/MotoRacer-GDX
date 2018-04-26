package com.brickgit.motoracergdx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brickgit.motoracergdx.utils.Config;
import com.brickgit.motoracergdx.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Config.WINDOW_WIDTH;
		config.height = Config.WINDOW_HEIGHT;
		new LwjglApplication(new MainGame(), config);
	}
}
