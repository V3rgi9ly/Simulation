package org.example;

import com.sun.source.tree.WhileLoopTree;

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

//        actions.initAction(gameMap);
//        renderer.renderer(gameMap);

    }

    public void startSimulation() {


        while (true){
            actions.initAction(gameMap,counter);
            renderer.renderer(gameMap);
            counter++;
        }
//        for (int i=0;i<list.size();i++){
//
//            System.out.println("\n");
//        }




    }

    public void stopSimulation() {}
}
