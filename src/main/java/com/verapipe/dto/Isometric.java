package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.entities.CoordinatesEntity;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.IsometricPidsAndSheetsEntity;
import com.verapipe.entities.SheetsInPidWhereIsometricEntity;

import java.util.*;

public class Isometric {
    private int id;
    private String name;
    private String revision;
    private Date date;
    private int sheets;
    private Map<Pid, List<Integer>> pidsAndSheets;
    private List<Coordinates> coordinatesInPid;
    private boolean isApproved;
    private String comments;

    public Isometric() {
    }

    public Isometric(String name, Map<Pid, List<Integer>> pidsAndSheets, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
        this.name = name;
        this.pidsAndSheets = pidsAndSheets;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(int id, String name, Map<Pid, List<Integer>> pidsAndSheets, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved, String comments) {
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

        this.pidsAndSheets = initializePidsAndSheets(isometricEntity.getIsometricPidsAndSheets());

        this.revision = isometricEntity.getRevision();
        this.date = isometricEntity.getDate();
        this.sheets = isometricEntity.getSheets();

        this.coordinatesInPid = initializeCoordinatesInPid(isometricEntity.getCoordinatesInPid());

        this.isApproved = isometricEntity.isApproved();
        this.comments = isometricEntity.getComments();
    }

    private List<Coordinates> initializeCoordinatesInPid(List<CoordinatesEntity> coordinatesInPid) {
        List<Coordinates> tempCoordinatesList = new ArrayList<>();
        for (CoordinatesEntity coordinatesEntity : coordinatesInPid) {
            Coordinates tempCoordinates = new Coordinates(coordinatesEntity);
            tempCoordinatesList.add(tempCoordinates);
        }
        return tempCoordinatesList;

    }

    private Map<Pid, List<Integer>> initializePidsAndSheets(List<IsometricPidsAndSheetsEntity> isometricPidsAndSheets) {
        Map<Pid, List<Integer>> pidsAndSheets = new HashMap<>();

        for (IsometricPidsAndSheetsEntity pidAndSheets : isometricPidsAndSheets) {
            Pid tempPid = new Pid(pidAndSheets.getPid());
            List<Integer> tempSheetsOnPid = new ArrayList<>();
            for (SheetsInPidWhereIsometricEntity sheetInPidWhereIsometric : pidAndSheets.getSheetsOnPid()) {
                Integer tempSheetInPid = sheetInPidWhereIsometric.getSheet();
                tempSheetsOnPid.add(tempSheetInPid);
            }
            pidsAndSheets.put(tempPid, tempSheetsOnPid);
        }
        return pidsAndSheets;
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

    public Map<Pid, List<Integer>> getPidsAndSheets() {
        return pidsAndSheets;
    }

    public void setPidsAndSheets(Map<Pid, List<Integer>> pidsAndSheets) {
        this.pidsAndSheets = pidsAndSheets;
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
