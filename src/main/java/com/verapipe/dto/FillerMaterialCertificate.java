package com.verapipe.dto;

import com.verapipe.entities.FillerMaterialCertificateEntity;

public class FillerMaterialCertificate {
    private int id;
    private String name;
    private String heatNum;
    private FillerMaterialType materialType;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String name, String heatNum, FillerMaterialType materialType) {
        this.name = name;
        this.heatNum = heatNum;
        this.materialType = materialType;
    }

    public FillerMaterialCertificate(int id, String name, String heatNum, byte[] file, FillerMaterialType materialType) {
        this.id = id;
        this.name = name;
        this.heatNum = heatNum;
        this.materialType = materialType;
    }

    public FillerMaterialCertificate(FillerMaterialCertificateEntity fillerMaterialCertificateEntity) {
        this.id = fillerMaterialCertificateEntity.getId();
        this.name = fillerMaterialCertificateEntity.getName();
        this.heatNum = fillerMaterialCertificateEntity.getHeatNum();
        this.materialType = new FillerMaterialType(fillerMaterialCertificateEntity.getFillerMaterialType());
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
                ", name='" + name + '\'' +
                ", heatNum='" + heatNum + '\'' +
                ", materialType=" + materialType +
                '}';
    }
}
