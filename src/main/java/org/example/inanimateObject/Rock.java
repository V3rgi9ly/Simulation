package org.example.inanimateObject;

import org.example.Coordinates;
import org.example.MapField;
import org.example.Obstacle;



public class Rock  extends InanimObject {

    public Rock(Coordinates coordinates, MapField mapField, Obstacle obstacle) {
        super(mapField, coordinates,obstacle);
    }
}
