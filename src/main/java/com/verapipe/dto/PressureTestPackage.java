package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.PressureTestPackPidAndIsomtricsEntity;
import com.verapipe.entities.PressureTestPackageEntity;

import java.util.*;

public class PressureTestPackage {
    private int id;
    private String name;
    private Map<Pid, List<Isometric>> pidsAndIsometrics;
    private Date date;

    public PressureTestPackage() {
    }

    public PressureTestPackage(String name, Map<Pid, List<Isometric>> pidsAndIsometrics, Date date) {
        this.name = name;
        this.pidsAndIsometrics = pidsAndIsometrics;
        this.date = date;
    }

    public PressureTestPackage(int id, String name, Map<Pid, List<Isometric>> pidsAndIsometrics, Date date) {
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

    private Map<Pid, List<Isometric>> initializePidsAndIsometrics(Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsometrics) {
        Map<Pid, List<Isometric>> tempPidsAndIsos = new HashMap<>();
        for (PressureTestPackPidAndIsomtricsEntity pidAndIsometrics: pidsAndIsometrics){
            Pid pid = new Pid(pidAndIsometrics.getPid());
            List<Isometric> isometrics = new ArrayList<>();
            for (IsometricEntity isometricEntity : pidAndIsometrics.getIsometrics()){
                Isometric isometric = new Isometric(isometricEntity);
                isometrics.add(isometric);
            }
            tempPidsAndIsos.put(pid, isometrics);
        }
        return tempPidsAndIsos;
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

    public Map<Pid, List<Isometric>> getPidsAndIsometrics() {
        return pidsAndIsometrics;
    }

    public void setPidsAndIsometrics(Map<Pid, List<Isometric>> pidsAndIsometrics) {
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
