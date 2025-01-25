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


    public Coordinates theShortestWay(List<Coordinates> listCoordinates, Creature creatureGoals, Coordinates creatureCoordinatesStep) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Map<Coordinates, Integer> coordinatesMap = new HashMap<>();
        Coordinates shortestWay=creatureCoordinatesStep;
        List<Coordinates> lista = new ArrayList<>();

            for (Coordinates s : listCoordinates) {
                for (CoordinatesShift c : coordinatesShift) {
                    if (shortestWay.x + c.xShift == s.x && shortestWay.y + c.yShift == s.y) {
                        lista.add(s);
                    }
                }
            }



            for (Coordinates coordinates : lista) {
                int sumCell =Math.abs (coordinates.x - creatureGoals.coordinates.x) + Math.abs(creatureGoals.coordinates.y - coordinates.y);
                coordinatesMap.put(coordinates, sumCell);
                priorityQueue.offer(sumCell);
            }


            for (Map.Entry<Coordinates, Integer> entry : coordinatesMap.entrySet()) {
                int i = priorityQueue.poll();
                if (entry.getValue() == i) {
                    shortestWay = entry.getKey();
                    break;
                }
            }

        return shortestWay;
    }


    public List<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureGoals) {
        Queue<Coordinates> queue = new ArrayDeque<>();
        List<Coordinates> sets = new ArrayList<>();
        List<Coordinates> sets2 = new ArrayList<>();
        List<Coordinates> setser = new ArrayList<>();

        coordinatesShift.add(new CoordinatesShift(1, 0));
        coordinatesShift.add(new CoordinatesShift(0, 1));
        coordinatesShift.add(new CoordinatesShift(0, -1));
        coordinatesShift.add(new CoordinatesShift(-1, 0));

        queue.add(creatureStart.coordinates);
        sets2.add(new Coordinates(0, 0));

        while (!queue.isEmpty()) {


            for (Coordinates coordinates2 : setser) {
                if (!queue.contains(coordinates2)) {
                    queue.add(coordinates2);
                }
            }
            setser.clear();
            for (Coordinates coordinates1 : queue) {
                if (!coordinates1.equals(creatureGoals.coordinates)) {
                    for (CoordinatesShift coordinatesShift : coordinatesShift) {
                        if (coordinates1.canShift(coordinatesShift)) {
                            sets2.add(coordinates1.shift(coordinatesShift));
                            setser.add(coordinates1.shift(coordinatesShift));
                        }
                    }

                } else {
                    queue.clear();
                    System.out.println("CreateGoal finding!");
                    break;
                }
            }

            creatureStart.coordinates=theShortestWay(setser, creatureGoals, creatureStart.coordinates);
            sets.add(creatureStart.coordinates);

        }

        return sets;
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
