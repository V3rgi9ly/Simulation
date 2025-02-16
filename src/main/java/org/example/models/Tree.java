package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;

public class Tree extends EntityNotAlive {
    public Tree(Coordinates coordinates, MapField mapField) {
        super(mapField, coordinates);
    }

}
