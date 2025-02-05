package org.example;

import org.example.Creature.Creature;
import org.example.Creature.Herbivore;
import org.example.Creature.Predator;
import org.example.inanimateObject.Grass;
import org.example.inanimateObject.Rock;

import java.util.*;

public class GameMap {

    public static final Integer xHorizontal = 35;
    public static final Integer yVertical = 10;

    Random random = new Random();

    public static List<Coordinates> listVisited=new ArrayList<>(List.of(new Coordinates(6,3), new Coordinates(2,5),new Coordinates(24, 1), new Coordinates(21, 6) ));

    Predator predator1 = new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED);
    Herbivore herbivore1 = new Herbivore(2, 4, new Coordinates(21, 1), MapField.FILLED);
    Grass grass1 = new Grass(new Coordinates(2, 5), MapField.FILLED,Obstacle.Obstacle);
    Rock rock1 = new Rock(new Coordinates(6, 3), MapField.FILLED, Obstacle.Obstacle);

    Rock rock2 = new Rock(new Coordinates(24, 1), MapField.FILLED, Obstacle.Obstacle);
    Rock rock3 = new Rock(new Coordinates(21, 6), MapField.FILLED, Obstacle.Obstacle);

    BFS bfs = new BFS();
    List<Coordinates> sd = bfs.getCoordinates(predator1, herbivore1);

    HashMap<Coordinates, Entity> objectss = new HashMap<>();


    public GameMap() {

    }


    public void setStaticObjects(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        objectss.put(coordinates, entity);
    }

    public HashMap<Coordinates, Entity> getStaticObjects(){
        return objectss;
    }

    public void removeCreature(Coordinates coordinates) {
        objectss.remove(coordinates);
    }

    public void moveCreature(Coordinates from, Coordinates to) {
        Entity e = getEntity(from);
        removeCreature(from);
        setStaticObjects(to, e);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !objectss.containsKey(coordinates);
    }

    public HashMap<Coordinates, Entity> getStaricObject() {
        return objectss;
    }

    public Entity deletedStaricObject(Coordinates coordinates) {
        return objectss.remove(coordinates);
    }


    public Entity getEntity(Coordinates coordinates) {
        return objectss.get(coordinates);
    }


    public void setRandomPositionObject() {

        setStaticObjects(predator1.coordinates, predator1);
        setStaticObjects(herbivore1.coordinates, herbivore1);

        setStaticObjects(grass1.coordinates, grass1);
        setStaticObjects(rock1.coordinates, rock1);
        setStaticObjects(rock2.coordinates, rock2);
        setStaticObjects(rock3.coordinates, rock3);

    }

    public void setDeletedCreature(Entity creature) {
        objectss.remove(creature.coordinates, creature);
    }

    public void getListVisited(int counter) {
        GameMap map=new GameMap();
        predator1.coordinates.x = sd.get(counter).x;
        predator1.coordinates.y = sd.get(counter).y;
        predator1.makeTakeover(map,predator1.coordinates);
        setStaticObjects(predator1.coordinates, predator1);

    }

}
