package com.verapipe.entities;

import com.verapipe.dto.Coordinates;
import com.verapipe.dto.Pid;
import com.verapipe.dto.PressureTestPackage;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "pressure_test_package")
public class PressureTestPackageEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "pressureTestPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PressureTestPackagePidCoordinatesEntity> pidsAndCoordinatesList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IsometricEntity> isometrics;

    @Column(name = "date", nullable = false)
    private Date date;

    public PressureTestPackageEntity() {
    }

    public PressureTestPackageEntity(PressureTestPackage pressureTestPackage) {
        this.id = pressureTestPackage.getId();
        this.name = pressureTestPackage.getName();
        this.date = pressureTestPackage.getDate();

        // Convert pidsAndCoordinates map from DTO to entity format
        if (pressureTestPackage.getPidsAndCoordinates() != null) {
            this.pidsAndCoordinatesList = new HashSet<>();
            for (Map.Entry<Pid, List<Coordinates>> entry : pressureTestPackage.getPidsAndCoordinates().entrySet()) {
                Pid pid = entry.getKey();
                List<Coordinates> coordinates = entry.getValue();
                if (pid != null && coordinates != null) {
                    this.pidsAndCoordinatesList.add(new PressureTestPackagePidCoordinatesEntity(this, new PidEntity(pid), coordinates));
                }
            }
        }

        // Convert isometrics list from DTO to entity format
        this.isometrics = pressureTestPackage.getIsometrics().stream()
                .map(IsometricEntity::new)
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PressureTestPackagePidCoordinatesEntity> getPidsAndCoordinates() {
        return pidsAndCoordinatesList;
    }

    public void setPidsAndCoordinates(Set<PressureTestPackagePidCoordinatesEntity> pidsAndCoordinatesList) {
        this.pidsAndCoordinatesList = pidsAndCoordinatesList;
    }

    public List<IsometricEntity> getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(List<IsometricEntity> isometrics) {
        this.isometrics = isometrics;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
