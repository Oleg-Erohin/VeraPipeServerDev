package com.verapipe.dto;

import com.verapipe.entities.NdtReportEntity;

import java.util.Date;

public class NdtReport {
    private int id;
    private String name;
    private NdtType NdtType;
    private Date date;

    public NdtReport() {
    }

    public NdtReport(String name, NdtType NdtType, Date date) {
        this.name = name;
        this.NdtType = NdtType;
        this.date = date;
    }

    public NdtReport(int id, String name, NdtType NdtType, Date date) {
        this.id = id;
        this.name = name;
        this.NdtType = NdtType;
        this.date = date;
    }

    public NdtReport(NdtReportEntity ndtReportEntity) {
        this.id = ndtReportEntity.getId();
        this.name = ndtReportEntity.getName();
        this.NdtType = new NdtType(ndtReportEntity.getNdtType());
        this.date = ndtReportEntity.getDate();
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
        return NdtType;
    }

    public void setNdtType(com.verapipe.dto.NdtType ndtType) {
        NdtType = ndtType;
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
                ", NdtType=" + NdtType +
                ", date=" + date +
                '}';
    }
}
