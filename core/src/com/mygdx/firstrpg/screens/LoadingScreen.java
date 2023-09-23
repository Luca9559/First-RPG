package com.mygdx.firstrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.firstrpg.FirstRPG;

public class LoadingScreen extends ScreenAdapter {

    public LoadingScreen() {
        FirstRPG.manager.load("textureatlas/texturepack.atlas", TextureAtlas.class);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (FirstRPG.manager.update()) {
            FirstRPG.INSTANCE.setScreen(new GameScreen());
        }
    }

}
