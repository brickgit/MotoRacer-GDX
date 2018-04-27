package com.brickgit.motoracergdx.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;
import com.brickgit.motoracergdx.utils.Assets;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Daniel Lin on 24/04/2018.
 */

public class Road extends Actor {

    private Sprite imgBackground = Assets.getRoad();
    private Vector2 background1;
    private Vector2 background2;
    private int speed = 500;

    private List<Car> cars = new LinkedList<Car>();
    private long lastCarTime = 0;

    private Sprite imgOil = Assets.getOil();
    private List<Rectangle> oils = new LinkedList<Rectangle>();
    private long lastOilTime = 0;
    private Random random = new Random();

    private final long TWO_SECS = 2000000000l;
    private final long TEN_SECS = 10000000000l;

    public Road(int x, int y) {
        setSize(imgBackground.getWidth(), imgBackground.getHeight());
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
        background1 = new Vector2(getX(), getY());
        background2 = new Vector2(getX(), getY() + getHeight());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Rectangle> getOils() {
        return oils;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        update(delta);
        updateCars(delta);
        updateOils(delta);
        long now = TimeUtils.nanoTime();
        if (now - lastCarTime >= TWO_SECS) {
            addCar();
            lastCarTime = now;
        }
        if (now - lastOilTime >= TEN_SECS) {
            addOil();
            lastOilTime = now;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(imgBackground, background1.x, background1.y, getWidth(), getHeight());
        batch.draw(imgBackground, background2.x, background2.y, getWidth(), getHeight());
        drawOils(batch);
        drawCars(batch, parentAlpha);
    }

    private void update(float delta) {
        int move = (int) (delta * speed);
        background1.y -= move;
        background2.y -= move;

        if (background2.y <= 0) {
            background1 = background2;
            background2 = new Vector2(background1.x, background1.y + getHeight());
        }
    }

    private void addCar() {
        float carWidth = Assets.getCars().get(0).getWidth();
        int x = (int) getX() + (int) (carWidth / 2) + random.nextInt((int) (getWidth() - carWidth));
        Car car = new Car(x, (int) getHeight());
        cars.add(car);
    }

    private void updateCars(float delta) {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            car.act(delta);
        }
    }

    private void drawCars(Batch batch, float parentAlpha) {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            car.draw(batch, parentAlpha);
        }
    }

    private void addOil() {
        int x = (int) getX() + random.nextInt((int) (getWidth() - imgOil.getWidth()));
        Rectangle oil = new Rectangle(x, getHeight(), imgOil.getWidth(), imgOil.getHeight());
        oils.add(oil);
    }

    private void updateOils(float delta) {
        int move = (int) (delta * speed);
        Iterator<Rectangle> it = oils.iterator();
        while (it.hasNext()) {
            Rectangle oil = it.next();
            if (oil.y < -oil.height) {
                it.remove();
            }
            oil.y -= move;
        }
    }

    private void drawOils(Batch batch) {
        Iterator<Rectangle> it = oils.iterator();
        while (it.hasNext()) {
            Rectangle oil = it.next();
            batch.draw(imgOil, oil.x, oil.y, oil.width, oil.height);
        }
    }
}
