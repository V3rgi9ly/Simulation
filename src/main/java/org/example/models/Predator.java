package org.example.models;

import org.example.action.Stalker;
import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.map.GameMap;
import org.example.enums.MapField;

import java.util.*;

public class Predator extends Creature implements Stalker {


    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField) {
        super(speed, health, mapField, coordinates);

    }


    public Set<CoordinatesShift> makeMove() {

        CoordinatesShift coordinatesShift = new CoordinatesShift();
        Set<CoordinatesShift> set=coordinatesShift.getCoordinatesShift();
        return set;
    }

//    @Override
//    public Creature deletedObject() {
//        return null;
//    }
//
//    @Override
//    public void spawnObject() {
//
//    }
//
//    @Override
//    public void setPositionObject() {
//
//    }

    @Override
    public void makeTakeover(GameMap map, Coordinates coordinates) {
        HashMap<Coordinates, Entity> sd=map.getStaticObjects();
        for (CoordinatesShift coordinatesShift:makeMove()){
            for (Map.Entry<Coordinates, Entity> entry:sd.entrySet()){
                Coordinates de=entry.getKey();
                Coordinates c=coordinates.shift(coordinatesShift);
                if (c.x.equals(de.x) && c.y.equals(de.y)){
                    map.deleteEntity(entry.getValue());
                }
            }
        }
    }


}



