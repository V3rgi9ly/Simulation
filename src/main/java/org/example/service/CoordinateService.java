package org.example.service;

import org.example.coordinates.AStart;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.models.*;

import org.example.models.Entity;

import java.util.Map;
import java.util.*;

public class CoordinateService {


    private final AStart bfs;

    public CoordinateService(GameMap gameMap) {
        bfs = new AStart(gameMap);

    }

    public List<Coordinates> getShortPath(Entity entity,Entity target) {
           return bfs.getCoordinates(entity,target);
    }

    public Entity findTarget(Entity entity, Map<Coordinates, Entity> map){
        if (entity instanceof Predator) {
            return findHerbivore(entity,map);
        }
        else if (entity instanceof Herbivore) {
            return findGrass(entity,map);
        }
        return null;
    }

    private Grass findGrass(Entity entitys,Map<Coordinates, Entity> map){
        double minDistance = Double.MAX_VALUE;
        for (Entity entity : map.values()) {
            if (entity instanceof org.example.models.Grass){
                double distance = calculateDistance(entitys.getCoordinates(), entity.getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    return (Grass) entity;
                }
            }
        }
        return null;
    }

    private Herbivore findHerbivore(Entity entitys,Map<Coordinates, Entity> map){
        double minDistance = Double.MAX_VALUE;
        for (Entity entity : map.values()) {
            if (entity instanceof Herbivore){
                double distance = calculateDistance(entitys.getCoordinates(), entity.getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    return (Herbivore) entity;
                }
            }
        }
        return null;
    }

    private double calculateDistance(Coordinates a, Coordinates b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }



}
