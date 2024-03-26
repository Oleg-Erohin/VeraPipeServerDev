package com.verapipe.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Isometric {
    private int id;
    private String name;
    private String PidName;
    private List<Integer> PidSheets;
    private byte[] file;
    private String revision;
    private Date date;
    private int sheets;
    private List<Coordinates> coordinatesInPid;
    private boolean isApproved;

    public Isometric() {
    }

    public Isometric(String name, String pidName, List<Integer> pidSheets, byte[] file, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved) {
        this.name = name;
        PidName = pidName;
        PidSheets = pidSheets;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
    }

    public Isometric(int id, String name, String pidName, List<Integer> pidSheets, byte[] file, String revision, Date date, int sheets, List<Coordinates> coordinatesInPid, boolean isApproved) {
        this.id = id;
        this.name = name;
        PidName = pidName;
        PidSheets = pidSheets;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.coordinatesInPid = coordinatesInPid;
        this.isApproved = isApproved;
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

    public String getPidName() {
        return PidName;
    }

    public void setPidName(String pidName) {
        PidName = pidName;
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

    @Override
    public String toString() {
        return "Isometric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PidName='" + PidName + '\'' +
                ", PidSheets=" + PidSheets +
                ", file=" + Arrays.toString(file) +
                ", revision='" + revision + '\'' +
                ", date=" + date +
                ", sheets=" + sheets +
                ", coordinatesInPid=" + coordinatesInPid +
                ", isApproved=" + isApproved +
                '}';
    }
}
