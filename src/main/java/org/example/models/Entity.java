package org.example.models;


import org.example.coordinates.Coordinates;
import org.example.enums.MapField;
import org.example.enums.Obstacle;

public abstract class Entity  {
    protected Coordinates coordinates;
    protected MapField mapField;
    protected Obstacle obstacle;

    protected Entity() {
        this.mapField = mapField;
    }

    public MapField getMapField() {
        return mapField;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }




}
