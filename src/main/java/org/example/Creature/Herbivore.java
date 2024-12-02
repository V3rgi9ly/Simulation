package org.example.Creature;

import org.example.Coordinates;
import org.example.MapField;

public class Herbivore extends Creature {


    public Herbivore(Integer speed, Integer health, Coordinates location, MapField mapField) {
        super(speed, health, mapField, location);
    }

    @Override
    public void makeMovement() {

    }


}
