package org.example;


import org.example.map.GameMap;

public class Main {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
//        gameMap.setRandomPositionObject();
        Simulation simulation = new Simulation(gameMap);

//        simulation.nextTurn();
        simulation.startSimulation();
//        Map map=new Map();
//        map.setRandomPositionObject();
//
//        MapConsoleRenderer renderer = new MapConsoleRenderer();
//        renderer.renderer(map);

//        Creature predator=new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED);
//        Creature herbivore=new Herbivore(2, 3, new Coordinates(20, 1), MapField.FILLED);
//
//
//        Predator predator1 = new Predator(2, 3, new Coordinates(31, 6), MapField.FILLED);
//        Herbivore herbivore1 = new Herbivore(2, 3, new Coordinates(21, 1), MapField.FILLED);
//        BFS bfs=new BFS();
//        List<Coordinates> sd = bfs.getCoordinates(predator1, herbivore1);
//
//        for (Coordinates c : sd) {
//            System.out.println(c);
//        }

    }
}