package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialCertificateEntity;

public class BaseMaterialCertificate {
    private int id;
    private String heatNum;
    private String lotNum;
    private BaseMaterialType materialType;

    public BaseMaterialCertificate() {
    }

    public BaseMaterialCertificate(String heatNum, String lotNum, BaseMaterialType materialType) {
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.materialType = materialType;
    }

    public BaseMaterialCertificate(int id, String heatNum, String lotNum, BaseMaterialType materialType) {
        this.id = id;
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.materialType = materialType;
    }

    public BaseMaterialCertificate(BaseMaterialCertificateEntity baseMaterialCertificateEntity) {
        this.id = baseMaterialCertificateEntity.getId();
        this.heatNum = baseMaterialCertificateEntity.getHeatNum();
        this.lotNum = baseMaterialCertificateEntity.getLotNum();
        this.materialType = new BaseMaterialType(baseMaterialCertificateEntity.getBaseMaterialType());
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

    public BaseMaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(BaseMaterialType materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "BaseMaterialCertificate{" +
                "id=" + id +
                ", heatNum='" + heatNum + '\'' +
                ", lotNum='" + lotNum + '\'' +
                ", materialType=" + materialType +
                '}';
    }
}
