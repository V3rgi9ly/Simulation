package org.example.action;

import org.example.map.GameMap;
import org.example.models.Creature;
import org.example.models.Entity;

import java.util.ArrayList;

public class MoveCreatures implements Action {


    @Override
    public void perform(GameMap gameMap) {
        for (Entity entity : new ArrayList<>(gameMap.getGameMap().values())) {
            if (entity instanceof Creature) {
                ((Creature) entity).makeMove(gameMap);
            }
        }
    }
}
