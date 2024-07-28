package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Column(name = "coordinates", unique = true, nullable = true)
    private String coordinatesInPid;

    @Column(name = "is_approved", unique = false, nullable = false)
    private boolean isApproved;

//    @Column(name = "pid_sheets", unique = false, nullable = true)
//    @Convert(converter = MapConverter.class)
//    private Map<String, List<Integer>> pidSheets;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
    private List<IsometricPidsAndSheetsEntity> isometricPidsAndSheets;

    @Column(name = "comments", unique = false, nullable = true, columnDefinition = "TEXT")
    private String comments;

//    @ManyToMany(fetch = FetchType.LAZY)
//    private Set<PidEntity> pidsList;

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
        ObjectMapper objectMapper = new ObjectMapper();
        this.coordinatesInPid = objectMapper.writeValueAsString(isometric.getCoordinatesInPid());
        this.isApproved = isometric.isApproved();
        this.isometricPidsAndSheets = initializePidsAndSheets(isometric.getPidsAndSheets());
//        this.pidsList = new HashSet<>();
//        this.pidSheets = isometric.getPidsAndSheets();
        this.comments = isometric.getComments();
    }

    private List<IsometricPidsAndSheetsEntity> initializePidsAndSheets(Map<Pid, List<Integer>> pidsAndSheets) {
        List<IsometricPidsAndSheetsEntity> pidsAndSheetsEntities = new ArrayList<>();

        for (Map.Entry<Pid, List<Integer>> pidAndSheets : pidsAndSheets.entrySet()) {
            IsometricPidsAndSheetsEntity tempPidAndSheets = new IsometricPidsAndSheetsEntity();

            tempPidAndSheets.setIsometric(this);

            PidEntity tempPid = new PidEntity(pidAndSheets.getKey());
            tempPidAndSheets.setPid(tempPid);

            List<SheetsInPidWhereIsometricEntity> sheetsInPid = new ArrayList<>();
            for (Integer sheetInPidWhereIsometric : pidAndSheets.getValue()){
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

    public String getCoordinatesInPid() {
        return coordinatesInPid;
    }

    public void setCoordinatesInPid(String coordinatesInPid) {
        this.coordinatesInPid = coordinatesInPid;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

//    public Set<PidEntity> getPidsList() {
//        return pidsList;
//    }
//
//    public void setPidsList(Set<PidEntity> pidsList) {
//        this.pidsList = pidsList;
//    }

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

//    public Map<String, List<Integer>> getPidSheets() {
//        return pidSheets;
//    }
//
//    public void setPidSheets(Map<String, List<Integer>> pidSheets) {
//        this.pidSheets = pidSheets;
//    }

    public List<IsometricPidsAndSheetsEntity> getIsometricPidsAndSheets() {
        return isometricPidsAndSheets;
    }

    public void setIsometricPidsAndSheets(List<IsometricPidsAndSheetsEntity> isometricPidsAndSheets) {
        this.isometricPidsAndSheets = isometricPidsAndSheets;
    }
}
