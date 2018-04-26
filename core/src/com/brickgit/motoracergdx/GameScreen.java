package com.brickgit.motoracergdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.brickgit.motoracergdx.actors.Racer;
import com.brickgit.motoracergdx.actors.Road;
import com.brickgit.motoracergdx.utils.Config;

/**
 * Created by Daniel Lin on 24/04/2018.
 */

public class GameScreen implements Screen {

    private Stage stage;
    private Road road;
    private Racer racer;

    public GameScreen() {
        stage = new Stage();
        stage.setViewport(new FitViewport(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT));

        road = new Road(Config.WINDOW_WIDTH / 2, Config.WINDOW_HEIGHT / 2);
        stage.addActor(road);
        racer = new Racer(Config.WINDOW_WIDTH / 2, 60, road);
        stage.addActor(racer);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()) {
            Vector2 position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            stage.getViewport().unproject(position);
            racer.move(position.x);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) racer.moveRight();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) racer.moveLeft();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
