package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "isometric_pids_and_sheets")
public class IsometricPidsAndSheetsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private IsometricEntity isometric;

    @ManyToOne(fetch = FetchType.EAGER)
    private PidEntity pid;

    @OneToMany(mappedBy = "isometricPidsAndSheets")
    private List<SheetsInPidWhereIsometricEntity> sheetsOnPid;

    public IsometricPidsAndSheetsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IsometricEntity getIsometric() {
        return isometric;
    }

    public void setIsometric(IsometricEntity isometric) {
        this.isometric = isometric;
    }

    public PidEntity getPid() {
        return pid;
    }

    public void setPid(PidEntity pid) {
        this.pid = pid;
    }

    public List<SheetsInPidWhereIsometricEntity> getSheetsOnPid() {
        return sheetsOnPid;
    }

    public void setSheetsOnPid(List<SheetsInPidWhereIsometricEntity> sheetsOnPid) {
        this.sheetsOnPid = sheetsOnPid;
    }
}
