package com.verapipe.dto;

public class Coordinates {
    private Float startCoordinateX;
    private Float endCoordinateX;
    private Float startCoordinateY;
    private Float endCoordinateY;

    public Coordinates() {
    }

    public Coordinates(Float startCoordinateX, Float endCoordinateX, Float startCoordinateY, Float endCoordinateY) {
        this.startCoordinateX = startCoordinateX;
        this.endCoordinateX = endCoordinateX;
        this.startCoordinateY = startCoordinateY;
        this.endCoordinateY = endCoordinateY;
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
                "startCoordinateX=" + startCoordinateX +
                ", endCoordinateX=" + endCoordinateX +
                ", startCoordinateY=" + startCoordinateY +
                ", endCoordinateY=" + endCoordinateY +
                '}';
    }
}
