package org.example.inanimateObject;

import org.example.Coordinates;
import org.example.Entity;
import org.example.MapField;

public abstract class InanimObject extends Entity {
     public final MapField mapField;

    protected InanimObject(Coordinates coordinates, MapField mapField) {
        this.coordinates = coordinates;
        this.mapField = mapField;
    }
}
