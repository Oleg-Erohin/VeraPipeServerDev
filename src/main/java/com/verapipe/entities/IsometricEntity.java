package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.IsometricLocationInPid;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Column(name = "is_approved", unique = false, nullable = false)
    private boolean isApproved;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
    private List<IsometricLocationInPidEntity> isometricLocationsInPids;

    @Column(name = "comments", unique = false, nullable = true, columnDefinition = "TEXT")
    private String comments;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    @ManyToMany(mappedBy = "isometrics", fetch = FetchType.LAZY)
    private Set<PressureTestPackPidAndIsomtricsEntity> pressureTestPackPidsAndIsomtrics;

    public IsometricEntity() {
    }

    public IsometricEntity(Isometric isometric) throws JsonProcessingException {
        this.id = isometric.getId();
        this.name = isometric.getName();
        this.revision = isometric.getRevision();
        this.date = isometric.getDate();
        this.sheets = isometric.getSheets();
        this.isApproved = isometric.isApproved();
        this.isometricLocationsInPids = initializeIsometricLocationInPids(isometric.getIsometricLocationsInPids());
        this.comments = isometric.getComments();
    }

    private List<IsometricLocationInPidEntity> initializeIsometricLocationInPids(List<IsometricLocationInPid> isometricLocationInPids) throws JsonProcessingException {
        List<IsometricLocationInPidEntity> tempPidsAndSheetsEntities = new ArrayList<>();
        for (IsometricLocationInPid isometricLocationInPid : isometricLocationInPids) {
            IsometricLocationInPidEntity isometricLocationInPidEntity = new IsometricLocationInPidEntity(isometricLocationInPid);
            tempPidsAndSheetsEntities.add(isometricLocationInPidEntity);
        }
        return tempPidsAndSheetsEntities;
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

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public List<IsometricLocationInPidEntity> getIsometricLocationsInPids() {
        return isometricLocationsInPids;
    }

    public void setIsometricLocationsInPids(List<IsometricLocationInPidEntity> isometricLocationsInPids) {
        this.isometricLocationsInPids = isometricLocationsInPids;
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

    public Set<PressureTestPackPidAndIsomtricsEntity> getPressureTestPackPidsAndIsomtrics() {
        return pressureTestPackPidsAndIsomtrics;
    }

    public void setPressureTestPackPidsAndIsomtrics(Set<PressureTestPackPidAndIsomtricsEntity> pressureTestPackPidsAndIsomtrics) {
        this.pressureTestPackPidsAndIsomtrics = pressureTestPackPidsAndIsomtrics;
    }
}
