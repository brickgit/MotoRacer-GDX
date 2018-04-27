package com.brickgit.motoracergdx.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.brickgit.motoracergdx.utils.Assets;

import java.util.List;
import java.util.Random;

/**
 * Created by Daniel Lin on 26/04/2018.
 */

public class Car extends Actor {

    private Sprite imgCar;
    private int speed;

    private Rectangle bounds = new Rectangle();

    private Random random = new Random();

    public Car(int x, int y) {
        List<Sprite> cars = Assets.getCars();
        imgCar = cars.get(random.nextInt(cars.size()));

        setSize(imgCar.getWidth(), imgCar.getHeight());
        setPosition(x - getWidth() / 2, y - getHeight() / 2);

        speed = 200 + random.nextInt(201);

        bounds.set(getX(), getY(), getWidth(), getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        int move = (int) (delta * speed);
        setY(getY() - move);
        bounds.y = getY();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(imgCar, getX(), getY(), getWidth(), getHeight());
    }
}
