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
    private JointDesign jointDesign;
    private BaseMaterialType baseMaterial1;
    private BaseMaterialType baseMaterial2;
    private FusionProcess fusionProcess;
    private FillerMaterialType fillerMaterial1;
    private FillerMaterialType fillerMaterial2;
    private StandardCode standardCode;
    private boolean isPreheatRequired;
    private boolean isPostWeldHeatTreatmentRequired;
    private UnitOfMeasure unitOfMeasure;
    private Float diameterMin;
    private Float diameterMax;
    private Float thicknessMin;
    private Float thicknessMax;

    public ProcessSpecificationProcedure() {
    }

    public ProcessSpecificationProcedure(String name, JointDesign jointDesign, BaseMaterialType baseMaterial1, BaseMaterialType baseMaterial2, FusionProcess fusionProcess, FillerMaterialType fillerMaterial1, FillerMaterialType fillerMaterial2, StandardCode standardCode, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, UnitOfMeasure unitOfMeasure, Float diameterMin, Float diameterMax, Float thicknessMin, Float thicknessMax) {
        this.name = name;
        this.jointDesign = jointDesign;
        this.baseMaterial1 = baseMaterial1;
        this.baseMaterial2 = baseMaterial2;
        this.fusionProcess = fusionProcess;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterial2 = fillerMaterial2;
        this.standardCode = standardCode;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.unitOfMeasure = unitOfMeasure;
        this.diameterMin = diameterMin;
        this.diameterMax = diameterMax;
        this.thicknessMin = thicknessMin;
        this.thicknessMax = thicknessMax;
    }

    public ProcessSpecificationProcedure(int id, String name, JointDesign jointDesign, BaseMaterialType baseMaterial1, BaseMaterialType baseMaterial2, FusionProcess fusionProcess, FillerMaterialType fillerMaterial1, FillerMaterialType fillerMaterial2, StandardCode standardCode, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, UnitOfMeasure unitOfMeasure, Float diameterMin, Float diameterMax, Float thicknessMin, Float thicknessMax) {
        this.id = id;
        this.name = name;
        this.jointDesign = jointDesign;
        this.baseMaterial1 = baseMaterial1;
        this.baseMaterial2 = baseMaterial2;
        this.fusionProcess = fusionProcess;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterial2 = fillerMaterial2;
        this.standardCode = standardCode;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.unitOfMeasure = unitOfMeasure;
        this.diameterMin = diameterMin;
        this.diameterMax = diameterMax;
        this.thicknessMin = thicknessMin;
        this.thicknessMax = thicknessMax;
    }

    public ProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedureEntity) {
        this.id = processSpecificationProcedureEntity.getId();
        this.name = processSpecificationProcedureEntity.getName();
        this.jointDesign = new JointDesign(processSpecificationProcedureEntity.getJointDesign());

        List<BaseMaterialTypeEntity> baseMaterialTypeEntityList = new ArrayList<>();
        baseMaterialTypeEntityList.addAll(processSpecificationProcedureEntity.getBaseMaterialTypeList());
        this.baseMaterial1 = new BaseMaterialType(baseMaterialTypeEntityList.get(0));
        this.baseMaterial2 = new BaseMaterialType(baseMaterialTypeEntityList.get(1));

        this.fusionProcess = new FusionProcess(processSpecificationProcedureEntity.getFusionProcess());

        List<FillerMaterialTypeEntity> fillerMaterialTypeEntityList = new ArrayList<>();
        fillerMaterialTypeEntityList.addAll(processSpecificationProcedureEntity.getFillerMaterialTypeList());
        this.fillerMaterial1 = new FillerMaterialType(fillerMaterialTypeEntityList.get(0));
        this.fillerMaterial2 = new FillerMaterialType(fillerMaterialTypeEntityList.get(1));

        this.standardCode = new StandardCode(processSpecificationProcedureEntity.getStandardCode());
        this.isPreheatRequired = processSpecificationProcedureEntity.isPreheatRequired();
        this.isPostWeldHeatTreatmentRequired = processSpecificationProcedureEntity.isPostWeldHeatTreatmentRequired();
        this.unitOfMeasure = processSpecificationProcedureEntity.getUnitOfMeasure();
        this.diameterMin = processSpecificationProcedureEntity.getDiameterMin();
        this.diameterMax = processSpecificationProcedureEntity.getDiameterMax();
        this.thicknessMin = processSpecificationProcedureEntity.getThicknessMin();
        this.thicknessMax = processSpecificationProcedureEntity.getThicknessMax();
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

    public JointDesign getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(JointDesign jointDesign) {
        this.jointDesign = jointDesign;
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

    public FusionProcess getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(FusionProcess fusionProcess) {
        this.fusionProcess = fusionProcess;
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

    public StandardCode getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(StandardCode standardCode) {
        this.standardCode = standardCode;
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

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getDiameterMin() {
        return diameterMin;
    }

    public void setDiameterMin(Float diameterMin) {
        this.diameterMin = diameterMin;
    }

    public Float getDiameterMax() {
        return diameterMax;
    }

    public void setDiameterMax(Float diameterMax) {
        this.diameterMax = diameterMax;
    }

    public Float getThicknessMin() {
        return thicknessMin;
    }

    public void setThicknessMin(Float thicknessMin) {
        this.thicknessMin = thicknessMin;
    }

    public Float getThicknessMax() {
        return thicknessMax;
    }

    public void setThicknessMax(Float thicknessMax) {
        this.thicknessMax = thicknessMax;
    }

    @Override
    public String toString() {
        return "ProcessSpecificationProcedure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jointDesign=" + jointDesign +
                ", baseMaterial1=" + baseMaterial1 +
                ", baseMaterial2=" + baseMaterial2 +
                ", fusionProcess=" + fusionProcess +
                ", fillerMaterial1=" + fillerMaterial1 +
                ", fillerMaterial2=" + fillerMaterial2 +
                ", standardCode=" + standardCode +
                ", isPreheatRequired=" + isPreheatRequired +
                ", isPostWeldHeatTreatmentRequired=" + isPostWeldHeatTreatmentRequired +
                ", unitOfMeasure=" + unitOfMeasure +
                ", diameterMin=" + diameterMin +
                ", diameterMax=" + diameterMax +
                ", thicknessMin=" + thicknessMin +
                ", thicknessMax=" + thicknessMax +
                '}';
    }
}
