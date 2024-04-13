package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.PidEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Isometric {
    private int id;
    private String name;
    private String[] PidNames;
    private List<Integer> PidSheets;
    private byte[] file;
    private String revision;
    private Date date;
    private int sheets;
    private List<Coordinates> coordinatesInPid;
    private boolean isApproved;
    private String comments;

    public Isometric() {
    }

    public Isometric(String name, String[] PidNames, List<Integer> pidSheets, byte[] file, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.name = name;
        this.PidNames = PidNames;
        this.PidSheets = pidSheets;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(int id, String name, String[] PidNames, List<Integer> pidSheets, byte[] file, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.id = id;
        this.name = name;
        this.PidNames = PidNames;
        this.PidSheets = pidSheets;
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

        Set<PidEntity> pidsList = isometricEntity.getPidsList();
        this.PidNames = pidsList.stream()
                .map(PidEntity::getName)
                .toArray(String[]::new);

        List<Integer> pidSheets = pidsList.stream()
                .map(PidEntity::getSheets)
                .collect(Collectors.toList());
        this.PidSheets = pidSheets;

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

    public String[] getPidName() {
        return PidNames;
    }

    public void setPidName(String[] pidName) {
        PidNames = pidName;
    }

    public List<Integer> getPidSheets() {
        return PidSheets;
    }

    public void setPidSheets(List<Integer> pidSheets) {
        PidSheets = pidSheets;
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
                ", PidNames='" + PidNames + '\'' +
                ", PidSheets=" + PidSheets +
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
