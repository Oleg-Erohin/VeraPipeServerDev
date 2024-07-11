package com.verapipe.dto;

import com.verapipe.entities.NdtReportEntity;

import java.util.Date;

public class NdtReport {
    private int id;
    private String name;
    private NdtType ndtType;
    private Date date;

    public NdtReport() {
    }

    public NdtReport(String name, NdtType ndtType, Date date) {
        this.name = name;
        this.ndtType = ndtType;
        this.date = date;
    }

    public NdtReport(int id, String name, NdtType ndtType, Date date) {
        this.id = id;
        this.name = name;
        this.ndtType = ndtType;
        this.date = date;
    }

    public NdtReport(NdtReportEntity ndtReportEntity) {
        this.id = ndtReportEntity.getId();
        this.name = ndtReportEntity.getName();
        this.date = ndtReportEntity.getDate();
        this.ndtType = new NdtType(ndtReportEntity.getNdtType());
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

    public com.verapipe.dto.NdtType getNdtType() {
        return ndtType;
    }

    public void setNdtType(com.verapipe.dto.NdtType ndtType) {
        this.ndtType = ndtType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NdtReport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", NdtType=" + ndtType +
                ", date=" + date +
                '}';
    }
}
