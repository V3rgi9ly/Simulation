package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.enums.MapField;
import org.example.enums.Obstacle;

import java.util.Set;

public class Grass extends EntityNotAlive {
    public Grass(Coordinates coordinates, MapField mapField, Obstacle obstacle) {
        super(mapField, coordinates, obstacle);
    }


}
