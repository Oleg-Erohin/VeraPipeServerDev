package com.verapipe.entities;

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

    @Column(name = "revision", nullable = false)
    private String revision;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "sheets", nullable = false)
    private int sheets;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "coordinates", joinColumns = @JoinColumn(name = "isometric_id"))
    @Column(name = "coordinates", unique = true)
    private List<Coordinates> coordinatesInPid;

    @Column(name = "is_approved", nullable = false)
    private boolean isApproved;

    @Column(name = "comments", columnDefinition="TEXT")
    private String comments;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<IsometricPidSheetEntity> pidSheets;

    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    @ManyToMany(mappedBy = "isometrics", fetch = FetchType.LAZY)
    private Set<PressureTestPackageEntity> testPacksList;

    public IsometricEntity() {}

    public IsometricEntity(Isometric isometric) {
        this.id = isometric.getId();
        this.name = isometric.getName();
        this.revision = isometric.getRevision();
        this.date = isometric.getDate();
        this.sheets = isometric.getSheets();
        this.coordinatesInPid = isometric.getCoordinatesInPid();
        this.isApproved = isometric.isApproved();
        this.comments = isometric.getComments();

        // Convert pidsAndSheets map to IsometricPidSheetEntity objects and add to pidSheets
        if (isometric.getPidsAndSheets() != null) {
            this.pidSheets = new HashSet<>();
            for (Map.Entry<Pid, List<Integer>> entry : isometric.getPidsAndSheets().entrySet()) {
                Pid pid = entry.getKey();
                List<Integer> sheets = entry.getValue();
                if (pid != null && sheets != null) {
                    this.pidSheets.add(new IsometricPidSheetEntity(this, new PidEntity(pid), sheets));
                }
            }
        }
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

    public Set<IsometricPidSheetEntity> getPidSheets() {
        return pidSheets;
    }

    public void setPidSheets(Set<IsometricPidSheetEntity> pidSheets) {
        this.pidSheets = pidSheets;
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