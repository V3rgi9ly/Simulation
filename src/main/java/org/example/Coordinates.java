package org.example;

import org.example.Creature.CoordinatesShift;

import java.util.Objects;

public class Coordinates {
    public Integer x;
    public Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }


    public Coordinates shift(CoordinatesShift coordinatesShift){
        return new Coordinates(this.x+ coordinatesShift.xShift, this.y+coordinatesShift.yShift);
    }

    public boolean canShift(CoordinatesShift coordinatesShift){
        int f=x+coordinatesShift.xShift;
        int g=y+coordinatesShift.yShift;

        if ((f<=0) || (f> GameMap.xHorizontal)) {
            return false;
        } else if (g<=0 || g> GameMap.yVertical) {
            return false;
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
