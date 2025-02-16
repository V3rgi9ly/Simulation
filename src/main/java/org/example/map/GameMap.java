package org.example.map;

import org.example.coordinates.Coordinates;
import org.example.models.*;
import org.example.service.CoordinateService;
import org.example.util.AppConf;

import java.util.*;

public class GameMap {

    private final HashMap<Coordinates, Entity> map;
    private final Integer x;
    private final Integer y;
    CoordinateService coordinateService;

    public GameMap() {
        this.x = AppConf.StartCoordinates.horizontal;
        this.y = AppConf.StartCoordinates.vertical;
        this.map = new HashMap<>();
        coordinateService = new CoordinateService(this);
    }

    public CoordinateService getCoordinateService() {
        return coordinateService;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public HashMap<Coordinates, Entity> getGameMap() {
        return map;
    }

    public void deleteEntity(Entity entity) {
        if (entity != null && map.containsKey(entity.getCoordinates())) {
            map.remove(entity.getCoordinates());
//            System.out.println("Объект " + entity.getClass().getSimpleName() + " удалён с координат " + entity.getCoordinates());
        } else {
//            System.out.println("Объект не найден на карте.");
        }
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void setStaticObjects(Coordinates coordinates, Entity entity) {
        // Удаляем объект со старых координат (если они есть)
        if (entity.getCoordinates() != null) {
            map.remove(entity.getCoordinates());
        }

        // Обновляем координаты объекта
        entity.setCoordinates(coordinates);

        // Добавляем объект на новые координаты
        map.put(coordinates, entity);
//        System.out.println("Объект " + entity.getClass().getSimpleName() + " добавлен на координаты " + coordinates);
    }


}
