package com.verapipe.dto;

import com.verapipe.entities.FillerMaterialCertificateEntity;

public class FillerMaterialCertificate {
    private int id;
    private String heatNum;
    private String materialTypeName;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String heatNum, String materialTypeName) {
        this.heatNum = heatNum;
        this.materialTypeName = materialTypeName;
    }

    public FillerMaterialCertificate(int id, String heatNum, byte[] file, String materialTypeName) {
        this.id = id;
        this.heatNum = heatNum;
        this.materialTypeName = materialTypeName;
    }

    public FillerMaterialCertificate(FillerMaterialCertificateEntity fillerMaterialCertificateEntity) {
        this.id = fillerMaterialCertificateEntity.getId();
        this.heatNum = fillerMaterialCertificateEntity.getHeatNum();
        this.materialTypeName = fillerMaterialCertificateEntity.getFillerMaterialType().getName();
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
                ", materialTypeName='" + materialTypeName + '\'' +
                '}';
    }
}
