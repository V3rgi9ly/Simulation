package org.example;

import org.example.Creature.Creature;
import org.example.Creature.Predator;

import java.util.List;

public class Actions {



    public void initAction(GameMap gameMap) {

        gameMap.setRandomPositionObject();


    }

    public void turnAction(GameMap gameMap,  int counter) {
        gameMap.getListVisited(counter);

    }

}
