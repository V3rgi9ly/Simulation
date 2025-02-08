package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;
import org.example.enums.Obstacle;

public abstract class EntityNotAlive extends Entity {
     protected final MapField mapField;

    protected EntityNotAlive(MapField mapField, Coordinates coordinates, Obstacle obstacle) {
        super();
        this.coordinates = coordinates;
        this.mapField = mapField;
        this.obstacle = obstacle;
    }
}
