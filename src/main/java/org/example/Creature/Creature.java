package org.example.Creature;

import org.example.*;


import javax.print.DocFlavor;
import java.util.*;

public abstract class Creature extends Entity {
    protected Integer speed;
    protected Integer health;
    public final MapField mapField;



    protected Creature(Integer speed, Integer health, MapField mapField, Coordinates coordinates) {
        this.speed = speed;
        this.health = health;
        this.mapField = mapField;
        this.coordinates = coordinates;
    }



    public Set<Coordinates> getAvailableMoveCoordinates(GameMap gameMap) {
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift shift : makeMovement()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinate = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinate, gameMap)) {
                    result.add(newCoordinate);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates newCoordinate, GameMap gameMap) {
        return gameMap.isSquareEmpty(newCoordinate) || gameMap.getEntity(newCoordinate).mapField != mapField;
    }

    protected abstract Set<CoordinatesShift> makeMovement();

}
