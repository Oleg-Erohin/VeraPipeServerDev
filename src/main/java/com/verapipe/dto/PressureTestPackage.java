package com.verapipe.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PressureTestPackage {
    private int id;
    private String name;
    private List<String> pidNames;
    private List<String> isometricNames;
    private List<Coordinates> coordinatesInPidsList;
    private byte[] testReport;
    private Date date;

    public PressureTestPackage() {
    }

    public PressureTestPackage(String name, List<String> pidNames, List<String> isometricNames, List<Coordinates> coordinatesInPidsList, byte[] testReport, Date date) {
        this.name = name;
        this.pidNames = pidNames;
        this.isometricNames = isometricNames;
        this.coordinatesInPidsList = coordinatesInPidsList;
        this.testReport = testReport;
        this.date = date;
    }

    public PressureTestPackage(int id, String name, List<String> pidNames, List<String> isometricNames, List<Coordinates> coordinatesInPidsList, byte[] testReport, Date date) {
        this.id = id;
        this.name = name;
        this.pidNames = pidNames;
        this.isometricNames = isometricNames;
        this.coordinatesInPidsList = coordinatesInPidsList;
        this.testReport = testReport;
        this.date = date;
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

    public List<String> getIsometricNames() {
        return isometricNames;
    }

    public void setIsometricNames(List<String> isometricNames) {
        this.isometricNames = isometricNames;
    }

    public List<Coordinates> getCoordinatesInPidsList() {
        return coordinatesInPidsList;
    }

    public void setCoordinatesInPidsList(List<Coordinates> coordinatesInPidsList) {
        this.coordinatesInPidsList = coordinatesInPidsList;
    }

    public byte[] getTestReport() {
        return testReport;
    }

    public void setTestReport(byte[] testReport) {
        this.testReport = testReport;
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
                ", pidNames=" + pidNames +
                ", isometricNames=" + isometricNames +
                ", coordinatesInPidsList=" + coordinatesInPidsList +
                ", testReport=" + Arrays.toString(testReport) +
                ", date=" + date +
                '}';
    }
}
