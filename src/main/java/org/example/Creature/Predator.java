package org.example.Creature;

import org.example.Coordinates;
import org.example.MapField;

public class Predator extends Creature {


    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField) {
        super(speed, health, mapField, coordinates);
    }

    @Override
     public void makeMovement() {

    }


}
