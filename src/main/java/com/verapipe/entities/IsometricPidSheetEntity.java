package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "isometric_pid_sheet")
public class IsometricPidSheetEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isometric_id", nullable = false)
    private IsometricEntity isometric;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid_id", nullable = false)
    private PidEntity pid;

    @ElementCollection
    @CollectionTable(name = "pid_sheets", joinColumns = @JoinColumn(name = "isometric_pid_sheet_id"))
    @Column(name = "sheet_number")
    private List<Integer> sheets;

    public IsometricPidSheetEntity() {

    }

    public IsometricPidSheetEntity(IsometricEntity isometric, PidEntity pid, List<Integer> sheets) {
        this.isometric = isometric;
        this.pid = pid;
        this.sheets = sheets;
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

    public List<Integer> getSheets() {
        return sheets;
    }

    public void setSheets(List<Integer> sheets) {
        this.sheets = sheets;
    }
}
