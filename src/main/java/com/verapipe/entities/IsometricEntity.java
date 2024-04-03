package com.verapipe.entities;

import com.verapipe.dto.Isometric;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "isometric")
public class IsometricEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Lob
    @Column(name = "file", unique = true, nullable = false)
    private byte[] file;
    @Column(name = "revision", unique = false, nullable = false)
    private String revision;
    @Column(name = "date", unique = false, nullable = false)
    private Date date;
    @Column(name = "sheets", unique = false, nullable = false)
    private int sheets;
    @Column(name = "coordinates", unique = true, nullable = true)
    private String coordinatesInPid;
    @Column(name = "is_approved", unique = false,  nullable = false)
    private boolean isApproved;
    @ManyToMany(mappedBy = "isometricDrawingsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PidEntity> pidsList;
    @OneToMany(mappedBy = "isometric", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;
    @ManyToMany(mappedBy = "isometricsList", fetch = FetchType.LAZY)
    private List<PressureTestPackageEntity> testPacksList;

    public IsometricEntity() {
    }

    public IsometricEntity(Isometric isometric) {
        this.id = isometric.getId();
        this.name = isometric.getName();
        this.file = isometric.getFile();
        this.revision = isometric.getRevision();
        this.date = isometric.getDate();
        this.sheets = isometric.getSheets();
        this.coordinatesInPid = isometric.getCoordinatesInPid().toString();
        this.isApproved = isometric.isApproved();
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

    public List<PidEntity> getPidsList() {
        return pidsList;
    }

    public void setPidsList(List<PidEntity> pidsList) {
        this.pidsList = pidsList;
    }

    public List<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }

    public List<PressureTestPackageEntity> getTestPacksList() {
        return testPacksList;
    }

    public void setTestPacksList(List<PressureTestPackageEntity> testPacksList) {
        this.testPacksList = testPacksList;
    }
}
