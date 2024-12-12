package org.example;


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


    }
}