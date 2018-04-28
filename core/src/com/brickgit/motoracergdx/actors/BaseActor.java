package com.brickgit.motoracergdx.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Daniel Lin on 27/04/2018.
 */

public abstract class BaseActor extends Actor {

    protected Rectangle bounds = new Rectangle();

    public void updateBounds() {
        bounds.set(getX(), getY(), getWidth(), getHeight());
    }

    public boolean hit(BaseActor actor) {
        return bounds.overlaps(actor.bounds);
    }
}
