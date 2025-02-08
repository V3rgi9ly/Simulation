package org.example.models;

import org.example.action.Goal;
import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.map.GameMap;
import org.example.enums.MapField;

import java.util.Set;

public class Herbivore extends Creature implements Goal {


    public Herbivore(Integer speed, Integer health, Coordinates location, MapField mapField) {
        super(speed, health, mapField, location);
    }


    @Override
    protected void makeTakeover(GameMap map, Coordinates coordinates) {

    }

//    @Override
//    public void setPositionObject() {
//
//    }
//
//    @Override
//    public Set<CoordinatesShift> makeMove() {
//        CoordinatesShift coordinatesShift = new CoordinatesShift();
//        Set<CoordinatesShift> set=coordinatesShift.getCoordinatesShift();
//        return set;
//    }
//
//    @Override
//    public Creature deletedObject() {
//        return null;
//    }
//
//    @Override
//    public void spawnObject() {
//
//    }
}



