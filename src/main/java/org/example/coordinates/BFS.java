package org.example.coordinates;

import org.example.map.GameMap;
import org.example.models.Creature;
import org.example.models.Entity;

import java.util.*;

public class BFS {

    public final GameMap gameMap;
    public final List<Coordinates> shortestPath;

    public BFS(GameMap gameMap) {
        this.gameMap = gameMap;
        this.shortestPath = new ArrayList<>();
    }

    private List<Coordinates> breadthFirstSearch(Entity creatureStart, Entity creatureGoals, Set<CoordinatesShift> coordinatesShift) {

        Queue<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Для восстановления пути

        queue.add(creatureStart.getCoordinates());
        visited.add(creatureStart.getCoordinates());

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (current.equals(creatureGoals.getCoordinates())) {
//                System.out.println("CreatureGoal found!");
                return reconstructPath(parentMap, creatureStart.getCoordinates(), creatureGoals.getCoordinates());
            }

            for (CoordinatesShift shift : coordinatesShift) {
                if (current.canShift(shift, gameMap)) {
                    Coordinates neighbor = current.shift(shift);
                    if (!visited.contains(neighbor)) {
//                    if (!visited.contains(neighbor) && !GameMap.listVisited.contains(neighbor)) {
                        visited.add(neighbor);
                        parentMap.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
        }

//        System.out.println("CreatureGoal not found!");
        return Collections.emptyList(); // Если путь не найден
    }


    private List<Coordinates> reconstructPath(Map<Coordinates, Coordinates> parentMap, Coordinates start, Coordinates goal) {
        List<Coordinates> path =shortestPath;
        Coordinates current = goal;
        while (!current.equals(start)) {
            path.add(current);
            current = parentMap.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }


    public List<Coordinates> getCoordinates(Entity creature, Entity goal) {

        return breadthFirstSearch(creature, goal,new CoordinatesShift().getCoordinatesShift());
    }

}
