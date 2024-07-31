package com.verapipe.dto;

import com.verapipe.entities.FillerMaterialCertificateEntity;

public class FillerMaterialCertificate {
    private int id;
    private String name;
    private String heatNum;
    private FillerMaterialType fillerMaterialType;

    public FillerMaterialCertificate() {
    }

    public FillerMaterialCertificate(String name, String heatNum, FillerMaterialType fillerMaterialType) {
        this.name = name;
        this.heatNum = heatNum;
        this.fillerMaterialType = fillerMaterialType;
    }

    public FillerMaterialCertificate(int id, String name, String heatNum, byte[] file, FillerMaterialType fillerMaterialType) {
        this.id = id;
        this.name = name;
        this.heatNum = heatNum;
        this.fillerMaterialType = fillerMaterialType;
    }

    public FillerMaterialCertificate(FillerMaterialCertificateEntity fillerMaterialCertificateEntity) {
        this.id = fillerMaterialCertificateEntity.getId();
        this.name = fillerMaterialCertificateEntity.getName();
        this.heatNum = fillerMaterialCertificateEntity.getHeatNum();
        this.fillerMaterialType = new FillerMaterialType(fillerMaterialCertificateEntity.getFillerMaterialType());
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
                ", name='" + name + '\'' +
                ", heatNum='" + heatNum + '\'' +
                ", fillerMaterialType=" + fillerMaterialType +
                '}';
    }
}
