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
//            System.out.println("Хищник видит цель: " + target.getClass().getSimpleName() + " на " + target.getCoordinates());
            if (isAdjacent(target.getCoordinates())) {
//                System.out.println("Хищник рядом с целью!");
                if (target instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) target;
                    herbivore.takeDamage(1);
//                    System.out.println("Хищник атаковал травоядное. Здоровье травоядного: " + herbivore.health);
                    if (!herbivore.isAlive()) {
//                        System.out.println("Травоядное погибло!");
                        gameMap.deleteEntity(herbivore);
                    }
                }
            } else {
//                System.out.println("Хищник двигается к цели...");
                List<Coordinates> path = coordinateService.getShortPath(this, target);
                if (!path.isEmpty()) {
                    for (Coordinates nextStep : path) {
                        if (gameMap.isSquareEmpty(nextStep)) {
                            gameMap.deleteEntity(this);
                            this.setCoordinates(nextStep);
                            gameMap.setStaticObjects(nextStep, this);
//                            System.out.println("Хищник переместился на " + nextStep);
                            break;
                        }
                    }
                }
            }
        }else {
//            System.out.println("Хищник не видит цели.");
        }
    }

    private boolean isAdjacent(Coordinates target){
        int dx=Math.abs(this.getCoordinates().x-target.x);
        int dy=Math.abs(this.getCoordinates().y-target.y);
        return (dx==0 && dy==0) || (dx<=1 && dy<=1);
    }
}



