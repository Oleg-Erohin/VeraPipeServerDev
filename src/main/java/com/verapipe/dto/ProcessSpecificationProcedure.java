package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.FillerMaterialTypeEntity;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
import com.verapipe.enums.ThicknessUOM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessSpecificationProcedure {
    private int id;
    private String name;
    private byte[] procedureFile;
    private byte[] processQualificationRecordFile;
    private String jointDesignName;
    private String baseMaterialName1;
    private String baseMaterialName2;
    private String fusionProcessName;
    private String fillerMaterialName1;
    private String fillerMaterialName2;
    private String standardCodeName;
    private boolean isPreheatRequired;
    private boolean isPostWeldHeatTreatmentRequired;
    private Float diameterMinMm;
    private Float diameterMaxMm;
    private Float diameterMinInch;
    private Float diameterMaxInch;
    private ThicknessUOM thicknessUom;
    private Float thicknessMinMm;
    private Float thicknessMaxMm;

    public ProcessSpecificationProcedure() {
    }

    public ProcessSpecificationProcedure(String name, byte[] procedureFile, byte[] processQualificationRecordFile, String jointDesignName, String baseMaterialName1, String baseMaterialName2, String fusionProcessName, String fillerMaterialName1, String fillerMaterialName2, String standardCodeName, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, Float diameterMinMm, Float diameterMaxMm, Float diameterMinInch, Float diameterMaxInch, ThicknessUOM thicknessUom, Float thicknessMinMm, Float thicknessMaxMm) {
        this.name = name;
        this.procedureFile = procedureFile;
        this.processQualificationRecordFile = processQualificationRecordFile;
        this.jointDesignName = jointDesignName;
        this.baseMaterialName1 = baseMaterialName1;
        this.baseMaterialName2 = baseMaterialName2;
        this.fusionProcessName = fusionProcessName;
        this.fillerMaterialName1 = fillerMaterialName1;
        this.fillerMaterialName2 = fillerMaterialName2;
        this.standardCodeName = standardCodeName;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.diameterMinMm = diameterMinMm;
        this.diameterMaxMm = diameterMaxMm;
        this.diameterMinInch = diameterMinInch;
        this.diameterMaxInch = diameterMaxInch;
        this.thicknessUom = thicknessUom;
        this.thicknessMinMm = thicknessMinMm;
        this.thicknessMaxMm = thicknessMaxMm;
    }

    public ProcessSpecificationProcedure(int id, String name, byte[] procedureFile, byte[] processQualificationRecordFile, String jointDesignName, String baseMaterialName1, String baseMaterialName2, String fusionProcessName, String fillerMaterialName1, String fillerMaterialName2, String standardCodeName, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, Float diameterMinMm, Float diameterMaxMm, Float diameterMinInch, Float diameterMaxInch, ThicknessUOM thicknessUom, Float thicknessMinMm, Float thicknessMaxMm) {
        this.id = id;
        this.name = name;
        this.procedureFile = procedureFile;
        this.processQualificationRecordFile = processQualificationRecordFile;
        this.jointDesignName = jointDesignName;
        this.baseMaterialName1 = baseMaterialName1;
        this.baseMaterialName2 = baseMaterialName2;
        this.fusionProcessName = fusionProcessName;
        this.fillerMaterialName1 = fillerMaterialName1;
        this.fillerMaterialName2 = fillerMaterialName2;
        this.standardCodeName = standardCodeName;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.diameterMinMm = diameterMinMm;
        this.diameterMaxMm = diameterMaxMm;
        this.diameterMinInch = diameterMinInch;
        this.diameterMaxInch = diameterMaxInch;
        this.thicknessUom = thicknessUom;
        this.thicknessMinMm = thicknessMinMm;
        this.thicknessMaxMm = thicknessMaxMm;
    }

    public ProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedureEntity) {
        this.id = processSpecificationProcedureEntity.getId();
        this.name = processSpecificationProcedureEntity.getName();
        this.procedureFile = processSpecificationProcedureEntity.getProcedureFile();
        this.processQualificationRecordFile = processSpecificationProcedureEntity.getProcessQualificationRecordFile();
        this.jointDesignName = processSpecificationProcedureEntity.getJointDesign().getName();

        List<BaseMaterialTypeEntity> baseMaterialTypeEntityList = new ArrayList<>();
        baseMaterialTypeEntityList.addAll(processSpecificationProcedureEntity.getBaseMaterialTypeList());
        this.baseMaterialName1 = baseMaterialTypeEntityList.get(0).getName();
        this.baseMaterialName2 = baseMaterialTypeEntityList.get(1).getName();

        this.fusionProcessName = processSpecificationProcedureEntity.getFusionProcess().getName();

        List<FillerMaterialTypeEntity> fillerMaterialTypeEntityList = new ArrayList<>();
        fillerMaterialTypeEntityList.addAll(processSpecificationProcedureEntity.getFillerMaterialTypeList());
        this.fillerMaterialName1 = fillerMaterialTypeEntityList.get(0).getName();
        this.fillerMaterialName2 = fillerMaterialTypeEntityList.get(1).getName();

        this.standardCodeName = processSpecificationProcedureEntity.getStandardCode().getName();
        this.isPreheatRequired = processSpecificationProcedureEntity.isPreheatRequired();
        this.isPostWeldHeatTreatmentRequired = processSpecificationProcedureEntity.isPostWeldHeatTreatmentRequired();
        this.diameterMinMm = processSpecificationProcedureEntity.getDiameterMmMin();
        this.diameterMaxMm = processSpecificationProcedureEntity.getDiameterMmMax();
        this.diameterMinInch = processSpecificationProcedureEntity.getDiameterInchMin();
        this.diameterMaxInch = processSpecificationProcedureEntity.getDiameterInchMax();
        this.thicknessUom = processSpecificationProcedureEntity.getThicknessUom();
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

    public byte[] getProcedureFile() {
        return procedureFile;
    }

    public void setProcedureFile(byte[] procedureFile) {
        this.procedureFile = procedureFile;
    }

    public byte[] getProcessQualificationRecordFile() {
        return processQualificationRecordFile;
    }

    public void setProcessQualificationRecordFile(byte[] processQualificationRecordFile) {
        this.processQualificationRecordFile = processQualificationRecordFile;
    }

    public String getJointDesignName() {
        return jointDesignName;
    }

    public void setJointDesignName(String jointDesignName) {
        this.jointDesignName = jointDesignName;
    }

    public String getBaseMaterialName1() {
        return baseMaterialName1;
    }

    public void setBaseMaterialName1(String baseMaterialName1) {
        this.baseMaterialName1 = baseMaterialName1;
    }

    public String getBaseMaterialName2() {
        return baseMaterialName2;
    }

    public void setBaseMaterialName2(String baseMaterialName2) {
        this.baseMaterialName2 = baseMaterialName2;
    }

    public String getFusionProcessName() {
        return fusionProcessName;
    }

    public void setFusionProcessName(String fusionProcessName) {
        this.fusionProcessName = fusionProcessName;
    }

    public String getFillerMaterialName1() {
        return fillerMaterialName1;
    }

    public void setFillerMaterialName1(String fillerMaterialName1) {
        this.fillerMaterialName1 = fillerMaterialName1;
    }

    public String getFillerMaterialName2() {
        return fillerMaterialName2;
    }

    public void setFillerMaterialName2(String fillerMaterialName2) {
        this.fillerMaterialName2 = fillerMaterialName2;
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

    public ThicknessUOM getThicknessUom() {
        return thicknessUom;
    }

    public void setThicknessUom(ThicknessUOM thicknessUom) {
        this.thicknessUom = thicknessUom;
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
                ", procedureFile=" + Arrays.toString(procedureFile) +
                ", processQualificationRecordFile=" + Arrays.toString(processQualificationRecordFile) +
                ", jointDesignName='" + jointDesignName + '\'' +
                ", baseMaterialName1='" + baseMaterialName1 + '\'' +
                ", baseMaterialName2='" + baseMaterialName2 + '\'' +
                ", fusionProcessName='" + fusionProcessName + '\'' +
                ", fillerMaterialName1='" + fillerMaterialName1 + '\'' +
                ", fillerMaterialName2='" + fillerMaterialName2 + '\'' +
                ", standardCodeName='" + standardCodeName + '\'' +
                ", isPreheatRequired=" + isPreheatRequired +
                ", isPostWeldHeatTreatmentRequired=" + isPostWeldHeatTreatmentRequired +
                ", diameterMmMin=" + diameterMinMm +
                ", diameterMmMax=" + diameterMaxMm +
                ", diameterInchMin=" + diameterMinInch +
                ", diameterInchMax=" + diameterMaxInch +
                ", thicknessUom=" + thicknessUom +
                ", thicknessMinMm=" + thicknessMinMm +
                ", thicknessMaxMm=" + thicknessMaxMm +
                '}';
    }
}
