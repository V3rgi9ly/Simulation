package org.example;


import org.example.map.GameMap;

public class Main {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
//        gameMap.setRandomPositionObject();
        Simulation simulation = new Simulation(gameMap);
//        simulation.nextTurn();
        simulation.setTurnActions(new MoveCreatures());
        simulation.setIniActions(new SpawEntity());
        simulation.startSimulation();

    }
}