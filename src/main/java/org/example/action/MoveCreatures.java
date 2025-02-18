package org.example.action;

import org.example.map.GameMap;
import org.example.models.Creature;
import org.example.models.Entity;

import java.util.ArrayList;

public class MoveCreatures implements Action {


    @Override
    public void perform(GameMap gameMap) {
        System.out.println("MoveCreatures: начало хода");
        for (Entity entity : new ArrayList<>(gameMap.getGameMap().values())) {
            if (entity instanceof Creature) {
                System.out.println("Передвижение: " + entity.getClass().getSimpleName() + " на " + entity.getCoordinates());
                ((Creature) entity).makeMove(gameMap);
            }
        }
    }
}
