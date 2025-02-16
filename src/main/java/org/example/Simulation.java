package org.example;

import org.example.action.Action;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.map.MapConsoleRenderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final GameMap gameMap;
    private int counter = 0;

    List<Action> iniActions;
    List<Action> turnActions;
    private MapConsoleRenderer renderer = new MapConsoleRenderer();


    public Simulation(GameMap gameMap) {
        this.gameMap = gameMap;
        iniActions = new ArrayList<>();
        turnActions=new ArrayList<>();
    }

    public void setIniActions(Action action) {
        iniActions.add(action);
    }

    public void setTurnActions(Action action) {
        turnActions.add(action);
    }

    public void nextTurn() {
        counter++;
        for (Action action:turnActions){
            action.perform(gameMap);
        }
        renderer.renderer(gameMap);
    }

    public void startSimulation() {

        for (Action action : iniActions) {
            action.perform(gameMap);
        }

        while (true){
            nextTurn();
            System.out.println("\n");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void pausSimulation() {

    }
}
