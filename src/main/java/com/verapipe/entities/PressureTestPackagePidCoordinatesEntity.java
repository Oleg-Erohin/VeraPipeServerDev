package com.verapipe.entities;

import com.verapipe.dto.Coordinates;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pressure_test_package_pid_coordinates")
public class PressureTestPackagePidCoordinatesEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private PressureTestPackageEntity pressureTestPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private PidEntity pid;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "coordinates", joinColumns = @JoinColumn)
    @Column(name = "coordinates")
    private List<Coordinates> coordinates;

    public PressureTestPackagePidCoordinatesEntity() {}

    public PressureTestPackagePidCoordinatesEntity(PressureTestPackageEntity pressureTestPackage, PidEntity pid, List<Coordinates> coordinates) {
        this.pressureTestPackage = pressureTestPackage;
        this.pid = pid;
        this.coordinates = coordinates;
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

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }
}
