package org.example.service;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;
import org.example.enums.Obstacle;
import org.example.models.*;

import java.util.ArrayList;
import java.util.List;

//Entity predator1 = new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED);
//Entity herbivore1 = new Herbivore(2, 4, new Coordinates(21, 1), MapField.FILLED);
//Entity grass1 = new Grass(new Coordinates(2, 5), MapField.FILLED, Obstacle.Obstacle);
//Entity rock1 = new Rock(new Coordinates(6, 3), MapField.FILLED, Obstacle.Obstacle);
//
//Entity rock2 = new Rock(new Coordinates(24, 1), MapField.FILLED, Obstacle.Obstacle);
//Entity rock3 = new Rock(new Coordinates(21, 6), MapField.FILLED, Obstacle.Obstacle);


public class EntityService {
    public EntityService() {

    }

    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED));
        entities.add(new Herbivore(2, 4, new Coordinates(21, 1), MapField.FILLED));
        entities.add(new Grass(new Coordinates(2, 5), MapField.FILLED, Obstacle.Obstacle));
        entities.add(new Rock(new Coordinates(6, 3), MapField.FILLED, Obstacle.Obstacle));
        entities.add(new Rock(new Coordinates(24, 1), MapField.FILLED, Obstacle.Obstacle));
        entities.add(new Rock(new Coordinates(21, 6), MapField.FILLED, Obstacle.Obstacle));

        return entities;
    }
}
