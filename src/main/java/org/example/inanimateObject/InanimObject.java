package org.example.inanimateObject;

import org.example.Coordinates;
import org.example.Entity;
import org.example.MapField;

public abstract class InanimObject extends Entity {
     public final MapField mapField;

    protected InanimObject( MapField mapField, Coordinates coordinates) {
        super();
        this.coordinates = coordinates;
        this.mapField = mapField;
    }
}
