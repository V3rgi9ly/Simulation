package org.example;


import org.example.Creature.Creature;
import org.example.Creature.Herbivore;
import org.example.Creature.Predator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        GameMap gameMap =new GameMap();
        Simulation simulation=new Simulation(gameMap);
        simulation.nextTurn();
//        Map map=new Map();
//        map.setRandomPositionObject();
//
//        MapConsoleRenderer renderer = new MapConsoleRenderer();
//        renderer.renderer(map);

        Creature predator=new Predator(2, 3, new Coordinates(20, 6), MapField.FILLED);
        Creature herbivore=new Herbivore(2, 3, new Coordinates(20, 1), MapField.FILLED);


        List<Coordinates> sd=predator.breadthFirstSearch(predator,herbivore);




        for(Coordinates c:sd){
            System.out.println(c.toString());
        }





    }
}