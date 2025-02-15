package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.map.GameMap;
import org.example.enums.MapField;

import java.util.*;

public class Predator extends Creature {


    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField) {
        super(speed, health, mapField, coordinates);

    }

    @Override
    public void makeMove(GameMap gameMap) {

    }

    @Override
    public void makeTakeover(GameMap map, Coordinates coordinates) {
//        HashMap<Coordinates, Entity> sd=map.getStaticObjects();
//        for (CoordinatesShift coordinatesShift:makeMove()){
//            for (Map.Entry<Coordinates, Entity> entry:sd.entrySet()){
//                Coordinates de=entry.getKey();
//                Coordinates c=coordinates.shift(coordinatesShift);
//                if (c.x.equals(de.x) && c.y.equals(de.y)){
//                    map.deleteEntity(entry.getValue());
//                }
//            }
//        }
    }


}



