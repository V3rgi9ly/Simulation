package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.enums.MapField;

public class Herbivore extends Creature {


    public Herbivore(Integer speed, Integer health, Coordinates location, MapField mapField) {
        super(speed, health, mapField, location);
    }


    @Override
    public void makeMove(GameMap gameMap) {

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



