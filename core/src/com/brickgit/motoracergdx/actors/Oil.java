package com.brickgit.motoracergdx.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.brickgit.motoracergdx.utils.Assets;

/**
 * Created by Daniel Lin on 27/04/2018.
 */

public class Oil extends BaseActor {

    private Sprite imgOil = Assets.getOil();
    private int speed = 500;

    public Oil(int x, int y) {
        setSize(imgOil.getWidth(), imgOil.getHeight());
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
        updateBounds();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        int move = (int) (delta * speed);
        setY(getY() - move);
        bounds.y = getY();
        updateBounds();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(imgOil, getX(), getY(), getWidth(), getHeight());
    }
}
