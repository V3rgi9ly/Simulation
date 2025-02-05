package org.example.Creature;

import org.example.Coordinates;
import org.example.GameMap;
import org.example.MapField;

import java.util.Set;

public class Herbivore extends Creature {


    public Herbivore(Integer speed, Integer health, Coordinates location, MapField mapField) {
        super(speed, health, mapField, location);
    }


    @Override
    protected void makeTakeover(GameMap map, Coordinates coordinates) {

    }

    @Override
    protected Set<CoordinatesShift> makeMovement() {
        return Set.of();
    }
}



