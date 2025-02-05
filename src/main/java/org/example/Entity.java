package org.example;

public abstract class Entity {
    public Coordinates coordinates;
    public MapField mapField;
    public Obstacle obstacle;

    protected Entity() {
        this.mapField = mapField;
    }
}
