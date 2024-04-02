package com.verapipe.entities;

import com.verapipe.dto.NdtReport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ndt_report")
public class NdtReportEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "file", unique = true, nullable = true)
    private byte[] file;
    @Column(name = "date", unique = false, nullable = false)
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    private NdtTypeEntity ndtType;
    @OneToMany(mappedBy = "ndt_report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    public NdtReportEntity() {
    }

    public NdtReportEntity(NdtReport ndtReport) {
        this.id = ndtReport.getId();
        this.name = ndtReport.getName();
        this.file = ndtReport.getFile();
        this.date = ndtReport.getDate();
        this.ndtType = new NdtTypeEntity();
        String ndtTypeName = ndtReport.getNdtType();
        this.ndtType.setName(ndtTypeName);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NdtTypeEntity getNdtType() {
        return ndtType;
    }

    public void setNdtType(NdtTypeEntity ndtType) {
        this.ndtType = ndtType;
    }

    public List<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }
}
