package org.example.service;


import org.example.coordinates.Coordinates;
import org.example.models.Entity;
import org.example.models.Grass;
import org.example.models.Herbivore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetAwareCoordinateService {
    private final CoordinateService coordinateService;
    private final Map<Entity, Entity> targetedEntities = new HashMap<>();

    public TargetAwareCoordinateService(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    public void releaseTarget(Entity target) {
        targetedEntities.remove(target);
    }


    public Grass findAvailableGrass(Entity creature, Map<Coordinates, Entity> map) {
        Grass nearestGrass = null;
        double minDistance = Double.MAX_VALUE;

        for (Entity entity : map.values()) {
            if (entity instanceof Grass && !((Grass) entity).isTaken()) { // Проверяем, не съедена ли трава
                double distance = calculateDistance(creature.getCoordinates(), entity.getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestGrass = (Grass) entity;
                }
            }
        }

        if (nearestGrass != null) {
            setTargetAsTaken(nearestGrass, creature); // Помечаем траву как занятую
        }

        return nearestGrass;
    }


    public Herbivore findAvailableHerbivore(Entity creature, Map<Coordinates, Entity> map) {
        Herbivore nearestHerbivore = null;
        double minDistance = Double.MAX_VALUE;

        for (Entity entity : map.values()) {
            if (entity instanceof Herbivore && ((Herbivore) entity).isAlive()) { // Проверяем, живое ли травоядное
                double distance = calculateDistance(creature.getCoordinates(), entity.getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestHerbivore = (Herbivore) entity;
                }
            }
        }

        if (nearestHerbivore != null) {
            setTargetAsTaken(nearestHerbivore, creature); // Помечаем травоядное как занятого
        }

        return nearestHerbivore;
    }

    public List<Coordinates> getShortPath(Entity entity, Entity target) {
        return coordinateService.getShortPath(entity, target);
    }

    private double calculateDistance(Coordinates a, Coordinates b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    private void setTargetAsTaken(Entity target, Entity creature) {
        targetedEntities.put(target, creature);
    }


}
