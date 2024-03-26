package com.verapipe.dto;

import java.util.Arrays;

public class FillerMaterialCertificate {
    private int id;
    private String heatNum;
    private byte[] file;
    private String materialName;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String heatNum, byte[] file, String materialName) {
        this.heatNum = heatNum;
        this.file = file;
        this.materialName = materialName;
    }

    public FillerMaterialCertificate(int id, String heatNum, byte[] file, String materialName) {
        this.id = id;
        this.heatNum = heatNum;
        this.file = file;
        this.materialName = materialName;
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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    @Override
    public String toString() {
        return "FillerMaterialCertificate{" +
                "id=" + id +
                ", heatNum='" + heatNum + '\'' +
                ", file=" + Arrays.toString(file) +
                ", materialName='" + materialName + '\'' +
                '}';
    }
}
