package org.example;

import org.example.Creature.CoordinatesShift;
import org.example.Creature.Creature;

import javax.swing.plaf.PanelUI;
import java.util.*;

public class BFS {

    private List<Coordinates> breadthFirstSearch(Creature creatureStart, Creature creatureGoals, Set<CoordinatesShift> coordinatesShift) {

        Queue<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Для восстановления пути

        queue.add(creatureStart.coordinates);
        visited.add(creatureStart.coordinates);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (current.equals(creatureGoals.coordinates)) {
                System.out.println("CreatureGoal found!");
                return reconstructPath(parentMap, creatureStart.coordinates, creatureGoals.coordinates);
            }

            for (CoordinatesShift shift : coordinatesShift) {
                if (current.canShift(shift)) {
                    Coordinates neighbor = current.shift(shift);
                    if (!visited.contains(neighbor) && !GameMap.listVisited.contains(neighbor)) {
                        visited.add(neighbor);
                        parentMap.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
        }

        System.out.println("CreatureGoal not found!");
        return Collections.emptyList(); // Если путь не найден
    }



    private List<Coordinates> reconstructPath(Map<Coordinates, Coordinates> parentMap, Coordinates start, Coordinates goal) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = goal;
        while (!current.equals(start)) {
            path.add(current);
            current = parentMap.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }


    public List<Coordinates> getCoordinates(Creature creatureStart, Creature creatureEnd) {
        BFS bfs = new BFS();
        return bfs.breadthFirstSearch(creatureStart, creatureEnd,new CoordinatesShift().getCoordinatesShift());
    }




}
