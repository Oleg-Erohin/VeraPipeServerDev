package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.entities.PressureTestPackPidAndIsomtricsEntity;
import com.verapipe.entities.PressureTestPackageEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PressureTestPackage {
    private int id;
    private String name;
    private Set<PressureTestPackagePidAndIsometrics> pidsAndIsometrics;
    private Date date;

    public PressureTestPackage() {
    }

    public PressureTestPackage(String name, Set<PressureTestPackagePidAndIsometrics> pidsAndIsometrics, Date date) {
        this.name = name;
        this.pidsAndIsometrics = pidsAndIsometrics;
        this.date = date;
    }

    public PressureTestPackage(int id, String name, Set<PressureTestPackagePidAndIsometrics> pidsAndIsometrics, Date date) {
        this.id = id;
        this.name = name;
        this.pidsAndIsometrics = pidsAndIsometrics;
        this.date = date;
    }

    public PressureTestPackage(PressureTestPackageEntity pressureTestPackageEntity) throws JsonProcessingException {
        this.id = pressureTestPackageEntity.getId();
        this.name = pressureTestPackageEntity.getName();
        this.pidsAndIsometrics = initializePidsAndIsometrics(pressureTestPackageEntity.getPidsAndIsometrics());
        this.date = pressureTestPackageEntity.getDate();
    }

    private Set<PressureTestPackagePidAndIsometrics> initializePidsAndIsometrics(Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsosEntities) {
        Set<PressureTestPackagePidAndIsometrics> pidsAndIsos = new HashSet<>();
        for (PressureTestPackPidAndIsomtricsEntity pidAndIsometricsEntity: pidsAndIsosEntities){
            PressureTestPackagePidAndIsometrics pidAndIsos = new PressureTestPackagePidAndIsometrics(pidAndIsometricsEntity);
            pidsAndIsos.add(pidAndIsos);
        }
        return pidsAndIsos;
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

    public Set<PressureTestPackagePidAndIsometrics> getPidsAndIsometrics() {
        return pidsAndIsometrics;
    }

    public void setPidsAndIsometrics(Set<PressureTestPackagePidAndIsometrics> pidsAndIsometrics) {
        this.pidsAndIsometrics = pidsAndIsometrics;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PressureTestPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pidsAndIsometrics=" + pidsAndIsometrics +
                ", date=" + date +
                '}';
    }
}
