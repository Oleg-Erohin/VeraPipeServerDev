package com.verapipe.entities;

import com.verapipe.dto.Pid;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "p&id")
public class PidEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Lob
    @Column(name = "file", unique = true, nullable = false)
    private byte[] file;

    @Column(name = "revision", nullable = false)
    private String revision;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "sheets", nullable = false)
    private int sheets;

//    @ManyToMany(mappedBy = "p&id", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<IsometricDrawingEntity> isometricDrawingsList;
//
//    @OneToOne(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointEntity> JointsList;
//
//    @ManyToMany(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<PressureTestPackageEntity> pressureTestPackagesList;

    public PidEntity() {
    }

    public PidEntity(Pid pid) {
        this.id = pid.getId();
        this.name = pid.getName();
        this.file = pid.getFile();
        this.revision = pid.getRevision();
        this.date = pid.getDate();
        this.sheets = pid.getSheets();
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
}
