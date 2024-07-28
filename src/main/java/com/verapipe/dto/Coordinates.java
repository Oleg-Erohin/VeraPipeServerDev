package com.verapipe.dto;

import com.verapipe.entities.CoordinatesEntity;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinates {
    private int id;
    private Float startCoordinateX;
    private Float endCoordinateX;
    private Float startCoordinateY;
    private Float endCoordinateY;

    public Coordinates() {
    }

    public Coordinates(int id, Float startCoordinateX, Float endCoordinateX, Float startCoordinateY, Float endCoordinateY) {
        this.id = id;
        this.startCoordinateX = startCoordinateX;
        this.endCoordinateX = endCoordinateX;
        this.startCoordinateY = startCoordinateY;
        this.endCoordinateY = endCoordinateY;
    }

    public Coordinates(CoordinatesEntity coordinatesEntity) {
        this.startCoordinateX = coordinatesEntity.getStartCoordinateX();
        this.endCoordinateX = coordinatesEntity.getEndCoordinateX();
        this.startCoordinateY = coordinatesEntity.getStartCoordinateY();
        this.endCoordinateY = coordinatesEntity.getEndCoordinateY();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getStartCoordinateX() {
        return startCoordinateX;
    }

    public void setStartCoordinateX(Float startCoordinateX) {
        this.startCoordinateX = startCoordinateX;
    }

    public Float getEndCoordinateX() {
        return endCoordinateX;
    }

    public void setEndCoordinateX(Float endCoordinateX) {
        this.endCoordinateX = endCoordinateX;
    }

    public Float getStartCoordinateY() {
        return startCoordinateY;
    }

    public void setStartCoordinateY(Float startCoordinateY) {
        this.startCoordinateY = startCoordinateY;
    }

    public Float getEndCoordinateY() {
        return endCoordinateY;
    }

    public void setEndCoordinateY(Float endCoordinateY) {
        this.endCoordinateY = endCoordinateY;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "id=" + id +
                ", startCoordinateX=" + startCoordinateX +
                ", endCoordinateX=" + endCoordinateX +
                ", startCoordinateY=" + startCoordinateY +
                ", endCoordinateY=" + endCoordinateY +
                '}';
    }
}
