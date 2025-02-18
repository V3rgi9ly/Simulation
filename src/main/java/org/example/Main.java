package org.example;


import org.example.action.MoveCreatures;
import org.example.action.SpawEntity;
import org.example.map.GameMap;

public class Main {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        Simulation simulation = new Simulation(gameMap);
        simulation.setTurnActions(new MoveCreatures());
        simulation.setIniActions(new SpawEntity());
        simulation.startSimulation();

    }
}