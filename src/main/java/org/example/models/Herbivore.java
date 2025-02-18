package org.example.models;

import org.example.service.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.enums.MapField;
import org.example.service.CoordinateService;

import java.util.List;

public class Herbivore extends Creature {


    public Herbivore(Integer speed, Integer health, MapField mapField, TargetAwareCoordinateService coordinateService) {
        super(speed, health, mapField, coordinateService);
    }


    @Override
    public void makeMove(GameMap gameMap) {

        if (!this.isAlive()) {
            return;
        }

        Entity target = gameMap.getCoordinateService().findAvailableGrass(this, gameMap.getGameMap());

        if (target == null) {
            moveRandomly(gameMap);
            return;
        }

        if (target != null) {
            if (isAdjacent(target.getCoordinates())) {
                if (target instanceof Grass) {
                    eatGrass((Grass) target, gameMap);
                }
            } else {
                moveTowardsTarget(target, gameMap);
            }
        }
    }

    private void eatGrass(Grass grass, GameMap gameMap) {
        gameMap.deleteEntity(grass);
        grass.setTaken(false);
        gameMap.getCoordinateService().releaseTarget(grass);
        this.health += 2;
        if (this.maxHealth < this.health) {
            this.health = this.maxHealth;
        }

    }

    private boolean isAdjacent(Coordinates target) {
        int dx = Math.abs(this.getCoordinates().getX() - target.getX());
        int dy = Math.abs(this.getCoordinates().getY() - target.getY());
        return (dx == 0 && dy == 1) || (dx == 1 && dy == 0);
    }
}


