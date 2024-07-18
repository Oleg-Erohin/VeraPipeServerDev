package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.JoinerEntity;
import com.verapipe.enums.UnitOfMeasure;

import java.util.ArrayList;
import java.util.List;

public class Joiner {
    private int id;
    private String tagId;
    private UnitOfMeasure unitOfMeasure;
    private Float certifiedDiameterMin;
    private Float certifiedDiameterMax;
    private Float maxDepositedMaterial;
    private BaseMaterialType baseMaterialType1;
    private BaseMaterialType baseMaterialType2;
    private JointDesign jointDesign;
    private String fusionProcessName;

    public Joiner() {
    }

    public Joiner(String tagId, UnitOfMeasure unitOfMeasure, Float certifiedDiameterMin, Float certifiedDiameterMax, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, JointDesign jointDesign, String fusionProcessName) {
        this.tagId = tagId;
        this.unitOfMeasure = unitOfMeasure;
        this.certifiedDiameterMin = certifiedDiameterMin;
        this.certifiedDiameterMax = certifiedDiameterMax;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesign = jointDesign;
        this.fusionProcessName = fusionProcessName;
    }

    public Joiner(int id, String tagId, UnitOfMeasure unitOfMeasure, Float certifiedDiameterMin, Float certifiedDiameterMax, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, JointDesign jointDesign, String fusionProcessName) {
        this.id = id;
        this.tagId = tagId;
        this.unitOfMeasure = unitOfMeasure;
        this.certifiedDiameterMin = certifiedDiameterMin;
        this.certifiedDiameterMax = certifiedDiameterMax;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesign = jointDesign;
        this.fusionProcessName = fusionProcessName;
    }

    public Joiner(JoinerEntity joinerEntity) {
        this.id = joinerEntity.getId();
        this.tagId = joinerEntity.getTagId();
        this.certifiedDiameterMin = joinerEntity.getCertifiedDiameterMin();
        this.certifiedDiameterMax = joinerEntity.getCertifiedDiameterMax();
        this.maxDepositedMaterial = joinerEntity.getMaxDepositedMaterial();

        List<BaseMaterialTypeEntity> baseMaterialTypeEntityList = new ArrayList<>();
        baseMaterialTypeEntityList.addAll(joinerEntity.getBaseMaterialTypeList());
        this.baseMaterialType1 = new BaseMaterialType(baseMaterialTypeEntityList.get(0));
        this.baseMaterialType2 = new BaseMaterialType(baseMaterialTypeEntityList.get(1));

        this.jointDesign = new JointDesign(joinerEntity.getJointDesign());
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

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getCertifiedDiameterMin() {
        return certifiedDiameterMin;
    }

    public void setCertifiedDiameterMin(Float certifiedDiameterMin) {
        this.certifiedDiameterMin = certifiedDiameterMin;
    }

    public Float getCertifiedDiameterMax() {
        return certifiedDiameterMax;
    }

    public void setCertifiedDiameterMax(Float certifiedDiameterMax) {
        this.certifiedDiameterMax = certifiedDiameterMax;
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

    public JointDesign getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(JointDesign jointDesign) {
        this.jointDesign = jointDesign;
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
                ", unitOfMeasure=" + unitOfMeasure +
                ", certifiedDiameterMin=" + certifiedDiameterMin +
                ", certifiedDiameterMax=" + certifiedDiameterMax +
                ", maxDepositedMaterial=" + maxDepositedMaterial +
                ", baseMaterialType1=" + baseMaterialType1 +
                ", baseMaterialType2=" + baseMaterialType2 +
                ", jointDesign=" + jointDesign +
                ", fusionProcessName='" + fusionProcessName + '\'' +
                '}';
    }
}
