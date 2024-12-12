package org.example.Creature;

import org.example.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Creature extends Entity {
    protected Integer speed;
    protected Integer health;
    public final MapField mapField;
    protected Set<CoordinatesShift> coordinatesShift = new HashSet<>(Arrays.asList(
            new CoordinatesShift(1, 1),
            new CoordinatesShift(1, 0),
            new CoordinatesShift(0, 1),
            new CoordinatesShift(-1, -1),
            new CoordinatesShift(0, -1),
            new CoordinatesShift(-1, 0)
    ));


    protected Creature(Integer speed, Integer health, MapField mapField, Coordinates coordinates) {
        this.speed = speed;
        this.health = health;
        this.mapField = mapField;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> breadthFirstSearch(GameMap map, Creature creature_start, Creature creature_goals) {
        Set<Coordinates> path = new HashSet<>();
        Coordinates s;
        while (creature_start.coordinates!=creature_goals.coordinates) {
            for (CoordinatesShift coordinatesShift : coordinatesShift) {
                int i = creature_start.coordinates.x + coordinatesShift.xShift;
                int j = creature_start.coordinates.y + coordinatesShift.yShift;
                path.add(new Coordinates(i, j));
                creature_start.coordinates=new Coordinates(i, j);
                if (creature_start.coordinates==creature_goals.coordinates) {

                }
            }
        }
    }

//    public Set<Coordinates> findingShortPath(Map<Coordinates, Entity> searchEntities, GameMap gameMap, Creature creature) {
//        Set<Coordinates> path = new HashSet<>();
//        int coordinatesX;
//        int coordinatesY;
//        for (Coordinates coordinates : searchEntities.keySet()) {
//            coordinatesX = coordinates.x - creature.coordinates.x;
//            coordinatesY = coordinates.y - creature.coordinates.y;
//            path.add(new Coordinates(coordinatesX, coordinatesY));
//        }
//
//        return path;
//    }

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
