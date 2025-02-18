package org.example.models;

import org.example.coordinates.Coordinates;
import org.example.enums.MapField;

public class Grass extends EntityNotAlive {
    private boolean isTaken = false;
    private boolean isTargeted = false;

    public Grass(Coordinates coordinates, MapField mapField) {
        super(mapField, coordinates);
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public boolean isTargeted() {
        return isTargeted;
    }

    public void setTargeted(boolean targeted) {
        isTargeted = targeted;
    }


}
