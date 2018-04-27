package com.brickgit.motoracergdx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Lin on 24/04/2018.
 */

public class Assets {

    private static Sprite racer;
    private static Sprite road;
    private static Sprite oil;
    private static List<Sprite> cars;

    public static Sprite getRacer() {
        return racer;
    }

    public static Sprite getRoad() {
        return road;
    }

    public static Sprite getOil() {
        return oil;
    }

    public static List<Sprite> getCars() {
        return cars;
    }

    public static void init() {
        racer = new Sprite(new Texture("racer.png"));
        road = new Sprite(new Texture("road.png"));
        oil = new Sprite(new Texture("oil.png"));

        cars = new ArrayList<Sprite>();
        cars.add(new Sprite(new Texture("car-black.png")));
        cars.add(new Sprite(new Texture("car-blue.png")));
        cars.add(new Sprite(new Texture("car-green.png")));
        cars.add(new Sprite(new Texture("car-red.png")));
        cars.add(new Sprite(new Texture("car-yellow.png")));
    }

    public static void dispose() {}
}
