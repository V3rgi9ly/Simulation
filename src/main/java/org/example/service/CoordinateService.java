package org.example.service;

import org.example.coordinates.BFS;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.models.*;

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
        List<Entity> Grass = new ArrayList<>();
        for (Entity entity : map.values()) {
            if (entity instanceof Predator) {
                predators.add(entity);
            } else if (entity instanceof Herbivore) {
                herbivore.add(entity);

            }
            else if (entity instanceof org.example.models.Grass){
                Grass.add(entity);
            }
        }
        Predator predator = (Predator) predators.get(0);
        Herbivore herbivore1 = (Herbivore) herbivore.get(0);
        org.example.models.Grass Grass1 = (org.example.models.Grass) Grass.get(0);
        return bfs.getCoordinates(predator, herbivore1);

    }

    private Grass findGrass(Map<Coordinates, Entity> map){
        for (Entity entity : map.values()) {
            if (entity instanceof org.example.models.Grass){
                return (Grass) entity;
            }
        }
        return null;
    }

    private Herbivore findHerbivore(Map<Coordinates, Entity> map){
        for (Entity entity : map.values()) {
            if (entity instanceof Herbivore){
                return (Herbivore) entity;
            }
        }
        return null;
    }

    private double calculateDistance(Coordinates a, Coordinates b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

}
