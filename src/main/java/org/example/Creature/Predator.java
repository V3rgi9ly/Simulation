package org.example.Creature;

import org.example.Coordinates;
import org.example.Entity;
import org.example.GameMap;
import org.example.MapField;

import java.util.*;

public class Predator extends Creature {


    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField) {
        super(speed, health, mapField, coordinates);

    }


    @Override
    public void makeTakeover(GameMap map, Coordinates coordinates) {
        HashMap<Coordinates, Entity> sd=new HashMap<>(map.getStaticObjects());
        for (CoordinatesShift coordinatesShift:makeMovement()){
            for (Map.Entry<Coordinates, Entity> entry:sd.entrySet()){
                Coordinates de=entry.getKey();
                Coordinates c=coordinates.shift(coordinatesShift);
                if (c.x.equals(de.x) && c.y.equals(de.y)){
                    map.setDeletedCreature(entry.getValue());
                }
            }
        }
    }

    @Override
    protected Set<CoordinatesShift> makeMovement() {
        CoordinatesShift coordinatesShift = new CoordinatesShift();
        Set<CoordinatesShift> set=coordinatesShift.coordinatesShift;
        return set;
    }
}



