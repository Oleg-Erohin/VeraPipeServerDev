package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.FillerMaterialTypeEntity;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
import com.verapipe.enums.UnitOfMeasure;

import java.util.ArrayList;
import java.util.List;

public class ProcessSpecificationProcedure {
    private int id;
    private String name;
    private String jointDesignName;
    private BaseMaterialType baseMaterial1;
    private BaseMaterialType baseMaterial2;
    private String fusionProcessName;
    private FillerMaterialType fillerMaterial1;
    private FillerMaterialType fillerMaterial2;
    private String standardCodeName;
    private boolean isPreheatRequired;
    private boolean isPostWeldHeatTreatmentRequired;
    private Float diameterMinMm;
    private Float diameterMaxMm;
    private Float diameterMinInch;
    private Float diameterMaxInch;
    private UnitOfMeasure unitOfMeasure;
    private Float thicknessMinMm;
    private Float thicknessMaxMm;

    public ProcessSpecificationProcedure() {
    }

    public ProcessSpecificationProcedure(String name, String jointDesignName, BaseMaterialType baseMaterial1, BaseMaterialType baseMaterial2, String fusionProcessName, FillerMaterialType fillerMaterial1, FillerMaterialType fillerMaterial2, String standardCodeName, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, Float diameterMinMm, Float diameterMaxMm, Float diameterMinInch, Float diameterMaxInch, UnitOfMeasure unitOfMeasure, Float thicknessMinMm, Float thicknessMaxMm) {
        this.name = name;
        this.jointDesignName = jointDesignName;
        this.baseMaterial1 = baseMaterial1;
        this.baseMaterial2 = baseMaterial2;
        this.fusionProcessName = fusionProcessName;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterial2 = fillerMaterial2;
        this.standardCodeName = standardCodeName;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.diameterMinMm = diameterMinMm;
        this.diameterMaxMm = diameterMaxMm;
        this.diameterMinInch = diameterMinInch;
        this.diameterMaxInch = diameterMaxInch;
        this.unitOfMeasure = unitOfMeasure;
        this.thicknessMinMm = thicknessMinMm;
        this.thicknessMaxMm = thicknessMaxMm;
    }

    public ProcessSpecificationProcedure(int id, String name, String jointDesignName, BaseMaterialType baseMaterial1, BaseMaterialType baseMaterial2, String fusionProcessName, FillerMaterialType fillerMaterial1, FillerMaterialType fillerMaterial2, String standardCodeName, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, Float diameterMinMm, Float diameterMaxMm, Float diameterMinInch, Float diameterMaxInch, UnitOfMeasure unitOfMeasure, Float thicknessMinMm, Float thicknessMaxMm) {
        this.id = id;
        this.name = name;
        this.jointDesignName = jointDesignName;
        this.baseMaterial1 = baseMaterial1;
        this.baseMaterial2 = baseMaterial2;
        this.fusionProcessName = fusionProcessName;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterial2 = fillerMaterial2;
        this.standardCodeName = standardCodeName;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.diameterMinMm = diameterMinMm;
        this.diameterMaxMm = diameterMaxMm;
        this.diameterMinInch = diameterMinInch;
        this.diameterMaxInch = diameterMaxInch;
        this.unitOfMeasure = unitOfMeasure;
        this.thicknessMinMm = thicknessMinMm;
        this.thicknessMaxMm = thicknessMaxMm;
    }

