package org.example.Creature;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoordinatesShift {

    public int xShift;
    public int yShift;

    public  Set<CoordinatesShift> coordinatesShift;
    public CoordinatesShift() {
        coordinatesShift=new HashSet<>(Arrays.asList(
                new CoordinatesShift(1, 0),
                new CoordinatesShift(0, 1),
                new CoordinatesShift(0, -1),
                new CoordinatesShift(-1, 0)
        ));
    }

    public CoordinatesShift(int xShift, int yShift) {
        this.xShift = xShift;
        this.yShift = yShift;
    }

    public Set<CoordinatesShift> getCoordinatesShift() {
        return coordinatesShift;
    }
}
