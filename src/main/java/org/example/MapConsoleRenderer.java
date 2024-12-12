package org.example;

public class MapConsoleRenderer {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOXSQUARE = "\u2B1B";
    public static final String lionEmoji = "\uD83E\uDD81";
    public static final String deerEmoji = "\uD83E\uDD8C";
    public static final String deciduousTree = "\uD83C\uDF33";
    public static final String mountain  = "\uD83D\uDDFB";
    public static final String grass  = "\uD83C\uDF40";


    public void renderer(GameMap gameMap) {
        for (int i = 0; i < GameMap.yVertical; i++) {
            String line = "";
            for (int j = 0; j < GameMap.xHorizontal; j++) {
                Coordinates coordinates = new Coordinates(j, i);
                if (gameMap.isSquareEmpty(coordinates)) {
                    line+=getEmptySprite();
                }
                else {
                    line+=getEntitySprite(gameMap.getEntity(coordinates));
                }
            }

            line += ANSI_RESET;
            System.out.println(line);

        }

    }

    private String getEmptySprite() {
        return colorizeMap("", MapField.EMPTY);
    }

    private String colorizeMap(String sprite, MapField mapField) {
        String result = sprite;

        if (mapField == MapField.EMPTY) {
            result = ANSI_RED_BACKGROUND + ANSI_BOXSQUARE + result;
        }
        return result;
    }

    private String selectSpriteforEntity(Entity entity) {
        switch (entity.getClass().getSimpleName()) {

            case "Predator":
                return lionEmoji;
            case "Herbivore":
                return deerEmoji;
            case "Tree":
                return deciduousTree;

            case "Rock":
                return mountain;
            case "Grass":
                return grass;

        }
        return "";
    }

    private String getEntitySprite(Entity entity) {
        return colorizeMap(selectSpriteforEntity(entity), entity.mapField);
    }

}
