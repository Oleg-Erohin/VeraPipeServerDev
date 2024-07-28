package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test_pack_pids_and_coordinates")
public class PressureTestPackPidsAndCoordinatesEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PressureTestPackageEntity pressureTestPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    private PidEntity pid;

    @OneToMany(mappedBy = "pressureTestPackPidsAndCoordinates")
    private List<CoordinatesEntity> coordinatesList;

    public PressureTestPackPidsAndCoordinatesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PressureTestPackageEntity getPressureTestPackage() {
        return pressureTestPackage;
    }

    public void setPressureTestPackage(PressureTestPackageEntity pressureTestPackage) {
        this.pressureTestPackage = pressureTestPackage;
    }

    public PidEntity getPid() {
        return pid;
    }

    public void setPid(PidEntity pid) {
        this.pid = pid;
    }

    public List<CoordinatesEntity> getCoordinatesList() {
        return coordinatesList;
    }

    public void setCoordinatesList(List<CoordinatesEntity> coordinatesList) {
        this.coordinatesList = coordinatesList;
    }
}
