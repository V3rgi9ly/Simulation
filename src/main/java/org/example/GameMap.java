package org.example;

import com.sun.source.tree.Tree;
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

    List<Coordinates> listVisited = new ArrayList<Coordinates>();

    Predator predator1 = new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED);
    Herbivore herbivore1 = new Herbivore(2, 3, new Coordinates(21, 1), MapField.FILLED);
    Grass grass1 = new Grass(new Coordinates(2, 5), MapField.FILLED);
    Rock rock1 = new Rock(new Coordinates(6, 3), MapField.FILLED);

    BFS bfs = new BFS();
    List<Coordinates> sd = bfs.getCoordinates(predator1, herbivore1);

    HashMap<Coordinates, Entity> objectss = new HashMap<>();


    public GameMap() {

    }


    public void setStaticObjects(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        objectss.put(coordinates, entity);
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
    }

    public void getListVisited(int counter) {

        predator1.coordinates.x = sd.get(counter).x;
        predator1.coordinates.y = sd.get(counter).y;
        setStaticObjects(predator1.coordinates, predator1);

    }



}
