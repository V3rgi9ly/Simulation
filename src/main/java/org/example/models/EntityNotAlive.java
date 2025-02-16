package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;

public abstract class EntityNotAlive extends Entity {
     protected final MapField mapField;

    protected EntityNotAlive(MapField mapField, Coordinates coordinates) {
        super();
        this.coordinates = coordinates;
        this.mapField = mapField;
    }
}
