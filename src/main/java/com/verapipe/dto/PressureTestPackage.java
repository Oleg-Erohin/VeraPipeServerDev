package com.verapipe.dto;

import com.verapipe.entities.PressureTestPackageEntity;
import com.verapipe.entities.PressureTestPackagePidCoordinatesEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PressureTestPackage {
    private int id;
    private String name;
    private Map<Pid, List<Coordinates>> pidsAndCoordinates;
    private List<Isometric> isometrics;
    private Date date;

    public PressureTestPackage() {
    }

    public PressureTestPackage(String name, Map<Pid, List<Coordinates>> pidsAndCoordinates, List<Isometric> isometrics, Date date) {
        this.name = name;
        this.pidsAndCoordinates = pidsAndCoordinates;
        this.isometrics = isometrics;
        this.date = date;
    }

    public PressureTestPackage(int id, String name, Map<Pid, List<Coordinates>> pidsAndCoordinates, List<Isometric> isometrics, Date date) {
        this.id = id;
        this.name = name;
        this.pidsAndCoordinates = pidsAndCoordinates;
        this.isometrics = isometrics;
        this.date = date;
    }

    public PressureTestPackage(PressureTestPackageEntity pressureTestPackageEntity) {
        this.id = pressureTestPackageEntity.getId();
        this.name = pressureTestPackageEntity.getName();
        this.date = pressureTestPackageEntity.getDate();

        // Convert pidsAndCoordinates map from entity to DTO format
        if (pressureTestPackageEntity.getPidsAndCoordinates() != null) {
            this.pidsAndCoordinates = new HashMap<>();
            for (PressureTestPackagePidCoordinatesEntity pidsAndCoordinates : pressureTestPackageEntity.getPidsAndCoordinates()) {
                Pid pid = new Pid(pidsAndCoordinates.getPid());
                List<Coordinates> coordinates = pidsAndCoordinates.getCoordinates();
                this.pidsAndCoordinates.put(pid, coordinates);
            }
        }

        // Convert isometrics list from entity to DTO format
        this.isometrics = pressureTestPackageEntity.getIsometrics().stream()
                .map(Isometric::new)
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

    public Map<Pid, List<Coordinates>> getPidsAndCoordinates() {
        return pidsAndCoordinates;
    }

    public void setPidsAndCoordinates(Map<Pid, List<Coordinates>> pidsAndCoordinates) {
        this.pidsAndCoordinates = pidsAndCoordinates;
    }

    public List<Isometric> getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(List<Isometric> isometrics) {
        this.isometrics = isometrics;
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
                ", pidsAndCoordinates=" + pidsAndCoordinates +
                ", isometrics=" + isometrics +
                ", date=" + date +
                '}';
    }
}
