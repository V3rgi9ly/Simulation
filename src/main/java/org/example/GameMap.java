package org.example;

import org.example.Creature.Creature;
import org.example.Creature.Herbivore;
import org.example.Creature.Predator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameMap {

    public static final Integer xHorizontal = 35;
    public static final Integer yVertical = 10;
    Random random = new Random();

    List<Coordinates> listVisited = new ArrayList<Coordinates>();


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

    public HashMap<Coordinates, Entity> getStaricObject(){
        return objectss;
    }

    public Entity deletedStaricObject(Coordinates coordinates) {
        return objectss.remove(coordinates);
    }



    public Entity getEntity(Coordinates coordinates) {
        return objectss.get(coordinates);
    }


    public void setRandomPositionObject(int i) {
        BFS bfs = new BFS();
        Creature predator = new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED);
        Creature herbivore = new Herbivore(2, 3, new Coordinates(20, 1), MapField.FILLED);
        setStaticObjects(predator.coordinates, predator);
        setStaticObjects(herbivore.coordinates, herbivore);

        List<Coordinates> sd=bfs.getCoordinates(predator,herbivore);
        setListVisited(i, sd, predator);
    }

    public void setListVisited(int i, List<Coordinates> listVisited, Creature creaturePredator) {
        deletedStaricObject(creaturePredator.coordinates);
        setStaticObjects(listVisited.get(i), new Predator(2, 3, listVisited.get(i), MapField.FILLED));
    }



//    public List<Coordinates> getListVisited(Creature creatureStart, Creature creatureEnd) {
//        return new Creature(creatureStart,creatureEnd);
//    }


}
