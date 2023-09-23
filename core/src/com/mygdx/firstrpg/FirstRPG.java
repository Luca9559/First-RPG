package com.mygdx.firstrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.firstrpg.screens.LoadingScreen;

public class FirstRPG extends Game {

	public static FirstRPG INSTANCE;
    public static AssetManager manager;

	public FirstRPG() {
		INSTANCE = this;
	}

	@Override
	public void create () {
        manager = new AssetManager();
		setScreen(new LoadingScreen());
	}
}
