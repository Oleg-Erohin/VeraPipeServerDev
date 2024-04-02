package com.verapipe.dto;

import java.util.Arrays;

public class BaseMaterialCertificate {
    private int id;
    private String heatNum;
    private String lotNum;
    private byte[] file;
    private String materialTypeName;

    public BaseMaterialCertificate() {
    }

    public BaseMaterialCertificate(String heatNum, String lotNum, byte[] file, String materialTypeName) {
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.file = file;
        this.materialTypeName = materialTypeName;
    }

    public BaseMaterialCertificate(int id, String heatNum, String lotNum, byte[] file, String materialTypeName) {
        this.id = id;
        this.heatNum = heatNum;
        this.lotNum = lotNum;
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

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
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
        return "BaseMaterialCertificate{" +
                "id=" + id +
                ", heatNum='" + heatNum + '\'' +
                ", lotNum='" + lotNum + '\'' +
                ", file=" + Arrays.toString(file) +
                ", materialTypeName='" + materialTypeName + '\'' +
                '}';
    }
}
