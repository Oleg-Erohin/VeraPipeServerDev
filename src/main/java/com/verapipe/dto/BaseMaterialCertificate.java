package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialCertificateEntity;

public class BaseMaterialCertificate {
    private int id;
    private String name;
    private String heatNum;
    private String lotNum;
    private BaseMaterialType baseMaterialType;

    public BaseMaterialCertificate() {
    }

    public BaseMaterialCertificate(String name, String heatNum, String lotNum, BaseMaterialType baseMaterialType) {
        this.name = name;
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.baseMaterialType = baseMaterialType;
    }

    public BaseMaterialCertificate(int id, String name, String heatNum, String lotNum, BaseMaterialType baseMaterialType) {
        this.id = id;
        this.name = name;
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.baseMaterialType = baseMaterialType;
    }

    public BaseMaterialCertificate(BaseMaterialCertificateEntity baseMaterialCertificateEntity) {
        this.id = baseMaterialCertificateEntity.getId();
        this.name = baseMaterialCertificateEntity.getName();
        this.heatNum = baseMaterialCertificateEntity.getHeatNum();
        this.lotNum = baseMaterialCertificateEntity.getLotNum();
        this.baseMaterialType = new BaseMaterialType(baseMaterialCertificateEntity.getBaseMaterialType());
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

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    public BaseMaterialType getBaseMaterialType() {
        return baseMaterialType;
    }

    public void setBaseMaterialType(BaseMaterialType baseMaterialType) {
        this.baseMaterialType = baseMaterialType;
    }

    @Override
    public String toString() {
        return "BaseMaterialCertificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", heatNum='" + heatNum + '\'' +
                ", lotNum='" + lotNum + '\'' +
                ", baseMaterialType=" + baseMaterialType +
                '}';
    }
}
