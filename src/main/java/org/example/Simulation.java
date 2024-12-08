package org.example;

public class Simulation {

    private final Map map;
    private int counter;
    Actions actions=new Actions();


    private MapConsoleRenderer renderer= new MapConsoleRenderer();


    public Simulation(Map map) {
        this.map = map;
    }

    public void nextTurn(){
        actions.initAction(map);
        renderer.renderer(map);
    }

    public void startSimulation() {}

    public void stopSimulation() {}
}
