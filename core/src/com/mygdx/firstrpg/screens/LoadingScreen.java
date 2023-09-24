package com.mygdx.firstrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.firstrpg.FirstRPG;

public class LoadingScreen extends ScreenAdapter {

    SpriteBatch batch;
    BitmapFont font;
    FitViewport viewport;

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public LoadingScreen() {
        FirstRPG.manager.load("textureatlas/texturepack.atlas", TextureAtlas.class);
        batch = new SpriteBatch();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(2);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "Loading...", 350, 300);
        batch.end();

        if (FirstRPG.manager.update()) {
            FirstRPG.INSTANCE.setScreen(new GameScreen());
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
