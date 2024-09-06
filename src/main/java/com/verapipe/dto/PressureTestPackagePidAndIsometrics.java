package com.verapipe.dto;

import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.PressureTestPackPidAndIsomtricsEntity;

import java.util.HashSet;
import java.util.Set;

public class PressureTestPackagePidAndIsometrics {
    private int id;
    private Pid pid;
    private Set<Isometric> isometrics;

    public PressureTestPackagePidAndIsometrics() {
    }

    public PressureTestPackagePidAndIsometrics(Pid pid, Set<Isometric> isometrics) {
        this.pid = pid;
        this.isometrics = isometrics;
    }

    public PressureTestPackagePidAndIsometrics(int id, Pid pid, Set<Isometric> isometrics) {
        this.id = id;
        this.pid = pid;
        this.isometrics = isometrics;
    }

    public PressureTestPackagePidAndIsometrics(PressureTestPackPidAndIsomtricsEntity pressureTestPackPidAndIsomtricsEntity) {
        this.id = pressureTestPackPidAndIsomtricsEntity.getId();
        this.pid = new Pid(pressureTestPackPidAndIsomtricsEntity.getPid());
        this.isometrics = initializeIsometrics(pressureTestPackPidAndIsomtricsEntity.getIsometrics());
    }

    private Set<Isometric> initializeIsometrics(Set<IsometricEntity> isometricEntities) {
        Set<Isometric> isometrics = new HashSet<>();
        for (IsometricEntity isometricEntity : isometricEntities) {
            Isometric isometric = new Isometric(isometricEntity);
            isometrics.add(isometric);
        }
        return isometrics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pid getPid() {
        return pid;
    }

    public void setPid(Pid pid) {
        this.pid = pid;
    }

    public Set<Isometric> getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(Set<Isometric> isometrics) {
        this.isometrics = isometrics;
    }

    @Override
    public String toString() {
        return "PressureTestPackagePidAndIsometrics{" +
                "id=" + id +
                ", pid=" + pid +
                ", isometrics=" + isometrics +
                '}';
    }
}
