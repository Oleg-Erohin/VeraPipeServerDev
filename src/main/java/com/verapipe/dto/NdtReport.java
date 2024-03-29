package com.verapipe.dto;

import java.util.Arrays;
import java.util.Date;

public class NdtReport {
    private int id;
    private String name;
    private String NdtType;
    private byte[] file;
    private Date date;

    public NdtReport() {
    }

    public NdtReport(String name, String ndtType, byte[] file, Date date) {
        this.name = name;
        NdtType = ndtType;
        this.file = file;
        this.date = date;
    }

    public NdtReport(int id, String name, String ndtType, byte[] file, Date date) {
        this.id = id;
        this.name = name;
        NdtType = ndtType;
        this.file = file;
        this.date = date;
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

    public String getNdtType() {
        return NdtType;
    }

    public void setNdtType(String ndtType) {
        NdtType = ndtType;
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
                ", NdtType='" + NdtType + '\'' +
                ", file=" + Arrays.toString(file) +
                ", date=" + date +
                '}';
    }
}
