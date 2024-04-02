package com.verapipe.dto;

import java.util.Arrays;

public class FillerMaterialCertificate {
    private int id;
    private String heatNum;
    private byte[] file;
    private String materialTypeName;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String heatNum, byte[] file, String materialTypeName) {
        this.heatNum = heatNum;
        this.file = file;
        this.materialTypeName = materialTypeName;
    }

    public FillerMaterialCertificate(int id, String heatNum, byte[] file, String materialTypeName) {
        this.id = id;
        this.heatNum = heatNum;
        this.file = file;
        this.materialTypeName = materialTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeatNum() {
        return heatNum;
    }

    public void setHeatNum(String heatNum) {
        this.heatNum = heatNum;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    @Override
    public String toString() {
        return "FillerMaterialCertificate{" +
                "id=" + id +
                ", heatNum='" + heatNum + '\'' +
                ", file=" + Arrays.toString(file) +
                ", materialTypeName='" + materialTypeName + '\'' +
                '}';
    }
}
