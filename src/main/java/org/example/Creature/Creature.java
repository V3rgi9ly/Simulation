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


    public Coordinates theShortestWay(List<Coordinates> listCoordinates, Creature creatureGoals) {
        Map< Coordinates, Integer> coordinatesMap = new HashMap<>();
        Coordinates shortestWay = null;
        List<Integer> listSum=new ArrayList<>();
        Random random = new Random();

        for (Coordinates coordinates : listCoordinates) {
            int sumCell=(coordinates.x-creatureGoals.coordinates.x)+(creatureGoals.coordinates.y - coordinates.y);
//            coordinatesMap.put(coordinates, sumCell);
            listSum.add(sumCell);
        }

        int min=listSum.get(0);

        for (int i=0; i<listSum.size(); i++) {
            if (listSum.get(i)<min) {
                min=listSum.get(i);
                shortestWay=listCoordinates.get(i);
            }
        }
        return shortestWay;
    }


    public List<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureGoals) {
        Queue<Coordinates> queue = new ArrayDeque<>();
        List<Coordinates> sets = new ArrayList<>();
        List<Coordinates> sets2 = new ArrayList<>();
        List<Coordinates> setser = new ArrayList<>();
        Map<Coordinates, Integer> shortestWay = new TreeMap<>();
        int i = 0;

        coordinatesShift.add(new CoordinatesShift(1, 0));
        coordinatesShift.add(new CoordinatesShift(0, 1));
        coordinatesShift.add(new CoordinatesShift(0, -1));
        coordinatesShift.add(new CoordinatesShift(-1, 0));

//        shortestWay.put(creatureStart.coordinates, 0);
        queue.add(creatureStart.coordinates);
        sets2.add(new Coordinates(0, 0));

        while (!queue.isEmpty()) {

            for (Coordinates coordinates2 : setser) {
                if (!queue.contains(coordinates2)) {
                    queue.add(coordinates2);

                }
//                if (!shortestWay.containsKey(coordinates2)) {
//                    shortestWay.put(coordinates2, i);
//                }
            }
            setser.clear();
            for (Coordinates coordinates1 : queue) {
                if (coordinates1.equals(creatureGoals.coordinates)) {
//                    for (Coordinates coordinates2 : queue) {
//                        sets.add(coordinates2);
//                    }
//                    sets.addAll(theShortestWay((TreeMap<Coordinates, Integer>) shortestWay, coordinates1));
                    queue.clear();
                    System.out.println("CreateGoal finding!");
                    break;
                } else {
                    for (CoordinatesShift coordinatesShift : coordinatesShift) {
                        if (coordinates1.canShift(coordinatesShift)) {
                            sets2.add(coordinates1.shift(coordinatesShift));
                            setser.add(coordinates1.shift(coordinatesShift));
                        }
                    }
                }
            }
         sets.add(theShortestWay(setser, creatureGoals));
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
