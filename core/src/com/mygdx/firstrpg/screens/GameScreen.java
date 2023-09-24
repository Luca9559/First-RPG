package com.mygdx.firstrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.firstrpg.objects.Block;
import com.mygdx.firstrpg.objects.Player;

public class GameScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private Player player;
    private Block block;
    private OrthographicCamera camera;
    private FitViewport viewport;


    public GameScreen () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        camera.update();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        player = new Player();
        block = new Block();
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0.69f, 0.69f, 0.69f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.move(delta);

        batch.begin();
        camera.position.set(player.getPosition().x + player.getWidth() / 2, player.getPosition().y + player.getHeight() / 2, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        player.render(batch, delta);
        block.render(batch, delta);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        player.dispose();
        block.dispose();
    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
