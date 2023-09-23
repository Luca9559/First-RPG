package com.mygdx.firstrpg;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.maxHeight = 4096;
		settings.maxWidth = 4096;
		settings.edgePadding = true;
		TexturePacker.process(settings, "textures", "textureatlas", "texturepack");

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.useVsync(true);
		config.setTitle("First RPG");
		//config.setResizable(false);
		config.setWindowedMode(800, 600);
		new Lwjgl3Application(new FirstRPG(), config);
	}
}
