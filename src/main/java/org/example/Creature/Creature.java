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


    public boolean visited(Coordinates coordinates) {
        if (coordinates != null) {
            return true;
        }
        return false;
    }


    public Set<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureMove, Creature creatureGoals) {
        Set<Coordinates> listCoordinates = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();
        queue.add(creatureStart.coordinates);

        Coordinates currentCoordinates = creatureStart.coordinates;
        Coordinates coordinates1 = null;

        while (!queue.isEmpty()) {
            currentCoordinates = queue.remove();
            if (currentCoordinates.equals(creatureGoals.coordinates)) {
                listCoordinates.add(currentCoordinates);
                return listCoordinates;
            } else {
                for (Coordinates coordinates2 : queue) {
                    currentCoordinates = coordinates2;
                    for (CoordinatesShift coordinatesShift : coordinatesShift) {
                        currentCoordinates.y += coordinatesShift.yShift;
                        currentCoordinates.x += coordinatesShift.xShift;
                        coordinates1 = new Coordinates(currentCoordinates.x, currentCoordinates.y);

                        listCoordinates.add(coordinates1);
                    }
                }
                queue.addAll(Collections.singleton(getNeighbors(listCoordinates)));
                queue.removeAll(listCoordinates);
            }

        }

        return listCoordinates;
    }

    public Coordinates getNeighbors(Set<Coordinates> coordinates) {
        for (Coordinates coordinatesShift : coordinates) {

        }
        return (Coordinates) coordinates;
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
