package org.example.models;

import org.example.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.map.GameMap;
import org.example.enums.MapField;
import org.example.service.CoordinateService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Herbivore extends Creature {

    private CoordinateService coordinateService;

    public Herbivore(Integer speed, Integer health, Coordinates location, MapField mapField, TargetAwareCoordinateService coordinateService) {
        super(speed, health, mapField, location, coordinateService);

    }


    @Override
    public void makeMove(GameMap gameMap) {

        if (!this.isAlive()) {
            System.out.println("Травоядное мертво, не двигается.");
            return;
        }

        Entity target = gameMap.getCoordinateService().findAvailableGrass(this, gameMap.getGameMap());

        if (target==null){
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
        gameMap.deleteEntity(grass); // Удаляем траву с карты
        grass.setTaken(false); // Помечаем траву как съеденную
        gameMap.getCoordinateService().releaseTarget(grass); // Освобождаем цель
        this.health += 2; // Увеличиваем здоровье травоядного
        System.out.println("Травоядное съело траву. Здоровье: " + this.health);
    }

    private void moveTowardsTarget(Entity target, GameMap gameMap) {
        List<Coordinates> path = gameMap.getCoordinateService().getShortPath(this, target);
        if (!path.isEmpty()) {
            int steps = Math.min(this.speed, path.size());
            for (int i = 0; i < steps; i++) {
                Coordinates nextStep = path.get(i);
                if (gameMap.isSquareEmpty(nextStep)) {
                    gameMap.deleteEntity(this);
                    this.setCoordinates(nextStep);
                    gameMap.setStaticObjects(nextStep, this);
                    System.out.println("Травоядное переместилось на " + nextStep);
                    break;
                } else {
                    System.out.println("Клетка " + nextStep + " занята.");
                }
            }
        }

    }



    private boolean isAdjacent (Coordinates target){
        int dx = Math.abs(this.getCoordinates().getX() - target.getX());
        int dy = Math.abs(this.getCoordinates().getY() - target.getY());
        return (dx == 0 && dy == 1) || (dx == 1 && dy == 0);
    }
}


