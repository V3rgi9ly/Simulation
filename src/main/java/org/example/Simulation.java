package org.example;


import org.example.Creature.Creature;
import org.example.Creature.Predator;

public class Simulation {
    public static void main(String[] args) {

        Map map=new Map();
        map.setRandomCreturePosition();

        MapConsoleRenderer renderer = new MapConsoleRenderer();
        Creature creature=new Predator(2,3,new Coordinates(31,2));
        renderer.renderer(map);
    }
}