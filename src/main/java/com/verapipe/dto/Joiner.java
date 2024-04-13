package com.verapipe.dto;

import com.verapipe.entities.JoinerEntity;

import java.util.Arrays;

public class Joiner {
    private int id;
    private String tagId;
    private byte[] certificate;
    private Float certifiedDiameterMinMm;
    private Float certifiedDiameterMaxMm;
    private Float certifiedDiameterMinInch;
    private Float certifiedDiameterMaxInch;
    private Float maxDepositedMaterial;
    private String baseMaterialTypeName1;
    private String baseMaterialTypeName2;
    private String jointDesignName;
    private String fusionProcessName;

    public Joiner() {
    }

    public Joiner(String tagId, byte[] certificate, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, String baseMaterialTypeName1, String baseMaterialTypeName2, String jointDesignName, String fusionProcessName) {
        this.tagId = tagId;
        this.certificate = certificate;
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialTypeName1 = baseMaterialTypeName1;
        this.baseMaterialTypeName2 = baseMaterialTypeName2;
        this.jointDesignName = jointDesignName;
        this.fusionProcessName = fusionProcessName;
    }

    public Joiner(int id, String tagId, byte[] certificate, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, String baseMaterialTypeName1, String baseMaterialTypeName2, String jointDesignName, String fusionProcessName) {
        this.id = id;
        this.tagId = tagId;
        this.certificate = certificate;
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialTypeName1 = baseMaterialTypeName1;
        this.baseMaterialTypeName2 = baseMaterialTypeName2;
        this.jointDesignName = jointDesignName;
        this.fusionProcessName = fusionProcessName;
    }

    public Joiner(JoinerEntity joinerEntity) {
        this.id = joinerEntity.getId();
        this.tagId = joinerEntity.getTagId();
        this.certificate = joinerEntity.getCertificate();
        this.certifiedDiameterMinMm = joinerEntity.getCertifiedDiameterMinMm();
        this.certifiedDiameterMaxMm = joinerEntity.getCertifiedDiameterMaxMm();
        this.certifiedDiameterMinInch = joinerEntity.getCertifiedDiameterMinInch();
        this.certifiedDiameterMaxInch = joinerEntity.getCertifiedDiameterMaxInch();
        this.maxDepositedMaterial = joinerEntity.getMaxDepositedMaterial();
        this.baseMaterialTypeName1 = joinerEntity.getBaseMaterialType1().getName();
        this.baseMaterialTypeName2 = joinerEntity.getBaseMaterialType2().getName();
        this.jointDesignName = joinerEntity.getJointDesign().getName();
        this.fusionProcessName = joinerEntity.getFusionProcess().getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public Float getCertifiedDiameterMinMm() {
        return certifiedDiameterMinMm;
    }

    public void setCertifiedDiameterMinMm(Float certifiedDiameterMinMm) {
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
    }

    public Float getCertifiedDiameterMaxMm() {
        return certifiedDiameterMaxMm;
    }

    public void setCertifiedDiameterMaxMm(Float certifiedDiameterMaxMm) {
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
    }

    public Float getCertifiedDiameterMinInch() {
        return certifiedDiameterMinInch;
    }

    public void setCertifiedDiameterMinInch(Float certifiedDiameterMinInch) {
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
    }

    public Float getCertifiedDiameterMaxInch() {
        return certifiedDiameterMaxInch;
    }

    public void setCertifiedDiameterMaxInch(Float certifiedDiameterMaxInch) {
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
    }

    public Float getMaxDepositedMaterial() {
        return maxDepositedMaterial;
    }

    public void setMaxDepositedMaterial(Float maxDepositedMaterial) {
        this.maxDepositedMaterial = maxDepositedMaterial;
    }

    public String getBaseMaterialTypeName1() {
        return baseMaterialTypeName1;
    }

    public void setBaseMaterialTypeName1(String baseMaterialTypeName1) {
        this.baseMaterialTypeName1 = baseMaterialTypeName1;
    }

    public String getBaseMaterialTypeName2() {
        return baseMaterialTypeName2;
    }

    public void setBaseMaterialTypeName2(String baseMaterialTypeName2) {
        this.baseMaterialTypeName2 = baseMaterialTypeName2;
    }

    public String getJointDesignName() {
        return jointDesignName;
    }

    public void setJointDesignName(String jointDesignName) {
        this.jointDesignName = jointDesignName;
    }

    public String getFusionProcessName() {
        return fusionProcessName;
    }

    public void setFusionProcessName(String fusionProcessName) {
        this.fusionProcessName = fusionProcessName;
    }

    @Override
    public String toString() {
        return "Joiner{" +
                "id=" + id +
                ", tagId='" + tagId + '\'' +
                ", certificate=" + Arrays.toString(certificate) +
                ", certifiedDiameterMinMm=" + certifiedDiameterMinMm +
                ", certifiedDiameterMaxMm=" + certifiedDiameterMaxMm +
                ", certifiedDiameterMinInch=" + certifiedDiameterMinInch +
                ", certifiedDiameterMaxInch=" + certifiedDiameterMaxInch +
                ", maxDepositedMaterial=" + maxDepositedMaterial +
                ", baseMaterialTypeName1=" + baseMaterialTypeName1 +
                ", baseMaterialTypeName2=" + baseMaterialTypeName2 +
                ", jointDesignName=" + jointDesignName +
                ", fusionProcessName=" + fusionProcessName +
                '}';
    }
}
