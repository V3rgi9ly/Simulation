package org.example;

import org.example.Creature.Creature;
import org.example.Creature.Herbivore;
import org.example.Creature.Predator;
import org.example.Creature.Sprite;

import java.util.HashMap;
import java.util.Random;

public class Map {

    public static final Integer xHorizontal=35;
    public static final Integer yVertical=10;
    Random random=new Random();

    HashMap<Coordinates, Creature> creatures=new HashMap<>();

    public void setCreatures(Coordinates coordinates, Creature creature) {
        creature.coordinates=coordinates;
        creatures.put(coordinates, creature);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !creatures.containsKey(coordinates);
    }

    public void setRandomCreturePosition() {
        setCreatures(new Coordinates(31, 2),new Predator(2, 3,new Coordinates(31, 2), MapField.FILLED));
        setCreatures(new Coordinates(21, 6),new Herbivore(2, 3,new Coordinates(21, 6), MapField.FILLED));
    }

    public Creature getCreature(Coordinates coordinates) {
        return creatures.get(coordinates);
    }


}
