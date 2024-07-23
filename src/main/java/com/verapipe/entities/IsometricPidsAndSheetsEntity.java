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
    @JoinColumn(name = "isometric_id")
    private IsometricEntity isometric;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid_id")
    private PidEntity pid;

    @ElementCollection
    @CollectionTable(name = "isometric_sheets_on_pid", joinColumns = @JoinColumn(name = "isometric_pids_and_sheets_id"))
    @Column(name = "sheets_on_pid")
    private List<Integer> sheetsOnPid;

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

    public List<Integer> getSheetsOnPid() {
        return sheetsOnPid;
    }

    public void setSheetsOnPid(List<Integer> sheetsOnPid) {
        this.sheetsOnPid = sheetsOnPid;
    }
}
