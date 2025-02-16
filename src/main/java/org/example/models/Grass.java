package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;

public class Grass extends EntityNotAlive {
    public Grass(Coordinates coordinates, MapField mapField) {
        super(mapField, coordinates);
    }


}
