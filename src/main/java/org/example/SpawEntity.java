package org.example;

import org.example.action.Action;
import org.example.coordinates.Coordinates;
import org.example.enums.MapField;
import org.example.map.GameMap;
import org.example.models.Grass;
import org.example.models.Herbivore;
import org.example.models.Predator;
import org.example.models.Rock;
import org.example.service.CoordinateService;

public class SpawEntity implements Action {
    @Override
    public void perform(GameMap gameMap) {
        CoordinateService coordinateService=gameMap.getCoordinateService();
        gameMap.setStaticObjects(new Coordinates(31, 6),new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED, coordinateService));
        gameMap.setStaticObjects( new Coordinates(21, 1),new Herbivore(2, 4, new Coordinates(21, 1), MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(6, 3),new Rock(new Coordinates(6, 3), MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(24, 1),new Rock(new Coordinates(24, 1), MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(21, 6),new Rock(new Coordinates(21, 6), MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(5, 6),new Grass(new Coordinates(21, 6), MapField.FILLED));
    }
}
