package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.PressureTestPackagePidAndIsometrics;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test_pack_pids_and_isometrics")
public class PressureTestPackPidAndIsomtricsEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PressureTestPackageEntity pressureTestPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    private PidEntity pid;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<IsometricEntity> isometrics;

    public PressureTestPackPidAndIsomtricsEntity() {
    }

    public PressureTestPackPidAndIsomtricsEntity(PressureTestPackagePidAndIsometrics pressureTestPackagePidAndIsometrics) throws JsonProcessingException {
        this.id = pressureTestPackagePidAndIsometrics.getId();
        this.pid = new PidEntity(pressureTestPackagePidAndIsometrics.getPid());
        this.isometrics = initializeIsometrics(pressureTestPackagePidAndIsometrics.getIsometrics());
    }

    private Set<IsometricEntity> initializeIsometrics(Set<Isometric> isometrics) throws JsonProcessingException {
        Set<IsometricEntity> isometricEntities = new HashSet<>();
        for (Isometric isometric : isometrics) {
            IsometricEntity isometricEntity = new IsometricEntity(isometric);
            isometricEntities.add(isometricEntity);
        }
        return isometricEntities;

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

    public Set<IsometricEntity> getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(Set<IsometricEntity> isometrics) {
        this.isometrics = isometrics;
    }
}
