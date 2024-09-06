package com.verapipe.dto;

import com.verapipe.entities.CoordinateEntity;
import com.verapipe.entities.IsometricLocationInSheetEntity;

import java.util.HashSet;
import java.util.Set;

public class IsometricLocationInSheet {

    private int id;

    private Integer sheet;

    private Set<Coordinate> coordinateOnSheet;

    public IsometricLocationInSheet() {
    }

    public IsometricLocationInSheet(Integer sheet, Set<Coordinate> coordinateOnSheet) {
        this.sheet = sheet;
        this.coordinateOnSheet = coordinateOnSheet;
    }

    public IsometricLocationInSheet(int id, Integer sheet, Set<Coordinate> coordinateOnSheet) {
        this.id = id;
        this.sheet = sheet;
        this.coordinateOnSheet = coordinateOnSheet;
    }

    public IsometricLocationInSheet(IsometricLocationInSheetEntity isometricLocationInSheetEntity) {
        this.id = isometricLocationInSheetEntity.getId();
        this.sheet = isometricLocationInSheetEntity.getSheet();
        this.coordinateOnSheet = initializeCoordinatesOnSheet(isometricLocationInSheetEntity.getCoordinatesOnSheet());
    }

    private Set<Coordinate> initializeCoordinatesOnSheet(Set<CoordinateEntity> coordinatesOnSheet) {
        Set<Coordinate> tempCoordinates = new HashSet<>();
        for (CoordinateEntity coordinateEntity : coordinatesOnSheet){
            Coordinate tempCoordinateEntity = new Coordinate(coordinateEntity);
            tempCoordinates.add(tempCoordinateEntity);
        }
        return tempCoordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSheet() {
        return sheet;
    }

    public void setSheet(Integer sheet) {
        this.sheet = sheet;
    }

    public Set<Coordinate> getCoordinatesOnSheet() {
        return coordinateOnSheet;
    }

    public void setCoordinatesOnSheet(Set<Coordinate> coordinateOnSheet) {
        this.coordinateOnSheet = coordinateOnSheet;
    }

    @Override
    public String toString() {
        return "IsometricLocationInSheet{" +
                "id=" + id +
                ", sheet=" + sheet +
                ", coordinatesOnSheet=" + coordinateOnSheet +
                '}';
    }
}
