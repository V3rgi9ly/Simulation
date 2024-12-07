package org.example;

import org.example.Creature.Creature;
import org.example.Creature.Herbivore;
import org.example.Creature.Predator;
import org.example.inanimateObject.Grass;
import org.example.inanimateObject.Rock;
import org.example.inanimateObject.InanimObject;
import org.example.inanimateObject.Tree;

import java.util.HashMap;
import java.util.Random;

public class Map {

    public static final Integer xHorizontal=35;
    public static final Integer yVertical=10;
    Random random=new Random();

//    HashMap<Coordinates, Creature> creatures=new HashMap<>();
//    HashMap<Coordinates, InanimObject> staticObjects=new HashMap<>();

    HashMap<Coordinates, Entity> objectss=new HashMap<>();

//    public void setCreatures(Coordinates coordinates, Creature creature) {
//        creature.coordinates=coordinates;
//        creatures.put(coordinates, creature);
//    }
//
//    public void setStaticObjects(Coordinates coordinates, InanimObject inanimObject) {
//        inanimObject.coordinates=coordinates;
//        staticObjects.put(coordinates, inanimObject);
//    }

    public Map(){

    }


        public void setStaticObjects(Coordinates coordinates, Entity entity) {
        entity.coordinates=coordinates;
        objectss.put(coordinates, entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !objectss.containsKey(coordinates);
    }

//    public boolean isSquareEmptyStaticObject(Coordinates coordinates) {
//        return !staticObjects.containsKey(coordinates);
//    }
//
//
//    public boolean isSquareEmpty(Coordinates coordinates) {
//        return !creatures.containsKey(coordinates);
//    }

    public Entity getEntity(Coordinates coordinates) {
        return objectss.get(coordinates);
    }


//    public Creature getCreature(Coordinates coordinates) {
//        return creatures.get(coordinates);
//    }
//
//    public InanimObject getStaticObject(Coordinates coordinates) {
//        return staticObjects.get(coordinates);
//    }


    public void setRandomPositionObject() {
//        setCreatures(new Coordinates(31, 2),new Predator(2, 3,new Coordinates(31, 2), MapField.FILLED));
//        setCreatures(new Coordinates(21, 6),new Herbivore(2, 3,new Coordinates(21, 6), MapField.FILLED));
//
//        setStaticObjects(new Coordinates(2,5),new Grass(new Coordinates(2,5), MapField.FILLED));
//        setStaticObjects(new Coordinates(6,3),new Rock(new Coordinates(6,3), MapField.FILLED));
//        setStaticObjects(new Coordinates(5,2),new Tree(new Coordinates(5,2), MapField.FILLED));

        setStaticObjects(new Coordinates(31, 2),new Predator(2, 3,new Coordinates(31, 2), MapField.FILLED));
        setStaticObjects(new Coordinates(21, 6),new Herbivore(2, 3,new Coordinates(21, 6), MapField.FILLED));


        setStaticObjects(new Coordinates(2,5),new Grass(new Coordinates(2,5), MapField.FILLED));
        setStaticObjects(new Coordinates(6,3),new Rock(new Coordinates(6,3), MapField.FILLED));
        setStaticObjects(new Coordinates(5,2),new Tree(new Coordinates(5,2), MapField.FILLED));
    }



}
