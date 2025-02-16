package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.enums.MapField;
import org.example.service.CoordinateService;

import java.util.List;

public class Herbivore extends Creature {

    private CoordinateService coordinateService;
    public Herbivore(Integer speed, Integer health, Coordinates location, MapField mapField, CoordinateService coordinateService) {
        super(speed, health, mapField, location);
        this.coordinateService = coordinateService;
    }


    @Override
    public void makeMove(GameMap gameMap) {

        if (!this.isAlive()){
//            System.out.println("Herbivore is dead");
            return;
        }

        Entity target = coordinateService.findTarget(this, gameMap.getGameMap());
        if (target != null) {
//            System.out.println("Травоядное видит цель: " + target.getClass().getSimpleName() + " на " + target.getCoordinates());
            if (isAdjacent(target.getCoordinates())){
//                System.out.println("Травоядное на клетке с травой!");
                if (target instanceof Grass) {
                    gameMap.deleteEntity(target);
                    this.health += 2;
//                    System.out.println("Травоядное съело траву. Здоровье: " + this.health);
                }
            } else {
//                System.out.println("Травоядное двигается к траве...");
                List<Coordinates> path = coordinateService.getShortPath(this, target);
                if (!path.isEmpty()) {
                    for (Coordinates nextStep : path) {
                        if (gameMap.isSquareEmpty(nextStep)) {
                            gameMap.deleteEntity(this);
                            this.setCoordinates(nextStep);
                            gameMap.setStaticObjects(nextStep, this);
//                            System.out.println("Травоядное переместилось на " + nextStep);
                            break;
                        }
                    }
                }
            }
        }else {
//            System.out.println("Травоядное не видит травы.");
        }
    }

    private boolean isAdjacent(Coordinates target) {
        int dx = Math.abs(this.getCoordinates().x - target.x);
        int dy = Math.abs(this.getCoordinates().y - target.y);
        return (dx == 0 && dy == 1) || (dx == 1 && dy == 0);
    }
}



