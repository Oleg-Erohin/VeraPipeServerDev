package com.verapipe.dto;

import com.verapipe.entities.NdtReportEntity;

import java.util.Arrays;
import java.util.Date;

public class NdtReport {
    private int id;
    private String name;
    private String NdtTypeName;
    private byte[] file;
    private Date date;

    public NdtReport() {
    }

    public NdtReport(String name, String NdtTypeName, byte[] file, Date date) {
        this.name = name;
        this.NdtTypeName = NdtTypeName;
        this.file = file;
        this.date = date;
    }

    public NdtReport(int id, String name, String NdtTypeName, byte[] file, Date date) {
        this.id = id;
        this.name = name;
        this.NdtTypeName = NdtTypeName;
        this.file = file;
        this.date = date;
    }

    public NdtReport(NdtReportEntity ndtReportEntity) {
        this.id = ndtReportEntity.getId();
        this.name = ndtReportEntity.getName();
        this.NdtTypeName = ndtReportEntity.getNdtType().getName();
        this.file = ndtReportEntity.getFile();
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

    public String getNdtTypeName() {
        return NdtTypeName;
    }

    public void setNdtTypeName(String NdtTypeName) {
        this.NdtTypeName = NdtTypeName;
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

    @Override
    public String toString() {
        return "NdtReport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", NdtTypeName='" + NdtTypeName + '\'' +
                ", file=" + Arrays.toString(file) +
                ", date=" + date +
                '}';
    }
}
