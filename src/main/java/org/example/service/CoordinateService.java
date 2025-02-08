package org.example.service;

import org.example.coordinates.BFS;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.models.Creature;
import org.example.models.Entity;
import org.example.models.Herbivore;
import org.example.models.Predator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinateService {


    private final BFS bfs;

    public CoordinateService(GameMap gameMap) {
        bfs = new BFS(gameMap);
    }

    public List<Coordinates> getShortPath(Map<Coordinates, Entity> map) {
        List<Entity> predators = new ArrayList<>();
        List<Entity> herbivore = new ArrayList<>();
        for (Entity entity : map.values()) {
            if (entity instanceof Predator) {
                predators.add(entity);
            } else if (entity instanceof Herbivore) {
                herbivore.add(entity);

            }
        }
        Predator predator = (Predator) predators.get(0);
        Herbivore herbivore1 = (Herbivore) herbivore.get(0);
        return bfs.getCoordinates(predator, herbivore1);

    }


}
