package org.example;

import org.example.Creature.Creature;
import org.example.Creature.Sprite;

import java.rmi.MarshalledObject;

public class MapConsoleRenderer {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOXSQUARE = "\u2B1B";
    public static final String lionEmoji = "\uD83E\uDD81";
    public static final String deerEmoji = "\uD83E\uDD8C";
    public static final String deciduousTree = "\uD83C\uDF33";


    public void renderer(Map map) {
        for (int i = 0; i <=  Map.yVertical; i++) {
            String line="";
            for (int j = 0; j <= Map.xHorizontal; j++) {
                Coordinates coordinates = new Coordinates(j, i);
                if (map.isSquareEmpty(coordinates)) {
                    line+=getEmptySprite();
                }
                else {
                    line+=getCreatureSprite(map.getCreature(coordinates));
                }
            }

            line+=ANSI_RESET;
            System.out.println(line);

        }

    }

    private String getEmptySprite() {
        return colorizeMap("   ", MapField.EMPTY);
    }

    private String colorizeMap(String sprite, MapField mapField) {
        String result = sprite;

        if (mapField ==MapField.EMPTY ) {
            result = ANSI_RED_BACKGROUND + result;
        }

        return result;
    }



    private String selectSpriteforCreatute(Creature creature) {
        switch (creature.getClass().getSimpleName()) {
            case "Predator":
                return lionEmoji;
            case "Herbivore":
                return deerEmoji;
        }
        return "";
    }

    private String getCreatureSprite(Creature creature) {
        return colorizeMap(selectSpriteforCreatute(creature)+" ",creature.mapField);
    }

}
