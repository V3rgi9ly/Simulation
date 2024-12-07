package org.example.Creature;

import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;
import org.example.MapField;

import java.util.HashSet;
import java.util.Set;

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

    public Set<Coordinates> getAvailableMoveCoordinates(Map map) {
        Set<Coordinates> result=new HashSet<>();
        for (CoordinatesShift shift: makeMovement()){
            if (coordinates.canShift(shift)){
                Coordinates newCoordinate=coordinates.shift(shift);

                if(isSquareAvailableForMove(newCoordinate, map)){
                    result.add(newCoordinate);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates newCoordinate, Map map) {
        return map.isSquareEmpty(newCoordinate)||map.getEntity(newCoordinate).mapField!=mapField;
    }

    protected abstract Set<CoordinatesShift> makeMovement();

}
