package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.PidEntity;
import com.verapipe.entities.PressureTestPackageEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PressureTestPackage {
    private int id;
    private String name;
    private List<Pid> pids;
    private List<Isometric> isometrics;
    private List<Coordinates> coordinatesInPidsList;
    private Date date;

    public PressureTestPackage() {
    }

    public PressureTestPackage(String name, List<Pid> pids, List<Isometric> isometrics, List<Coordinates> coordinatesInPidsList, Date date) {
        this.name = name;
        this.pids = pids;
        this.isometrics = isometrics;
        this.coordinatesInPidsList = coordinatesInPidsList;
        this.date = date;
    }

    public PressureTestPackage(int id, String name, List<Pid> pids, List<Isometric> isometrics, List<Coordinates> coordinatesInPidsList, Date date) {
        this.id = id;
        this.name = name;
        this.pids = pids;
        this.isometrics = isometrics;
        this.coordinatesInPidsList = coordinatesInPidsList;
        this.date = date;
    }

    public PressureTestPackage(PressureTestPackageEntity pressureTestPackageEntity) throws JsonProcessingException {
        this.id = pressureTestPackageEntity.getId();
        this.name = pressureTestPackageEntity.getName();

        List<PidEntity> pidEntityList = new ArrayList<>();
        pidEntityList.addAll(pressureTestPackageEntity.getPidsList());
        for(PidEntity pidEntity : pidEntityList){
            Pid pid = new Pid(pidEntity);
            this.pids.add(pid);
        }

        List<IsometricEntity> isometricEntityList = new ArrayList<>();
        isometricEntityList.addAll(pressureTestPackageEntity.getIsometricsList());
        for(IsometricEntity isometricEntity : isometricEntityList){
            Isometric isometric = new Isometric(isometricEntity);
            this.isometrics.add(isometric);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        this.coordinatesInPidsList = objectMapper.readValue(pressureTestPackageEntity.getCoordinatesInPids(), new TypeReference<List<Coordinates>>(){});

        this.date = pressureTestPackageEntity.getDate();
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

    public List<Pid> getPids() {
        return pids;
    }

    public void setPids(List<Pid> pids) {
        this.pids = pids;
    }

    public List<Isometric> getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(List<Isometric> isometrics) {
        this.isometrics = isometrics;
    }

    public List<Coordinates> getCoordinatesInPidsList() {
        return coordinatesInPidsList;
    }

    public void setCoordinatesInPidsList(List<Coordinates> coordinatesInPidsList) {
        this.coordinatesInPidsList = coordinatesInPidsList;
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
                ", pids=" + pids +
                ", isometrics=" + isometrics +
                ", coordinatesInPidsList=" + coordinatesInPidsList +
                ", date=" + date +
                '}';
    }
}
