package org.example.service;

import org.example.coordinates.AStart;
import org.example.coordinates.Coordinates;
import org.example.map.GameMap;
import org.example.models.*;

import org.example.models.Entity;

import java.util.Map;
import java.util.*;

public class CoordinateService {
    private final AStart bfs;

    public CoordinateService(GameMap gameMap) {
        bfs = new AStart(gameMap);

    }

    public List<Coordinates> getShortPath(Entity entity,Entity target) {
           return bfs.getCoordinates(entity,target);
    }

}
