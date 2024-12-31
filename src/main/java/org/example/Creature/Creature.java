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


    public Set<Coordinates> theShortestWay(Creature creatureStart,Coordinates coordinates, Creature creatureEnd) {
        Set<Coordinates> shortestWay = new HashSet<>();
        creatureStart.coordinates.x-=creatureEnd.coordinates.x;
        creatureStart.coordinates.y-=creatureEnd.coordinates.y;
        if(coordinates.x<=creatureStart.coordinates.x && coordinates.y<=creatureStart.coordinates.y){
            shortestWay.add(coordinates);
        }


        return shortestWay;
    }


    public Set<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureGoals) {
        Set<Coordinates> listCoordinates = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> listCoordinatesss = new HashSet<>();

        coordinatesShift.add(new CoordinatesShift(1, 0));
        coordinatesShift.add(new CoordinatesShift(0, 1));
        coordinatesShift.add(new CoordinatesShift(0, -1));
        coordinatesShift.add(new CoordinatesShift(-1, 0));

        queue.add(creatureStart.coordinates);


        while (!queue.isEmpty()) {
            for (Coordinates coordinates2 : queue) {
                for (CoordinatesShift coordinatesShift : coordinatesShift) {
                    if (coordinates2.canShift(coordinatesShift)) {
                        listCoordinates.add(coordinates2.shift(coordinatesShift));
                    }
                }
                for (Coordinates coordinates4 : listCoordinates) {
                    if (!coordinates4.equals(coordinates2)) {
                        listCoordinatesss.add(coordinates4);
                    }
                }
            }

            queue.addAll(listCoordinatesss);
            for (Coordinates coordinate : queue) {
                if (coordinate.equals(creatureGoals.coordinates)) {
                    listCoordinatesss.add(coordinate);
                    System.out.println("CreateGoal finding!");
                    queue.clear();
                    break;
                }
            }

        }
        return listCoordinatesss;
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
