package org.example.inanimateObject;

import org.example.Coordinates;
import org.example.Entity;
import org.example.MapField;
import org.example.Obstacle;

public abstract class InanimObject extends Entity {
     public final MapField mapField;

    protected InanimObject(MapField mapField, Coordinates coordinates, Obstacle obstacle) {
        super();
        this.coordinates = coordinates;
        this.mapField = mapField;
        this.obstacle = obstacle;
    }
}
