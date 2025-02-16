package org.example.coordinates;

import org.example.map.GameMap;
import org.example.models.Entity;
import org.example.models.Rock;
import org.example.models.Tree;

import java.util.Objects;

public class Coordinates {
    public Integer x;
    public Integer y;


    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;

    }


    public Coordinates shift(CoordinatesShift coordinatesShift) {
        return new Coordinates(this.x + coordinatesShift.getXShift(), this.y + coordinatesShift.getYShift());
    }


    public boolean canShift(CoordinatesShift coordinatesShift, GameMap gameMap) {
        int f = x + coordinatesShift.getXShift();
        int g = y + coordinatesShift.getYShift();

        if ((f <= 0) || (f > gameMap.getX())) {
            return false;
        }
        if (g <= 0 || g > gameMap.getY()) {
            return false;
        }

        Coordinates newCoordinates = new Coordinates(f, g);
        Entity entity = gameMap.getEntity(newCoordinates);
        if (entity instanceof Rock || entity instanceof Tree) {
            return false; // Клетка занята препятствием
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Координата x = " + x + ", y = " + y;
    }
}
