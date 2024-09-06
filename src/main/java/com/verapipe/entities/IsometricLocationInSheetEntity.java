package com.verapipe.entities;

import com.verapipe.dto.Coordinate;
import com.verapipe.dto.IsometricLocationInSheet;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "isometric_location_in_sheet")
public class IsometricLocationInSheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sheet", unique = false, nullable = false)
    private Integer sheet;

    @OneToMany(mappedBy = "isometricLocationInSheet")
    private Set<CoordinateEntity> coordinatesOnSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    private IsometricLocationInPidEntity isometricLocationInPid;

    public IsometricLocationInSheetEntity() {
    }

    public IsometricLocationInSheetEntity(IsometricLocationInSheet isometricLocationInSheet) {
        this.id = isometricLocationInSheet.getId();
        this.sheet = isometricLocationInSheet.getSheet();
        this.coordinatesOnSheet = initializeCoordinatesOnSheet(isometricLocationInSheet.getCoordinatesOnSheet());
    }

    private Set<CoordinateEntity> initializeCoordinatesOnSheet(Set<Coordinate> coordinateOnSheet) {
        Set<CoordinateEntity> tempCoordinatesEntities = new HashSet<>();
        for (Coordinate coordinate : coordinateOnSheet){
            CoordinateEntity tempCoordinateEntity = new CoordinateEntity(coordinate);
            tempCoordinatesEntities.add(tempCoordinateEntity);
        }
        return tempCoordinatesEntities;
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

    public Set<CoordinateEntity> getCoordinatesOnSheet() {
        return coordinatesOnSheet;
    }

    public void setCoordinatesOnSheet(Set<CoordinateEntity> coordinatesOnSheet) {
        this.coordinatesOnSheet = coordinatesOnSheet;
    }

    public IsometricLocationInPidEntity getIsometricLocationInPid() {
        return isometricLocationInPid;
    }

    public void setIsometricLocationInPid(IsometricLocationInPidEntity isometricLocationInPid) {
        this.isometricLocationInPid = isometricLocationInPid;
    }
}
