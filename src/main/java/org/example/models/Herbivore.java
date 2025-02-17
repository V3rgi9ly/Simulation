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
            return;
        }

        Entity target = coordinateService.findTarget(this, gameMap.getGameMap());
        if (target != null) {
            if (isAdjacent(target.getCoordinates())){
                if (target instanceof Grass) {
                    gameMap.deleteEntity(target);
                    this.health += 2;
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

    private boolean isAdjacent(Coordinates target) {
        int dx = Math.abs(this.getCoordinates().getX() - target.getX());
        int dy = Math.abs(this.getCoordinates().getY() - target.getY());
        return (dx == 0 && dy == 1) || (dx == 1 && dy == 0);
    }
}



