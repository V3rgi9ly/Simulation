package org.example.models;

import org.example.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.enums.MapField;
import org.example.service.CoordinateService;

import java.util.*;

public class Predator extends Creature {

    private CoordinateService coordinateService;
    public Predator(Integer speed, Integer health, Coordinates coordinates, MapField mapField, TargetAwareCoordinateService coordinateService) {
        super(speed, health, mapField, coordinates, coordinateService);

    }

    @Override
    public void makeMove(GameMap gameMap) {

        if (!this.isAlive()){
            System.out.println("Хищник мертв, не двигается.");
            return;
        }
        Entity target = gameMap.getCoordinateService().findAvailableHerbivore(this, gameMap.getGameMap());

       if (target==null){
           moveRandomly(gameMap);
           return;
       }

        if (target != null) {
            if (isAdjacent(target.getCoordinates())) {
                if (target instanceof Herbivore) {
                    attackHerbivore((Herbivore) target, gameMap);
                }
            }
            else {
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

    private void moveTowardsTarget(Entity target, GameMap gameMap) {
        List<Coordinates> path = gameMap.getCoordinateService().getShortPath(this, target);

        if (path.isEmpty()) {
            return;
        }

        if (!path.isEmpty()) {
            int steps = Math.min(this.speed, path.size());
            for (int i = 0; i < steps; i++) {
                Coordinates nextStep = path.get(i);
                if (gameMap.isSquareEmpty(nextStep)) {
                    gameMap.deleteEntity(this);
                    this.setCoordinates(nextStep);
                    gameMap.setStaticObjects(nextStep, this);
                    break;
                } else {
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



