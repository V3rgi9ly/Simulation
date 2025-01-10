package org.example;

public class Simulation {

    private final GameMap gameMap;
    private int counter;
    Actions actions=new Actions();


    private MapConsoleRenderer renderer= new MapConsoleRenderer();


    public Simulation(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void nextTurn(){
        actions.initAction(gameMap);
        renderer.renderer(gameMap);
    }

    public void startSimulation() {
        while (true){
            
        }

    }

    public void stopSimulation() {}
}
