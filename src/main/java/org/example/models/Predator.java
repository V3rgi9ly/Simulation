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
            List<Coordinates> path=coordinateService.getShortPath(this, target);
            if (!path.isEmpty()) {
                for (Coordinates nextStep : path) {
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



