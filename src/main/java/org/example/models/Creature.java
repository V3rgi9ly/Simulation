package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.enums.MapField;
import org.example.map.GameMap;
import java.util.*;

public abstract class Creature extends Entity  {
    protected Integer speed;
    protected Integer health;
    protected final MapField mapField;

    protected Creature(Integer speed, Integer health, MapField mapField, Coordinates coordinates) {
        this.speed = speed;
        this.health = health;
        this.mapField = mapField;
        this.coordinates = coordinates;
    }


    public abstract void makeMove(GameMap gameMap);

//    protected abstract void makeTakeover(GameMap map, Coordinates coordinates);

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }




}