    public ProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedureEntity) {
        this.id = processSpecificationProcedureEntity.getId();
        this.name = processSpecificationProcedureEntity.getName();
        this.jointDesignName = processSpecificationProcedureEntity.getJointDesign().getName();

        List<BaseMaterialTypeEntity> baseMaterialTypeEntityList = new ArrayList<>();
        baseMaterialTypeEntityList.addAll(processSpecificationProcedureEntity.getBaseMaterialTypeList());
        this.baseMaterial1 = new BaseMaterialType(baseMaterialTypeEntityList.get(0));
        this.baseMaterial2 = new BaseMaterialType(baseMaterialTypeEntityList.get(1));

        this.fusionProcessName = processSpecificationProcedureEntity.getFusionProcess().getName();

        List<FillerMaterialTypeEntity> fillerMaterialTypeEntityList = new ArrayList<>();
        fillerMaterialTypeEntityList.addAll(processSpecificationProcedureEntity.getFillerMaterialTypeList());
        this.fillerMaterial1 = new FillerMaterialType(fillerMaterialTypeEntityList.get(0));
        this.fillerMaterial2 = new FillerMaterialType(fillerMaterialTypeEntityList.get(1));

        this.standardCodeName = processSpecificationProcedureEntity.getStandardCode().getName();
        this.isPreheatRequired = processSpecificationProcedureEntity.isPreheatRequired();
        this.isPostWeldHeatTreatmentRequired = processSpecificationProcedureEntity.isPostWeldHeatTreatmentRequired();
        this.diameterMinMm = processSpecificationProcedureEntity.getDiameterMmMin();
        this.diameterMaxMm = processSpecificationProcedureEntity.getDiameterMmMax();
        this.diameterMinInch = processSpecificationProcedureEntity.getDiameterInchMin();
        this.diameterMaxInch = processSpecificationProcedureEntity.getDiameterInchMax();
        this.unitOfMeasure = processSpecificationProcedureEntity.getThicknessUom();
        this.thicknessMinMm = processSpecificationProcedureEntity.getThicknessMmMin();
        this.thicknessMaxMm = processSpecificationProcedureEntity.getThicknessMmMax();
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

    public String getJointDesignName() {
        return jointDesignName;
    }

    public void setJointDesignName(String jointDesignName) {
        this.jointDesignName = jointDesignName;
    }

    public BaseMaterialType getBaseMaterial1() {
        return baseMaterial1;
    }

    public void setBaseMaterial1(BaseMaterialType baseMaterial1) {
        this.baseMaterial1 = baseMaterial1;
    }

    public BaseMaterialType getBaseMaterial2() {
        return baseMaterial2;
    }

    public void setBaseMaterial2(BaseMaterialType baseMaterial2) {
        this.baseMaterial2 = baseMaterial2;
    }

    public String getFusionProcessName() {
        return fusionProcessName;
    }

    public void setFusionProcessName(String fusionProcessName) {
        this.fusionProcessName = fusionProcessName;
    }

    public FillerMaterialType getFillerMaterial1() {
        return fillerMaterial1;
    }

    public void setFillerMaterial1(FillerMaterialType fillerMaterial1) {
        this.fillerMaterial1 = fillerMaterial1;
    }

    public FillerMaterialType getFillerMaterial2() {
        return fillerMaterial2;
    }

    public void setFillerMaterial2(FillerMaterialType fillerMaterial2) {
        this.fillerMaterial2 = fillerMaterial2;
    }

    public String getStandardCodeName() {
        return standardCodeName;
    }

    public void setStandardCodeName(String standardCodeName) {
        this.standardCodeName = standardCodeName;
    }

    public boolean isPreheatRequired() {
        return isPreheatRequired;
    }

    public void setPreheatRequired(boolean preheatRequired) {
        isPreheatRequired = preheatRequired;
    }

    public boolean isPostWeldHeatTreatmentRequired() {
        return isPostWeldHeatTreatmentRequired;
    }

    public void setPostWeldHeatTreatmentRequired(boolean postWeldHeatTreatmentRequired) {
        isPostWeldHeatTreatmentRequired = postWeldHeatTreatmentRequired;
    }

    public Float getDiameterMinMm() {
        return diameterMinMm;
    }

    public void setDiameterMinMm(Float diameterMinMm) {
        this.diameterMinMm = diameterMinMm;
    }

    public Float getDiameterMaxMm() {
        return diameterMaxMm;
    }

    public void setDiameterMaxMm(Float diameterMaxMm) {
        this.diameterMaxMm = diameterMaxMm;
    }

    public Float getDiameterMinInch() {
        return diameterMinInch;
    }

    public void setDiameterMinInch(Float diameterMinInch) {
        this.diameterMinInch = diameterMinInch;
    }

    public Float getDiameterMaxInch() {
        return diameterMaxInch;
    }

    public void setDiameterMaxInch(Float diameterMaxInch) {
        this.diameterMaxInch = diameterMaxInch;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getThicknessMinMm() {
        return thicknessMinMm;
    }

    public void setThicknessMinMm(Float thicknessMinMm) {
        this.thicknessMinMm = thicknessMinMm;
    }

    public Float getThicknessMaxMm() {
        return thicknessMaxMm;
    }

    public void setThicknessMaxMm(Float thicknessMaxMm) {
        this.thicknessMaxMm = thicknessMaxMm;
    }

    @Override
    public String toString() {
        return "ProcessSpecificationProcedure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jointDesignName='" + jointDesignName + '\'' +
                ", baseMaterial1=" + baseMaterial1 +
                ", baseMaterial2=" + baseMaterial2 +
                ", fusionProcessName='" + fusionProcessName + '\'' +
                ", fillerMaterial1=" + fillerMaterial1 +
                ", fillerMaterial2=" + fillerMaterial2 +
                ", standardCodeName='" + standardCodeName + '\'' +
                ", isPreheatRequired=" + isPreheatRequired +
                ", isPostWeldHeatTreatmentRequired=" + isPostWeldHeatTreatmentRequired +
                ", diameterMinMm=" + diameterMinMm +
                ", diameterMaxMm=" + diameterMaxMm +
                ", diameterMinInch=" + diameterMinInch +
                ", diameterMaxInch=" + diameterMaxInch +
                ", unitOfMeasure=" + unitOfMeasure +
                ", thicknessMinMm=" + thicknessMinMm +
                ", thicknessMaxMm=" + thicknessMaxMm +
                '}';
    }
}
