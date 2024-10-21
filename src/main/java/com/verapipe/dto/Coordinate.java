package com.verapipe.dto;

import com.verapipe.entities.CoordinateEntity;

public class Coordinate {
    private int id;
    private Float x;
    private Float y;

    public Coordinate() {
    }

    public Coordinate(int id, Float x, Float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Coordinate(CoordinateEntity coordinateEntity) {
        this.x = coordinateEntity.getX();
        this.y = coordinateEntity.getY();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
