package org.example;


import org.example.Creature.Creature;
import org.example.Creature.Predator;
import org.example.inanimateObject.InanimObject;
import org.example.inanimateObject.Rock;

public class Simulation {
    public static void main(String[] args) {

        Map map=new Map();
        map.setRandomPositionObject();

        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.renderer(map);
//        InanimObject inanimObject=new Rock(new Coordinates(2,5), MapField.FILLED);
//
//        System.out.println(inanimObject.getClass().getSimpleName());

    }
}