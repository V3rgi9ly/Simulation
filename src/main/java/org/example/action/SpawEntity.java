package org.example.action;

import org.example.service.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.enums.MapField;
import org.example.map.GameMap;
import org.example.models.Grass;
import org.example.models.Herbivore;
import org.example.models.Predator;
import org.example.models.Rock;

public class SpawEntity implements Action {
    @Override
    public void perform(GameMap gameMap) {
        TargetAwareCoordinateService coordinateService = gameMap.getCoordinateService();

        gameMap.setStaticObjects(new Coordinates(31, 6), new Predator(2, 3, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(21, 1), new Herbivore(3, 4, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(14, 9), new Predator(2, 3, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(24, 3), new Herbivore(2, 4, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(10, 10), new Predator(3, 3, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(4, 4), new Herbivore(2, 4, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(25, 6), new Predator(2, 3, MapField.FILLED, coordinateService));
        gameMap.setStaticObjects(new Coordinates(1, 1), new Herbivore(3, 4, MapField.FILLED, coordinateService));

        gameMap.setStaticObjects(new Coordinates(5, 6), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(20, 6), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(31, 9), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(35, 6), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(33, 1), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(4, 6), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(15, 6), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(34, 2), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(27, 5), new Grass(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(11, 8), new Grass(MapField.FILLED));

        gameMap.setStaticObjects(new Coordinates(6, 3), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(24, 1), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(21, 6), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(10, 3), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(21, 7), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(28, 3), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(4, 8), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(12, 5), new Rock(MapField.FILLED));
        gameMap.setStaticObjects(new Coordinates(17, 2), new Rock(MapField.FILLED));
    }
}
