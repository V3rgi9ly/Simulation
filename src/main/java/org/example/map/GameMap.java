package org.example.map;

import org.example.coordinates.Coordinates;
import org.example.models.*;
import org.example.service.CoordinateService;
import org.example.service.EntityService;
import org.example.util.AppConf;

import java.util.*;

public class GameMap {

    HashMap<Coordinates, Entity> map;
    private final Integer x;
    private final Integer y;
    EntityService entityService;
    CoordinateService coordinateService;

    public GameMap() {
        this.x = AppConf.StartCoordinates.horizontal;
        this.y = AppConf.StartCoordinates.vertical;
        this.entityService = new EntityService();
        this.map = new HashMap<>();
        coordinateService = new CoordinateService(this);
    }

    public void createDefaultEntity() {
        List<Entity> entities = entityService.getEntities();

        for (Entity entity : entities) {
            setStaticObjects(entity.getCoordinates(), entity);
        }
    }

    public void moveEntity(){
        coordinateService.getShortPath(map);
    }

//    public List<Coordinates> getShortPath(){
//        List<Entity> entities = entityService.getEntities();
//
//    }

//    public void getListVisited() {
//        int counter = 14;
//        List<Entity> predators = new ArrayList<>();
//        List<Entity> herbivore = new ArrayList<>();
//        for (Entity entity : map.values()) {
//            if (entity instanceof Predator) {
//                predators.add(entity);
//            }
//            else if (entity instanceof Herbivore) {
//                herbivore.add(entity);
//            }
//        }

//        Predator predator = (Predator) predators.get(0);
//        Herbivore herbivore1 = (Herbivore) herbivore.get(0);
//        return coordinateService.getShortPath(predator,herbivore1);

//        GameMap map = new GameMap();
//        predator1.coordinates.x = sd.get(counter).x;
//        predator1.coordinates.y = sd.get(counter).y;
//        predator1.makeTakeover(map, predator1.coordinates);
//        setStaticObjects(predator1.coordinates, predator1);

//    }


    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public HashMap<Coordinates, Entity> getStaticObjects() {
        return map;
    }

    public void deleteEntity(Entity creature) {
        map.remove(creature.getCoordinates(), creature);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }

    public void setStaticObjects(Coordinates coordinates, Entity entity) {
        entity.getCoordinates().x = coordinates.x;
        entity.getCoordinates().y = coordinates.y;
        map.put(coordinates, entity);
    }


}
