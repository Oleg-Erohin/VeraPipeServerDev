package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialCertificateEntity;

public class BaseMaterialCertificate {
    private int id;
    private String heatNum;
    private String lotNum;
    private BaseMaterialType baseMaterialType;

    public BaseMaterialCertificate() {
    }

    public BaseMaterialCertificate(String heatNum, String lotNum, BaseMaterialType baseMaterialType) {
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.baseMaterialType = baseMaterialType;
    }

    public BaseMaterialCertificate(int id, String heatNum, String lotNum, BaseMaterialType baseMaterialType) {
        this.id = id;
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.baseMaterialType = baseMaterialType;
    }

    public BaseMaterialCertificate(BaseMaterialCertificateEntity baseMaterialCertificateEntity) {
        this.id = baseMaterialCertificateEntity.getId();
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
                ", heatNum='" + heatNum + '\'' +
                ", lotNum='" + lotNum + '\'' +
                ", baseMaterialType=" + baseMaterialType +
                '}';
    }
}
