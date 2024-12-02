package org.example.Creature;

import org.example.Coordinates;
import org.example.Entity;

public abstract class Creature extends Entity {
    protected Integer speed;
    protected Integer health;
    protected Sprite sprite;

    public Coordinates coordinates;

    protected Creature(Integer speed, Integer health, Coordinates coordinates) {
        this.speed = speed;
        this.health = health;
        this.coordinates = coordinates;
    }

    protected abstract void makeMovement();

}
