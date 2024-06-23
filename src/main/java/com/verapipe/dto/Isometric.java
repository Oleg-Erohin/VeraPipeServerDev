package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.entities.IsometricEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Isometric {
    private int id;
    private String name;//
    private Map<String, List<Integer>> pidsAndSheets;//
    private String revision;//
    private Date date;//
    private int sheets;//
    private List<Coordinates> coordinatesInPid;//
    private boolean isApproved;//
    private String comments;

    public Isometric() {
    }

    public Isometric(String name, Map<String, List<Integer>> pidsAndSheets, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.name = name;
        this.pidsAndSheets = pidsAndSheets;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(int id, String name, Map<String, List<Integer>> pidsAndSheets, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.id = id;
        this.name = name;
        this.pidsAndSheets = pidsAndSheets;
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

        this.pidsAndSheets = isometricEntity.getPidSheets();

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

    public Map<String, List<Integer>> getPidsAndSheets() {
        return pidsAndSheets;
    }

    public void setPidsAndSheets(Map<String, List<Integer>> pidSheets) {
        this.pidsAndSheets = pidSheets;
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
//                ", pidNames='" + pidNames + '\'' +
                ", pidsAndSheets=" + pidsAndSheets +
                ", revision='" + revision + '\'' +
                ", date=" + date +
                ", sheets=" + sheets +
                ", coordinatesInPid=" + coordinatesInPid +
                ", isApproved=" + isApproved +
                ", comments='" + comments + '\'' +
                '}';
    }
}
