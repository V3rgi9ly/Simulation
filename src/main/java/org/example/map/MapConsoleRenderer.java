package org.example.map;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;
import org.example.models.Entity;
import org.example.util.AppConf;

public class MapConsoleRenderer {

    public void renderer(GameMap gameMap) {
        for (int i = 0; i < gameMap.getY(); i++) {
            String line = "";
            for (int j = 0; j < gameMap.getX(); j++) {
                Coordinates coordinates = new Coordinates(j, i);
                if (gameMap.isSquareEmpty(coordinates)) {
                    line+=getEmptySprite();
                }
                else {
                    line+=getEntitySprite(gameMap.getEntity(coordinates));
                }
            }

            line += AppConf.Image.ANSI_RESET;
            System.out.println(line);

        }

    }

    private String getEmptySprite() {
        return colorizeMap("", MapField.EMPTY);
    }

    private String colorizeMap(String sprite, MapField mapField) {
        String result = sprite;

        if (mapField == MapField.EMPTY) {
            result = AppConf.Image.ANSI_RED_BACKGROUND + AppConf.Image.ANSI_BOXSQUARE + result;
        }
        return result;
    }

    private String selectSpriteforEntity(Entity entity) {
        switch (entity.getClass().getSimpleName()) {

            case "Predator":
                return AppConf.Image.lionEmoji;
            case "Herbivore":
                return AppConf.Image.deerEmoji;
            case "Tree":
                return AppConf.Image.deciduousTree;

            case "Rock":
                return AppConf.Image.mountain;
            case "Grass":
                return AppConf.Image.grass;

        }
        return "";
    }

    private String getEntitySprite(Entity entity) {
        return colorizeMap(selectSpriteforEntity(entity), entity.getMapField());
    }

}
