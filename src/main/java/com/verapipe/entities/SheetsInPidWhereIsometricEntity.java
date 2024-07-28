package com.verapipe.entities;

import javax.persistence.*;

@Entity
@Table(name = "sheets_in_pid_where_isometric")
public class SheetsInPidWhereIsometricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sheet", nullable = false)
    private Integer sheet;

    @ManyToOne(fetch = FetchType.LAZY)
    private IsometricPidsAndSheetsEntity isometricPidsAndSheets;

    public SheetsInPidWhereIsometricEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSheet() {
        return sheet;
    }

    public void setSheet(Integer sheet) {
        this.sheet = sheet;
    }

    public IsometricPidsAndSheetsEntity getIsometricPidsAndSheets() {
        return isometricPidsAndSheets;
    }

    public void setIsometricPidsAndSheets(IsometricPidsAndSheetsEntity isometricPidsAndSheets) {
        this.isometricPidsAndSheets = isometricPidsAndSheets;
    }
}
