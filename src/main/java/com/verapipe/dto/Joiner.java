package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.FusionProcessEntity;
import com.verapipe.entities.JoinerEntity;
import com.verapipe.entities.JointDesignEntity;
import com.verapipe.enums.UnitOfMeasure;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Joiner {
    private int id;
    private String tagId;
    private UnitOfMeasure uom;
    private Float certifiedDiameterMin;
    private Float certifiedDiameterMax;
    private Float maxDepositedMaterial;
    private BaseMaterialType baseMaterialType1;
    private BaseMaterialType baseMaterialType2;
    private JointDesign jointDesign;
    private FusionProcess fusionProcess;

    public Joiner() {
    }

    public Joiner(String tagId, UnitOfMeasure uom, Float certifiedDiameterMin, Float certifiedDiameterMax, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, JointDesign jointDesign, FusionProcess fusionProcess) {
        this.tagId = tagId;
        this.uom = uom;
        this.certifiedDiameterMin = certifiedDiameterMin;
        this.certifiedDiameterMax = certifiedDiameterMax;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesign = jointDesign;
        this.fusionProcess = fusionProcess;
    }

    public Joiner(int id, String tagId, UnitOfMeasure uom, Float certifiedDiameterMin, Float certifiedDiameterMax, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, JointDesign jointDesign, FusionProcess fusionProcess) {
        this.id = id;
        this.tagId = tagId;
        this.uom = uom;
        this.certifiedDiameterMin = certifiedDiameterMin;
        this.certifiedDiameterMax = certifiedDiameterMax;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesign = jointDesign;
        this.fusionProcess = fusionProcess;
    }

    public Joiner(JoinerEntity joinerEntity) {
        this.id = joinerEntity.getId();
        this.tagId = joinerEntity.getTagId();
        this.certifiedDiameterMin = joinerEntity.getCertifiedDiameterMinMm();
        this.certifiedDiameterMax = joinerEntity.getCertifiedDiameterMaxMm();
        this.maxDepositedMaterial = joinerEntity.getMaxDepositedMaterial();

        // Convert BaseMaterialType Entities to DTOs
        Set<BaseMaterialTypeEntity> baseMaterialTypes = joinerEntity.getBaseMaterialTypeList();
        if (baseMaterialTypes != null && !baseMaterialTypes.isEmpty()) {
            List<BaseMaterialType> baseMaterialTypeDTOs = baseMaterialTypes.stream()
                    .map(BaseMaterialType::new)
                    .collect(Collectors.toList());
            if (baseMaterialTypeDTOs.size() > 0) {
                this.baseMaterialType1 = baseMaterialTypeDTOs.get(0);
            }
            if (baseMaterialTypeDTOs.size() > 1) {
                this.baseMaterialType2 = baseMaterialTypeDTOs.get(1);
            }
        }

        // Convert JointDesign Entity to DTO
        JointDesignEntity jointDesignEntity = joinerEntity.getJointDesign();
        if (jointDesignEntity != null) {
            this.jointDesign = new JointDesign(jointDesignEntity);
        }

        // Convert FusionProcess Entity to DTO
        FusionProcessEntity fusionProcessEntity = joinerEntity.getFusionProcess();
        if (fusionProcessEntity != null) {
            this.fusionProcess = new FusionProcess(fusionProcessEntity);
        }
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

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
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

    public FusionProcess getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(FusionProcess fusionProcess) {
        this.fusionProcess = fusionProcess;
    }

    @Override
    public String toString() {
        return "Joiner{" +
                "id=" + id +
                ", tagId='" + tagId + '\'' +
                ", uom=" + uom +
                ", certifiedDiameterMin=" + certifiedDiameterMin +
                ", certifiedDiameterMax=" + certifiedDiameterMax +
                ", maxDepositedMaterial=" + maxDepositedMaterial +
                ", baseMaterialType1=" + baseMaterialType1 +
                ", baseMaterialType2=" + baseMaterialType2 +
                ", jointDesign=" + jointDesign +
                ", fusionProcess=" + fusionProcess +
                '}';
    }
}
