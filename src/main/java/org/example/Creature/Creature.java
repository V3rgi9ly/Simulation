package org.example.Creature;

import org.example.*;

import java.util.*;

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

    public Set<Coordinates> breadthFirstSearch(GameMap map, Creature creatureStart, Creature creatureMove, Creature creatureGoals) {
        Set<Coordinates> visit = new HashSet<>();
        Set<Coordinates> path = new HashSet<>();
        Set<Coordinates> distance = new HashSet<>();

        for (int i = 0; i < coordinatesShift.size(); i++) {
            visit.add(new Coordinates(creatureStart.coordinates.x, creatureStart.coordinates.y));
        }

        for (CoordinatesShift coordinatesShift : coordinatesShift) {
            for (Coordinates coordinates1 : visit) {
                coordinates1.x += coordinatesShift.xShift;
                coordinates1.y += coordinatesShift.yShift;
                path.add(new Coordinates(coordinates1.x, coordinates1.y));

                if (visit.equals(creatureGoals.coordinates)) {
                    creatureMove.coordinates = creatureGoals.coordinates;
                    break;
                }
            }

            if (creatureMove.coordinates == creatureGoals.coordinates) {
                break;
            }
        }

        return distance;
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
