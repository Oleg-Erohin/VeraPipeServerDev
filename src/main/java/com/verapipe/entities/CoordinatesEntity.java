package com.verapipe.entities;

import com.verapipe.dto.Coordinates;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
public class CoordinatesEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "start_coordinate_x", unique = false, nullable = false)
    private Float startCoordinateX;

    @Column(name = "end_coordinate_x", unique = false, nullable = false)
    private Float endCoordinateX;

    @Column(name = "start_coordinate_y", unique = false, nullable = false)
    private Float startCoordinateY;

    @Column(name = "end_coordinate_y", unique = false, nullable = false)
    private Float endCoordinateY;

    @ManyToOne(fetch = FetchType.LAZY)
    private PressureTestPackPidsAndCoordinatesEntity pressureTestPackPidsAndCoordinates;


    public CoordinatesEntity() {
    }

    public CoordinatesEntity(int id, Float startCoordinateX, Float endCoordinateX, Float startCoordinateY, Float endCoordinateY) {
        this.id = id;
        this.startCoordinateX = startCoordinateX;
        this.endCoordinateX = endCoordinateX;
        this.startCoordinateY = startCoordinateY;
        this.endCoordinateY = endCoordinateY;
    }

    public CoordinatesEntity(Coordinates coordinates) {
        this.startCoordinateX = coordinates.getStartCoordinateX();
        this.endCoordinateX = coordinates.getEndCoordinateX();
        this.startCoordinateY = coordinates.getStartCoordinateY();
        this.endCoordinateY = coordinates.getEndCoordinateY();
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

    public PressureTestPackPidsAndCoordinatesEntity getPressureTestPackPidsAndCoordinates() {
        return pressureTestPackPidsAndCoordinates;
    }

    public void setPressureTestPackPidsAndCoordinates(PressureTestPackPidsAndCoordinatesEntity pressureTestPackPidsAndCoordinates) {
        this.pressureTestPackPidsAndCoordinates = pressureTestPackPidsAndCoordinates;
    }
}
