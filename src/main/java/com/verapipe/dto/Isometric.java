package com.verapipe.dto;

import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.IsometricLocationInPidEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Isometric {
    private int id;
    private String name;
    private String revision;
    private Date date;
    private int sheets;
    private List<IsometricLocationInPid> isometricLocationInPids;
    private boolean isApproved;
    private String comments;

    public Isometric() {
    }

    public Isometric(String name, String revision, Date date, int sheets, List<IsometricLocationInPid> isometricLocationInPids, boolean isApproved, String comments) {
        this.name = name;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.isometricLocationInPids = isometricLocationInPids;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(int id, String name, String revision, Date date, int sheets, List<IsometricLocationInPid> isometricLocationInPids, boolean isApproved, String comments) {
        this.id = id;
        this.name = name;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.isometricLocationInPids = isometricLocationInPids;
        this.isApproved = isApproved;
        this.comments = comments;
    }

    public Isometric(IsometricEntity isometricEntity) {
        this.id = isometricEntity.getId();
        this.name = isometricEntity.getName();
        this.revision = isometricEntity.getRevision();
        this.date = isometricEntity.getDate();
        this.sheets = isometricEntity.getSheets();
        this.isometricLocationInPids = initializeIsometricLocationInPids(isometricEntity.getIsometricLocationsInPids());
        this.isApproved = isometricEntity.isApproved();
        this.comments = isometricEntity.getComments();
    }

    private List<IsometricLocationInPid> initializeIsometricLocationInPids(List<IsometricLocationInPidEntity> isometricLocationsInPidsEntities) {
        List<IsometricLocationInPid> tempIsometricLocationInPid = new ArrayList<>();
        for (IsometricLocationInPidEntity isometricLocationInPidEntity : isometricLocationsInPidsEntities) {
            IsometricLocationInPid isometricLocationInPid = new IsometricLocationInPid(isometricLocationInPidEntity);
            tempIsometricLocationInPid.add(isometricLocationInPid);
        }
        return tempIsometricLocationInPid;
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

    public List<IsometricLocationInPid> getIsometricLocationInPids() {
        return isometricLocationInPids;
    }

    public void setIsometricLocationInPids(List<IsometricLocationInPid> isometricLocationInPids) {
        this.isometricLocationInPids = isometricLocationInPids;
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
                ", revision='" + revision + '\'' +
                ", date=" + date +
                ", sheets=" + sheets +
                ", isometricLocationInPids=" + isometricLocationInPids +
                ", isApproved=" + isApproved +
                ", comments='" + comments + '\'' +
                '}';
    }
}
