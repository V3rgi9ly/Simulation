package org.example;

import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.map.MapConsoleRenderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final GameMap gameMap;
    private int counter = 0;
//    public Action action=;


    List<Coordinates> list = new ArrayList<>();


    private MapConsoleRenderer renderer = new MapConsoleRenderer();


    public Simulation(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void nextTurn() {
//        action.setPositionObject();
//        initAction(gameMap);
        renderer.renderer(gameMap);

    }

    public void startSimulation() {
////        initAction(gameMap);
//        while(counter<15) {
//
////            actions.turnAction(gameMap, counter);
//            renderer.renderer(gameMap);
//            counter++;
//            System.out.println("\n");
//        }

        gameMap.createDefaultEntity();
        renderer.renderer(gameMap);
//        System.out.println(gameMap.getListVisited());
    }

    public void pausSimulation() {

    }
}
