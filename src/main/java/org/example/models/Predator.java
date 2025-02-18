package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.enums.MapField;
import org.example.service.CoordinateService;

import java.util.*;

public class Predator extends Creature {

    private CoordinateService coordinateService;
    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField, CoordinateService coordinateService) {
        super(speed, health, mapField, coordinates);
        this.coordinateService = coordinateService;

    }

    @Override
    public void makeMove(GameMap gameMap) {
        Entity target=coordinateService.findTarget(this, gameMap.getGameMap());
        if (target != null) {
            if (isAdjacent(target.getCoordinates())) {
                if (target instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) target;
                    herbivore.takeDamage(1);
                    if (!herbivore.isAlive()) {
                        gameMap.deleteEntity(herbivore);
                    }
                }
            } else {
                List<Coordinates> path = coordinateService.getShortPath(this, target);
                if (!path.isEmpty()) {
                    int steps = Math.min(this.speed, path.size());
                    for (int i = 0; i < steps; i++) {
                        Coordinates nextStep = path.get(i);
                        if (gameMap.isSquareEmpty(nextStep)) {
                            gameMap.deleteEntity(this);
                            this.setCoordinates(nextStep);
                            gameMap.setStaticObjects(nextStep, this);
                            break;
                        }
                    }
                }
            }
        }
    }

    private boolean isAdjacent(Coordinates target){
        int dx=Math.abs(this.getCoordinates().getX()-target.getX());
        int dy=Math.abs(this.getCoordinates().getY()-target.getY());
        return (dx==1 && dy==0) || (dx<=1 && dy<=0);
    }
}



