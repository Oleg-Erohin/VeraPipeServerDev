package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;
import com.verapipe.dto.PressureTestPackage;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pressure_test_package")
public class PressureTestPackageEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "pressureTestPackage")
    private Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsometrics;

    @Column(name = "date", nullable = false)
    private Date date;

    public PressureTestPackageEntity() {
    }

    public PressureTestPackageEntity(PressureTestPackage pressureTestPackage) throws JsonProcessingException {
        this.id = pressureTestPackage.getId();
        this.name = pressureTestPackage.getName();
        this.pidsAndIsometrics = initializePidsAndIsometrics(pressureTestPackage.getPidsAndIsometrics());
        this.date = pressureTestPackage.getDate();
    }

    private Set<PressureTestPackPidAndIsomtricsEntity> initializePidsAndIsometrics(Map<Pid, List<Isometric>> pidsAndIsometrics) throws JsonProcessingException {
        Set<PressureTestPackPidAndIsomtricsEntity> tempPidsAndIsometrics = new HashSet<>();
        for (Map.Entry<Pid, List<Isometric>> pidAndIsometrics : pidsAndIsometrics.entrySet()) {
            PressureTestPackPidAndIsomtricsEntity tempPidAndIsometricsEntity = new PressureTestPackPidAndIsomtricsEntity();

            PidEntity pidEntity = new PidEntity(pidAndIsometrics.getKey());
            tempPidAndIsometricsEntity.setPid(pidEntity);

            Set<IsometricEntity> isometricEntities = new HashSet<>();
            for (Isometric isometric : pidAndIsometrics.getValue()){
                IsometricEntity isometricEntity = new IsometricEntity(isometric);
                isometricEntities.add(isometricEntity);
            }
            tempPidAndIsometricsEntity.setIsometrics(isometricEntities);
        }
        return tempPidsAndIsometrics;
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

    public Set<PressureTestPackPidAndIsomtricsEntity> getPidsAndIsometrics() {
        return pidsAndIsometrics;
    }

    public void setPidsAndIsometrics(Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsometrics) {
        this.pidsAndIsometrics = pidsAndIsometrics;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
