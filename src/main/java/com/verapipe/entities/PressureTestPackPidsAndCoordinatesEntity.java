package com.verapipe.entities;

import com.verapipe.dto.Coordinates;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test_pack_pids_and_coordinates")
public class PressureTestPackPidsAndCoordinatesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pressure_test_package_id", nullable = false)
    private PressureTestPackageEntity pressureTestPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid_id", nullable = false)
    private PidEntity pid;

    @ElementCollection
    @CollectionTable(name = "coordinates", joinColumns = @JoinColumn(name = "test_pack_pids_and_coordinates_id"))
    private List<Coordinates> coordinatesList;

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

    public List<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }

    public void setCoordinatesList(List<Coordinates> coordinatesList) {
        this.coordinatesList = coordinatesList;
    }
}
