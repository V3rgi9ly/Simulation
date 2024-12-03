package org.example.Creature;

import org.example.Coordinates;
import org.example.Entity;
import org.example.MapField;

public abstract class Creature extends Entity {
    protected Integer speed;
    protected Integer health;
    public final MapField mapField;



    protected Creature(Integer speed, Integer health, MapField mapField, Coordinates coordinates) {
        this.speed = speed;
        this.health = health;
        this.mapField = mapField;
        this.coordinates = coordinates;
    }

    protected abstract void makeMovement();

}
