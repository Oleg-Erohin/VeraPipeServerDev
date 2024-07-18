package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.JoinerEntity;

import java.util.ArrayList;
import java.util.List;

public class Joiner {
    private int id;
    private String tagId;
    private Float certifiedDiameterMinMm;
    private Float certifiedDiameterMaxMm;
    private Float certifiedDiameterMinInch;
    private Float certifiedDiameterMaxInch;
    private Float maxDepositedMaterial;
    private BaseMaterialType baseMaterialType1;
    private BaseMaterialType baseMaterialType2;
    private String jointDesignName;
    private String fusionProcessName;

    public Joiner() {
    }

    public Joiner(String tagId, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, String jointDesignName, String fusionProcessName) {
        this.tagId = tagId;
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesignName = jointDesignName;
        this.fusionProcessName = fusionProcessName;
    }

    public Joiner(int id, String tagId, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, String jointDesignName, String fusionProcessName) {
        this.id = id;
        this.tagId = tagId;
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesignName = jointDesignName;
        this.fusionProcessName = fusionProcessName;
    }

    public Joiner(JoinerEntity joinerEntity) {
        this.id = joinerEntity.getId();
        this.tagId = joinerEntity.getTagId();
        this.certifiedDiameterMinMm = joinerEntity.getCertifiedDiameterMinMm();
        this.certifiedDiameterMaxMm = joinerEntity.getCertifiedDiameterMaxMm();
        this.certifiedDiameterMinInch = joinerEntity.getCertifiedDiameterMinInch();
        this.certifiedDiameterMaxInch = joinerEntity.getCertifiedDiameterMaxInch();
        this.maxDepositedMaterial = joinerEntity.getMaxDepositedMaterial();

        List<BaseMaterialTypeEntity> baseMaterialTypeEntityList = new ArrayList<>();
        baseMaterialTypeEntityList.addAll(joinerEntity.getBaseMaterialTypeList());
        this.baseMaterialType1 = new BaseMaterialType(baseMaterialTypeEntityList.get(0));
        this.baseMaterialType2 = new BaseMaterialType(baseMaterialTypeEntityList.get(1));

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

    public BaseMaterialType getBaseMaterialType1() {
        return baseMaterialType1;
    }

    public void setBaseMaterialType1(BaseMaterialType baseMaterialType1) {
        this.baseMaterialType1 = baseMaterialType1;
    }

    public BaseMaterialType getBaseMaterialType2() {
        return baseMaterialType2;
    }

    public void setBaseMaterialType2(BaseMaterialType baseMaterialType2) {
        this.baseMaterialType2 = baseMaterialType2;
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
                ", certifiedDiameterMinMm=" + certifiedDiameterMinMm +
                ", certifiedDiameterMaxMm=" + certifiedDiameterMaxMm +
                ", certifiedDiameterMinInch=" + certifiedDiameterMinInch +
                ", certifiedDiameterMaxInch=" + certifiedDiameterMaxInch +
                ", maxDepositedMaterial=" + maxDepositedMaterial +
                ", baseMaterialType1=" + baseMaterialType1 +
                ", baseMaterialType2=" + baseMaterialType2 +
                ", jointDesignName='" + jointDesignName + '\'' +
                ", fusionProcessName='" + fusionProcessName + '\'' +
                '}';
    }
}
