package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.PidEntity;

import java.util.*;

public class Isometric {
    private int id;
    private String name;
    private List<String> pidNames;
    private List<Integer> pidSheets;
    private byte[] file;
    private String revision;
    private Date date;
    private int sheets;
    private List<Coordinates> coordinatesInPid;
    private boolean isApproved;
    private String comments;

    public Isometric() {
    }

    public Isometric(String name, List<String> pidNames, List<Integer> pidSheets, byte[] file, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.name = name;
        this.pidNames = pidNames;
        this.pidSheets = pidSheets;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(int id, String name, List<String> pidNames, List<Integer> pidSheets, byte[] file, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.id = id;
        this.name = name;
        this.pidNames = pidNames;
        this.pidSheets = pidSheets;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(IsometricEntity isometricEntity) throws JsonProcessingException {
        this.id = isometricEntity.getId();
        this.name = isometricEntity.getName();

        List<PidEntity> pidEntityList = new ArrayList<>();
        pidEntityList.addAll(isometricEntity.getPidsList());

        List<String> pidsNames = new ArrayList<>();
        for (PidEntity pidEntity : pidEntityList) {
            pidsNames.add(pidEntity.getName());
        }
        this.pidNames = pidsNames;

        List<Integer> pidSheets = new ArrayList<>();
        for (PidEntity pidEntity : pidEntityList) {
            pidSheets.add(pidEntity.getSheets());
        }
        this.pidSheets = pidSheets;

        this.file = isometricEntity.getFile();
        this.revision = isometricEntity.getRevision();
        this.date = isometricEntity.getDate();
        this.sheets = isometricEntity.getSheets();

        ObjectMapper objectMapper = new ObjectMapper();
        this.coordinatesInPid = objectMapper.readValue(isometricEntity.getCoordinatesInPid(), new TypeReference<List<Coordinates>>(){});

        this.isApproved = isometricEntity.isApproved();
        this.comments = isometricEntity.getComments();
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

    public List<String> getPidNames() {
        return pidNames;
    }

    public void setPidNames(List<String> pidNames) {
        this.pidNames = pidNames;
    }

    public List<Integer> getPidSheets() {
        return pidSheets;
    }

    public void setPidSheets(List<Integer> pidSheets) {
        this.pidSheets = pidSheets;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    public List<Coordinates> getCoordinatesInPid() {
        return coordinatesInPid;
    }

    public void setCoordinatesInPid(List<Coordinates> coordinatesInPid) {
        this.coordinatesInPid = coordinatesInPid;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Isometric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pidNames='" + pidNames + '\'' +
                ", PidSheets=" + pidSheets +
                ", file=" + Arrays.toString(file) +
                ", revision='" + revision + '\'' +
                ", date=" + date +
                ", sheets=" + sheets +
                ", coordinatesInPid=" + coordinatesInPid +
                ", isApproved=" + isApproved +
                ", comments='" + comments + '\'' +
                '}';
    }
}
