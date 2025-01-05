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


    public Set<Coordinates> theShortestWay(Creature creatureStart, Coordinates coordinates, Creature creatureEnd) {
        Set<Coordinates> shortestWay = new HashSet<>();
        creatureStart.coordinates.x -= creatureEnd.coordinates.x;
        creatureStart.coordinates.y -= creatureEnd.coordinates.y;
        if (coordinates.x <= creatureStart.coordinates.x && coordinates.y <= creatureStart.coordinates.y) {
            shortestWay.add(coordinates);
        }

        //Нужно сделать так, чтобы каждый раз к получаемую массиву мы будем находить наиболее меньшее расстояние от коордиант которые мы получаем
        //то есть Изначальные координаты-координаты до цели= короткий путь
        //Далее из полученного массива находим координаты, которые будут самыми наименьшими до короткого пути, нашли его, записываем далее в массив
        //Вопрос а как мы будем находить
        return shortestWay;
    }


    public List<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureGoals) {
        Queue<Coordinates> queue = new ArrayDeque<>();
        List<Coordinates> sets = new ArrayList<>();


        coordinatesShift.add(new CoordinatesShift(1, 0));
        coordinatesShift.add(new CoordinatesShift(0, 1));
        coordinatesShift.add(new CoordinatesShift(0, -1));
        coordinatesShift.add(new CoordinatesShift(-1, 0));


        queue.add(creatureStart.coordinates);
        sets.add(creatureStart.coordinates);


//        while (!listCoordinatesss.isEmpty()) {
//            for (Coordinates coordinates2 : queue) {
//                for (CoordinatesShift coordinatesShift : coordinatesShift) {
//                    if (coordinates2.canShift(coordinatesShift)) {
//                        listCoordinates.add(coordinates2.shift(coordinatesShift));
//                    }
//                }
//                for (Coordinates coordinates4 : listCoordinates) {
//                    if (coordinates4!=coordinates2) {
//                        queue.add(coordinates4);
//                        sets.add(queue.poll());
//                    }
//                }
//            }
//
//            queue.addAll(sets);
//
//            for (Coordinates coordinate : sets) {
//                if (coordinate.equals(creatureGoals.coordinates)) {
//                    System.out.println("CreateGoal finding!");
//                    listCoordinatesss.clear();
//                    break;
//                }
//            }
//
//        }


        while (!queue.isEmpty()) {
            Coordinates coordinates12 = queue.remove();
            if (coordinates12.equals(creatureGoals.coordinates)) {
                sets.addAll(queue);
                queue.clear();
                System.out.println("CreateGoal finding!");
                break;
            } else {
                for (CoordinatesShift coordinatesShift : coordinatesShift) {
                    if (coordinates12.canShift(coordinatesShift)) {
                        sets.add(coordinates12.shift(coordinatesShift));
                    }
                }

                queue.addAll(sets);
                sets.clear();
            }

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
