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



    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public HashMap<Coordinates, Entity> getGameMap() {
        return map;
    }

    public void deleteEntity(Entity entity) {
        if (entity != null && map.containsKey(entity.getCoordinates())) {
            map.remove(entity.getCoordinates());
        }
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void setStaticObjects(Coordinates coordinates, Entity entity) {
        if (entity.getCoordinates() != null) {
            map.remove(entity.getCoordinates());
        }

        entity.setCoordinates(coordinates);

        map.put(coordinates, entity);
    }

    public boolean hasAliveHerbivores(){
        for (Entity entity : map.values()) {
            if (entity instanceof Herbivore){
                Herbivore herbivore = (Herbivore) entity;
                if (herbivore.isAlive()){
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
