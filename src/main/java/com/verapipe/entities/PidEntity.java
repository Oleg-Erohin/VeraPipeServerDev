package com.verapipe.entities;

import com.verapipe.dto.Pid;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pid")
public class PidEntity {
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
    @Column(name = "comments", unique = false, nullable = true, columnDefinition="TEXT")
    private String comments;
    @ManyToMany(mappedBy = "pidsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<IsometricEntity> isometricDrawingsList;
    @OneToMany(mappedBy = "pid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;
    @ManyToMany(mappedBy = "pidsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PressureTestPackageEntity> pressureTestPackagesList;

    public PidEntity() {
    }

    public PidEntity(Pid pid) {
        this.id = pid.getId();
        this.name = pid.getName();
        this.revision = pid.getRevision();
        this.date = pid.getDate();
        this.sheets = pid.getSheets();
        this.isometricDrawingsList = new HashSet<>();
        this.pressureTestPackagesList = new HashSet<>();
        this.comments = pid.getComments();
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

    public Set<IsometricEntity> getIsometricDrawingsList() {
        return isometricDrawingsList;
    }

    public void setIsometricDrawingsList(Set<IsometricEntity> isometricDrawingsList) {
        this.isometricDrawingsList = isometricDrawingsList;
    }

    public List<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        JointsList = jointsList;
    }

    public Set<PressureTestPackageEntity> getPressureTestPackagesList() {
        return pressureTestPackagesList;
    }

    public void setPressureTestPackagesList(Set<PressureTestPackageEntity> pressureTestPackagesList) {
        this.pressureTestPackagesList = pressureTestPackagesList;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
