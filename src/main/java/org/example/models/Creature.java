package org.example.models;

import org.example.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.coordinates.CoordinatesShift;
import org.example.enums.MapField;
import org.example.map.GameMap;
import java.util.*;

public abstract class Creature extends Entity  {
    protected Integer speed;
    protected Integer health;
    protected final MapField mapField;

    protected Creature(Integer speed, Integer health, MapField mapField, Coordinates coordinates, TargetAwareCoordinateService coordinateService) {
        this.speed = speed;
        this.health = health;
        this.mapField = mapField;
        this.coordinateService = coordinateService;
    }


    public abstract void makeMove(GameMap gameMap);

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health<=0){
            this.health=0;
        }
    }

    public boolean isAlive() {
        return this.health>0;
    }

    protected void moveRandomly(GameMap gameMap) {
        List<CoordinatesShift> possibleMoves = new ArrayList<>(new CoordinatesShift().getCoordinatesShift());
        Collections.shuffle(possibleMoves); // Перемешиваем направления

        for (CoordinatesShift shift : possibleMoves) {
            Coordinates newCoordinates = this.getCoordinates().shift(shift);
            if (gameMap.isSquareEmpty(newCoordinates)) { // Проверяем, свободна ли клетка
                gameMap.deleteEntity(this);
                this.setCoordinates(newCoordinates);
                gameMap.setStaticObjects(newCoordinates, this);
                System.out.println("Травоядное случайно переместилось на " + newCoordinates);
                return;
            }
        }
        System.out.println("Травоядное не смогло найти свободное место для случайного движения.");
    }


}
