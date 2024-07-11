package com.verapipe.dto;

import com.verapipe.entities.FillerMaterialCertificateEntity;

public class FillerMaterialCertificate {
    private int id;
    private String heatNum;
    private FillerMaterialType fillerMaterialType;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String heatNum, FillerMaterialType fillerMaterialType) {
        this.heatNum = heatNum;
        this.fillerMaterialType = fillerMaterialType;
    }

    public FillerMaterialCertificate(int id, String heatNum, byte[] file, FillerMaterialType fillerMaterialType) {
        this.id = id;
        this.heatNum = heatNum;
        this.fillerMaterialType = fillerMaterialType;
    }

    public FillerMaterialCertificate(FillerMaterialCertificateEntity fillerMaterialCertificateEntity) {
        this.id = fillerMaterialCertificateEntity.getId();
        this.heatNum = fillerMaterialCertificateEntity.getHeatNum();
        this.fillerMaterialType = new FillerMaterialType(fillerMaterialCertificateEntity.getFillerMaterialType());
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

    public FillerMaterialType getFillerMaterialType() {
        return fillerMaterialType;
    }

    public void setFillerMaterialType(FillerMaterialType fillerMaterialType) {
        this.fillerMaterialType = fillerMaterialType;
    }

    @Override
    public String toString() {
        return "FillerMaterialCertificate{" +
                "id=" + id +
                ", heatNum='" + heatNum + '\'' +
                ", fillerMaterialType=" + fillerMaterialType +
                '}';
    }
}
