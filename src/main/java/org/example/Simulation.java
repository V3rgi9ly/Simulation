package org.example;


import org.example.Creature.Creature;
import org.example.Creature.Predator;

public class Simulation {
    public static void main(String[] args) {

        Map map=new Map();
        map.setRandomPositionObject();

        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.renderer(map);
    }
}