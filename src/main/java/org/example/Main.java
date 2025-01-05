package org.example;


import org.example.Creature.Creature;
import org.example.Creature.Herbivore;
import org.example.Creature.Predator;

import java.util.List;
import java.util.Queue;
import java.util.Set;

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

        Creature predator=new Predator(2, 3, new Coordinates(31, 2), MapField.FILLED);
        Creature herbivore=new Herbivore(2, 3, new Coordinates(21, 6), MapField.FILLED);


        List<Coordinates> sd=predator.breadthFirstSearch(predator,herbivore);

        for(Coordinates c:sd){
            System.out.println(c.toString());
        }





    }
}