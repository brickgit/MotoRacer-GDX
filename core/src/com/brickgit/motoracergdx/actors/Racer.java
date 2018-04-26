package com.brickgit.motoracergdx.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;
import com.brickgit.motoracergdx.utils.Assets;

import java.util.Iterator;

/**
 * Created by Daniel Lin on 24/04/2018.
 */

public class Racer extends Actor {

    private Sprite imgRacer = Assets.getRacer();
    private float speed = 5;

    private Road road;

    private Rectangle bounds;

    private boolean isSkidding = false;

    public Racer(int x, int y, Road road) {
        setSize(imgRacer.getWidth(), imgRacer.getHeight());
        setPosition(x - getWidth() / 2, y - getHeight() / 2);

        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());

        this.road = road;
    }

    public void move(float newX) {
        newX = newX - getWidth() / 2;
        float oldX = getX();
        if (Math.abs(newX - oldX) < speed) return;

        if (newX > oldX) moveRight();
        else moveLeft();
    }

    public void moveRight() {
        if (isSkidding) return;
        float newX = getX() + speed;
        if (newX < road.getX() + road.getWidth() - getWidth()) {
            setX(newX);
            bounds.x = newX;
        }
    }

    public void moveLeft() {
        if (isSkidding) return;
        float newX = getX() - speed;
        if (newX > road.getX()) {
            setX(newX);
            bounds.x = newX;
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Iterator<Rectangle> it = road.getOils().iterator();
        while (it.hasNext()) {
            Rectangle oil = it.next();
            if (bounds.overlaps(oil)) {
                isSkidding = true;
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        isSkidding = false;
                    }
                }, 2);
                return;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float rotation = isSkidding ? 30 : getRotation();
        batch.draw(
                imgRacer, getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                1, 1, rotation);
    }
}
