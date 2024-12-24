package org.example.Creature;

import org.example.*;

import java.util.*;

public abstract class Creature extends Entity {
    protected Integer speed;
    protected Integer health;
    public final MapField mapField;
    protected Set<CoordinatesShift> coordinatesShift = new HashSet<>();


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


    public Set<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureGoals) {
        Set<Coordinates> listCoordinates = new HashSet<>();
        Queue<Coordinates> queue = new LinkedList<>();

        coordinatesShift.add(new CoordinatesShift(1, 1));
        coordinatesShift.add(new CoordinatesShift(1, 0));
        coordinatesShift.add(new CoordinatesShift(0, 1));
        coordinatesShift.add(new CoordinatesShift(-1, -1));
        coordinatesShift.add(new CoordinatesShift(0, -1));
        coordinatesShift.add(new CoordinatesShift(-1, 0));

        Coordinates currentCoordinates = creatureStart.coordinates;
        queue.offer(currentCoordinates);
        Set<Coordinates> listCoordinatesss = new HashSet<>(queue);

        while (!queue.isEmpty()) {
            for (Coordinates coordinates2 : queue) {
                currentCoordinates = coordinates2;
                for (CoordinatesShift coordinatesShift : coordinatesShift) {
                    currentCoordinates.x += coordinatesShift.xShift;
                    currentCoordinates.y += coordinatesShift.yShift;

                    listCoordinates.add(new Coordinates(currentCoordinates.x, currentCoordinates.y));
                }
                for (Coordinates coordinates4 : listCoordinates) {
                    if (coordinates4.equals(coordinates2)) {
                        System.out.println("-");
                    } else {
                        listCoordinatesss.add(coordinates4);
                    }
                }

            }
            queue.addAll(listCoordinatesss);

            for (Coordinates coordinate : queue) {
                if (coordinate.equals(creatureGoals.coordinates)) {
                    listCoordinates.add(currentCoordinates);
                    System.out.println("Goal complete");
                    queue.clear();
                    break;
                }
            }
        }
        return listCoordinates;
    }

    public Set<Coordinates> getNeighbours(Set<Coordinates> coordinates) {
        for (Coordinates coordinate : coordinates) {

        }
        return coordinates;
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
