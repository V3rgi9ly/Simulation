package org.example.Creature;

import org.example.Entity;

public abstract class Creature extends Entity {
    protected Integer speed;
    protected Integer health;


    public Creature(Integer speed, Integer health) {
        this.speed = speed;
        this.health = health;
    }

    protected abstract void makeMovement();
}
