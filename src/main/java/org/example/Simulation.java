package org.example;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final GameMap gameMap;
    private int counter=0;
    Actions actions=new Actions();
    List<Coordinates> list=new ArrayList<>();


    private MapConsoleRenderer renderer= new MapConsoleRenderer();


    public Simulation(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void nextTurn(){
        actions.initAction(gameMap);

    }

    public void startSimulation() {
        list=actions.initAction(gameMap);
        for (int i=0;i<list.size();i++){

            renderer.renderer(gameMap);
        }




    }

    public void stopSimulation() {}
}
