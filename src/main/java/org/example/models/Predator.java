package org.example.models;

import org.example.service.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.enums.MapField;
import org.example.service.CoordinateService;

import java.util.*;

public class Predator extends Creature {

    public Predator(Integer speed, Integer health, MapField mapField, TargetAwareCoordinateService coordinateService) {
        super(speed, health, mapField, coordinateService);
    }

    @Override
    public void makeMove(GameMap gameMap) {

        if (!this.isAlive()) {
            return;
        }
        Entity target = gameMap.getCoordinateService().findAvailableHerbivore(this, gameMap.getGameMap());

        if (target == null) {
            moveRandomly(gameMap);
            return;
        }

        if (target != null) {
            if (isAdjacent(target.getCoordinates())) {
                if (target instanceof Herbivore) {
                    attackHerbivore((Herbivore) target, gameMap);
                }
            } else {
                moveTowardsTarget(target, gameMap);
            }
        }
    }

    private void attackHerbivore(Herbivore herbivore, GameMap gameMap) {
        herbivore.takeDamage(1); // Наносим урон травоядному
        if (!herbivore.isAlive()) {
            gameMap.deleteEntity(herbivore); // Удаляем травоядное с карты
            gameMap.getCoordinateService().releaseTarget(herbivore); // Освобождаем цель
        }
    }


    private boolean isAdjacent(Coordinates target) {
        int dx = Math.abs(this.getCoordinates().getX() - target.getX());
        int dy = Math.abs(this.getCoordinates().getY() - target.getY());
        return (dx == 1 && dy == 0) || (dx <= 1 && dy <= 0);
    }
}



