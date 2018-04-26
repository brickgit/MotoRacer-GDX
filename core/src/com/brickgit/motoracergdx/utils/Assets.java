package com.brickgit.motoracergdx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Daniel Lin on 24/04/2018.
 */

public class Assets {

    private static Sprite racer;
    private static Sprite road;
    private static Sprite oil;

    public static Sprite getRacer() {
        return racer;
    }

    public static Sprite getRoad() {
        return road;
    }

    public static Sprite getOil() {
        return oil;
    }

    public static void init() {
        racer = new Sprite(new Texture("racer.png"));
        road = new Sprite(new Texture("road.png"));
        oil = new Sprite(new Texture("oil.png"));
    }

    public static void dispose() {}
}
