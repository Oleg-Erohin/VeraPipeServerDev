package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Coordinates;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "isometric")
public class IsometricEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "revision", unique = false, nullable = false)
    private String revision;

    @Column(name = "date", unique = false, nullable = false)
    private Date date;

    @Column(name = "sheets", unique = false, nullable = false)
    private int sheets;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.EAGER)
    private List<CoordinatesEntity> coordinatesInPid;

    @Column(name = "is_approved", unique = false, nullable = false)
    private boolean isApproved;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
    private List<IsometricPidsAndSheetsEntity> isometricPidsAndSheets;

    @Column(name = "comments", unique = false, nullable = true, columnDefinition = "TEXT")
    private String comments;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    @ManyToMany(mappedBy = "isometricsList", fetch = FetchType.LAZY)
    private Set<PressureTestPackageEntity> testPacksList;

    public IsometricEntity() {
    }

    public IsometricEntity(Isometric isometric) throws JsonProcessingException {
        this.id = isometric.getId();
        this.name = isometric.getName();
        this.revision = isometric.getRevision();
        this.date = isometric.getDate();
        this.sheets = isometric.getSheets();
        this.coordinatesInPid = initializeCoordinates(isometric.getCoordinatesInPid());
        this.isApproved = isometric.isApproved();
        this.isometricPidsAndSheets = initializePidsAndSheets(isometric.getPidsAndSheets());
        this.comments = isometric.getComments();
    }

    private List<CoordinatesEntity> initializeCoordinates(List<Coordinates> coordinatesInPid) {
        List<CoordinatesEntity> tempCoordinatesList = new ArrayList<>();
        for (Coordinates currentCoordinates : coordinatesInPid) {
            CoordinatesEntity tempCoordinatesEntity = new CoordinatesEntity(currentCoordinates);
            tempCoordinatesList.add(tempCoordinatesEntity);
        }
        return tempCoordinatesList;
    }

    private List<IsometricPidsAndSheetsEntity> initializePidsAndSheets(Map<Pid, List<Integer>> pidsAndSheets) {
        List<IsometricPidsAndSheetsEntity> pidsAndSheetsEntities = new ArrayList<>();

        for (Map.Entry<Pid, List<Integer>> pidAndSheets : pidsAndSheets.entrySet()) {
            IsometricPidsAndSheetsEntity tempPidAndSheets = new IsometricPidsAndSheetsEntity();

            tempPidAndSheets.setIsometric(this);

            PidEntity tempPid = new PidEntity(pidAndSheets.getKey());
            tempPidAndSheets.setPid(tempPid);

            List<SheetsInPidWhereIsometricEntity> sheetsInPid = new ArrayList<>();
            for (Integer sheetInPidWhereIsometric : pidAndSheets.getValue()) {
                SheetsInPidWhereIsometricEntity tempSheetInPid = new SheetsInPidWhereIsometricEntity();
                tempSheetInPid.setSheet(sheetInPidWhereIsometric);
                sheetsInPid.add(tempSheetInPid);
            }
            tempPidAndSheets.setSheetsOnPid(sheetsInPid);

            pidsAndSheetsEntities.add(tempPidAndSheets);
        }
        return pidsAndSheetsEntities;
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

    public List<CoordinatesEntity> getCoordinatesInPid() {
        return coordinatesInPid;
    }

    public void setCoordinatesInPid(List<CoordinatesEntity> coordinatesInPid) {
        this.coordinatesInPid = coordinatesInPid;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public List<IsometricPidsAndSheetsEntity> getIsometricPidsAndSheets() {
        return isometricPidsAndSheets;
    }

    public void setIsometricPidsAndSheets(List<IsometricPidsAndSheetsEntity> isometricPidsAndSheets) {
        this.isometricPidsAndSheets = isometricPidsAndSheets;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }

    public Set<PressureTestPackageEntity> getTestPacksList() {
        return testPacksList;
    }

    public void setTestPacksList(Set<PressureTestPackageEntity> testPacksList) {
        this.testPacksList = testPacksList;
    }
}
