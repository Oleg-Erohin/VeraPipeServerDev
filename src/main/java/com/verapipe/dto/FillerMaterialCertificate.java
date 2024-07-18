package com.verapipe.dto;

import com.verapipe.entities.FillerMaterialCertificateEntity;

public class FillerMaterialCertificate {
    private int id;
    private String heatNum;
    private FillerMaterialType materialType;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String heatNum, FillerMaterialType materialType) {
        this.heatNum = heatNum;
        this.materialType = materialType;
    }

    public FillerMaterialCertificate(int id, String heatNum, byte[] file, FillerMaterialType materialType) {
        this.id = id;
        this.heatNum = heatNum;
        this.materialType = materialType;
    }

    public FillerMaterialCertificate(FillerMaterialCertificateEntity fillerMaterialCertificateEntity) {
        this.id = fillerMaterialCertificateEntity.getId();
        this.heatNum = fillerMaterialCertificateEntity.getHeatNum();
        this.materialType = new FillerMaterialType(fillerMaterialCertificateEntity.getFillerMaterialType());
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

    public FillerMaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(FillerMaterialType materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "FillerMaterialCertificate{" +
                "id=" + id +
                ", heatNum='" + heatNum + '\'' +
                ", materialType=" + materialType +
                '}';
    }
}
