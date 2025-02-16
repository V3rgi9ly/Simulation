package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;


public class Rock  extends EntityNotAlive {

    public Rock(Coordinates coordinates, MapField mapField) {
        super(mapField, coordinates);
    }


}
