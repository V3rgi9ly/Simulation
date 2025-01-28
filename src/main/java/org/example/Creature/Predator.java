package org.example.Creature;

import org.example.Coordinates;
import org.example.Entity;
import org.example.MapField;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Predator extends Creature {


    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField) {
        super(speed, health, mapField, coordinates);
    }






    @Override
    protected Set<CoordinatesShift> makeMovement() {
//        return new HashSet<>(Arrays.asList(
//                new CoordinatesShift(1,1),
//                new CoordinatesShift(1,0),
//                new CoordinatesShift(0,1),
//                new CoordinatesShift(-1,-1),
//                new CoordinatesShift(0,-1),
//                new CoordinatesShift(-1,0)
//
//        )
//
//        );
        return new HashSet<>(Arrays.asList());
    }
}



