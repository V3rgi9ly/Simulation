package org.example.models;


import org.example.service.TargetAwareCoordinateService;
import org.example.coordinates.Coordinates;
import org.example.enums.MapField;

public abstract class Entity  {
    protected Coordinates coordinates;
    protected MapField mapField;
    protected TargetAwareCoordinateService coordinateService;

    protected Entity() {
        this.mapField = mapField;
    }

    public MapField getMapField() {
        return mapField;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }




}
