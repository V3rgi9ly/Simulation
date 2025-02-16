package org.example;

import org.example.action.Action;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.models.Creature;
import org.example.models.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
