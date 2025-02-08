package org.example.coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoordinatesShift {

    private int xShift;
    private int yShift;

    private  Set<CoordinatesShift> coordinatesShift;

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

    public Integer getXShift() {
        return xShift;
    }

    public Integer getYShift() {
        return yShift;
    }


}
