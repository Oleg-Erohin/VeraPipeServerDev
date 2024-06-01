package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialCertificateEntity;

public class BaseMaterialCertificate {
    private int id;
    private String heatNum;
    private String lotNum;
    private String materialTypeName;

    public BaseMaterialCertificate() {
    }

    public BaseMaterialCertificate(String heatNum, String lotNum, String materialTypeName) {
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.materialTypeName = materialTypeName;
    }

    public BaseMaterialCertificate(int id, String heatNum, String lotNum, String materialTypeName) {
        this.id = id;
        this.heatNum = heatNum;
        this.lotNum = lotNum;
        this.materialTypeName = materialTypeName;
    }

    public BaseMaterialCertificate(BaseMaterialCertificateEntity baseMaterialCertificateEntity) {
        this.id = baseMaterialCertificateEntity.getId();
        this.heatNum = baseMaterialCertificateEntity.getHeatNum();
        this.lotNum = baseMaterialCertificateEntity.getLotNum();
        this.materialTypeName = baseMaterialCertificateEntity.getBaseMaterialType().getName();
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
                ", materialTypeName='" + materialTypeName + '\'' +
                '}';
    }
}
