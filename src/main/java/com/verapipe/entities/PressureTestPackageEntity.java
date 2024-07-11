package com.verapipe.entities;

import com.verapipe.dto.Coordinates;
import com.verapipe.dto.PressureTestPackage;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Table(name = "pressure_test_package")
public class PressureTestPackageEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pids_coordinates_mapping", joinColumns = @JoinColumn(name = "package_id"))
    @MapKeyJoinColumn(name = "pid_id")
    @Column(name = "coordinates")
    private Map<PidEntity, List<Coordinates>> pidsAndCoordinates;

    @OneToMany(mappedBy = "package", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
        this.pidsAndCoordinates = pressureTestPackage.getPidsAndCoordinates().entrySet().stream()
                .collect(Collectors.toMap(entry -> new PidEntity(entry.getKey()),
                        Map.Entry::getValue));

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

    public Map<PidEntity, List<Coordinates>> getPidsAndCoordinates() {
        return pidsAndCoordinates;
    }

    public void setPidsAndCoordinates(Map<PidEntity, List<Coordinates>> pidsAndCoordinates) {
        this.pidsAndCoordinates = pidsAndCoordinates;
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
