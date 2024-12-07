package org.example;


public class Main {
    public static void main(String[] args) {

        Map map=new Map();
        map.setRandomPositionObject();

        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.renderer(map);


    }
}