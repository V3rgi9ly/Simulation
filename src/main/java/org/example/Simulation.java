package org.example;

public class Simulation {

    private  Map map=new Map();
    private  int counter;
    Actions actions=new Actions();


    private MapConsoleRenderer renderer= new MapConsoleRenderer();


//    public Simulation(Map map, int counter) {
//        this.map = map;
//        this.counter = counter;
//    }

    public void nextTurn(){
        actions.initAction(map);
        renderer.renderer(map);
    }

    public void startSimulation() {}

    public void stopSimulation() {}
}
