package org.example.coordinates;

import org.example.map.GameMap;
import org.example.models.Entity;
import org.example.models.Grass;

import java.util.*;

public class AStart {

    public final GameMap gameMap;
    public final List<Coordinates> shortestPath;

    public AStart(GameMap gameMap) {
        this.gameMap = gameMap;
        this.shortestPath = new ArrayList<>();
    }

    private List<Coordinates> aStarSearch(Entity creatureStart, Entity creatureGoals, Set<CoordinatesShift> coordinatesShift) {

        Set<Coordinates> closedSet = new HashSet<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Map<Coordinates, Integer> gScore = new HashMap<>();
        Map<Coordinates, Integer> fScore = new HashMap<>();
        PriorityQueue<Coordinates> openSet = new PriorityQueue<>(Comparator.comparingInt(c -> fScore.getOrDefault(c, Integer.MAX_VALUE)));

        Coordinates start = creatureStart.getCoordinates();
        Coordinates goal = creatureGoals.getCoordinates();

        gScore.put(start, 0);
        fScore.put(start, manhattanDistance(start, goal));
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Coordinates current = openSet.poll();

            if (current.equals(goal)) {
                List<Coordinates> path = reconstructPath(parentMap, start, goal);
                return path;
            }

            closedSet.add(current);

            for (CoordinatesShift shift : coordinatesShift) {
                if (current.canShift(shift, gameMap)) {
                    Coordinates neighbor = current.shift(shift);
                    if (closedSet.contains(neighbor)) continue;
                    Entity neighborEntity = gameMap.getEntity(neighbor);
                    if (neighborEntity instanceof Grass && !neighbor.equals(goal)) {
                        continue;
                    }
                    // Если клетка уже в закрытом списке, пропускаем её
                    if (closedSet.contains(neighbor)) {
                        continue;
                    }

                    int tentativeGScore = gScore.getOrDefault(current, Integer.MAX_VALUE) + 1;

                    if (tentativeGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        parentMap.put(neighbor, current);
                        gScore.put(neighbor, tentativeGScore);
                        fScore.put(neighbor, tentativeGScore + manhattanDistance(neighbor, goal));
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return Collections.emptyList(); // Если путь не найден
    }

    private int manhattanDistance(Coordinates a, Coordinates b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()); // Манхэттенское расстояние
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

    public List<Coordinates> getCoordinates(Entity creature, Entity goal) {
        return aStarSearch(creature, goal, new CoordinatesShift().getCoordinatesShift());
    }

}
