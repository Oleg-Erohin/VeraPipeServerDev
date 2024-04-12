package com.verapipe.dto;

import com.verapipe.enums.ThicknessUOM;

import java.util.Arrays;

public class ProcessSpecificationProcedure {
    private int id;
    private String name;
    private byte[] procedureFile;
    private byte[] processQualificationRecordFile;
    private String jointDesign;
    private String baseMaterial1;
    private String baseMaterial2;
    private String fusionProcess;
    private String fillerMaterial1;
    private String fillerMaterial2;
    private String standardCode;
    private boolean isPreheatRequired;
    private boolean isPostWeldHeatTreatmentRequired;
    private Float diameterMmMin;
    private Float diameterMmMax;
    private Float diameterInchMin;
    private Float diameterInchMax;
    private ThicknessUOM thicknessUom;
    private Float thicknessMmMin;
    private Float thicknessMmMax;

    public ProcessSpecificationProcedure() {
    }

    public ProcessSpecificationProcedure(String name, byte[] procedureFile, byte[] processQualificationRecordFile, String jointDesign, String baseMaterial1, String baseMaterial2, String fusionProcess, String fillerMaterial1, String fillerMaterial2, String standardCode, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, Float diameterMmMin, Float diameterMmMax, Float diameterInchMin, Float diameterInchMax, ThicknessUOM thicknessUom, Float thicknessMmMin, Float thicknessMmMax) {
        this.name = name;
        this.procedureFile = procedureFile;
        this.processQualificationRecordFile = processQualificationRecordFile;
        this.jointDesign = jointDesign;
        this.baseMaterial1 = baseMaterial1;
        this.baseMaterial2 = baseMaterial2;
        this.fusionProcess = fusionProcess;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterial2 = fillerMaterial2;
        this.standardCode = standardCode;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.diameterMmMin = diameterMmMin;
        this.diameterMmMax = diameterMmMax;
        this.diameterInchMin = diameterInchMin;
        this.diameterInchMax = diameterInchMax;
        this.thicknessUom = thicknessUom;
        this.thicknessMmMin = thicknessMmMin;
        this.thicknessMmMax = thicknessMmMax;
    }

    public ProcessSpecificationProcedure(int id, String name, byte[] procedureFile, byte[] processQualificationRecordFile, String jointDesign, String baseMaterial1, String baseMaterial2, String fusionProcess, String fillerMaterial1, String fillerMaterial2, String standardCode, boolean isPreheatRequired, boolean isPostWeldHeatTreatmentRequired, Float diameterMmMin, Float diameterMmMax, Float diameterInchMin, Float diameterInchMax, ThicknessUOM thicknessUom, Float thicknessMmMin, Float thicknessMmMax) {
        this.id = id;
        this.name = name;
        this.procedureFile = procedureFile;
        this.processQualificationRecordFile = processQualificationRecordFile;
        this.jointDesign = jointDesign;
        this.baseMaterial1 = baseMaterial1;
        this.baseMaterial2 = baseMaterial2;
        this.fusionProcess = fusionProcess;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterial2 = fillerMaterial2;
        this.standardCode = standardCode;
        this.isPreheatRequired = isPreheatRequired;
        this.isPostWeldHeatTreatmentRequired = isPostWeldHeatTreatmentRequired;
        this.diameterMmMin = diameterMmMin;
        this.diameterMmMax = diameterMmMax;
        this.diameterInchMin = diameterInchMin;
        this.diameterInchMax = diameterInchMax;
        this.thicknessUom = thicknessUom;
        this.thicknessMmMin = thicknessMmMin;
        this.thicknessMmMax = thicknessMmMax;
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

    public String getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(String jointDesign) {
        this.jointDesign = jointDesign;
    }

    public String getBaseMaterial1() {
        return baseMaterial1;
    }

    public void setBaseMaterial1(String baseMaterial1) {
        this.baseMaterial1 = baseMaterial1;
    }

    public String getBaseMaterial2() {
        return baseMaterial2;
    }

    public void setBaseMaterial2(String baseMaterial2) {
        this.baseMaterial2 = baseMaterial2;
    }

    public String getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(String fusionProcess) {
        this.fusionProcess = fusionProcess;
    }

    public String getFillerMaterial1() {
        return fillerMaterial1;
    }

    public void setFillerMaterial1(String fillerMaterial1) {
        this.fillerMaterial1 = fillerMaterial1;
    }

    public String getFillerMaterial2() {
        return fillerMaterial2;
    }

    public void setFillerMaterial2(String fillerMaterial2) {
        this.fillerMaterial2 = fillerMaterial2;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
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

    public Float getDiameterMmMin() {
        return diameterMmMin;
    }

    public void setDiameterMmMin(Float diameterMmMin) {
        this.diameterMmMin = diameterMmMin;
    }

    public Float getDiameterMmMax() {
        return diameterMmMax;
    }

    public void setDiameterMmMax(Float diameterMmMax) {
        this.diameterMmMax = diameterMmMax;
    }

    public Float getDiameterInchMin() {
        return diameterInchMin;
    }

    public void setDiameterInchMin(Float diameterInchMin) {
        this.diameterInchMin = diameterInchMin;
    }

    public Float getDiameterInchMax() {
        return diameterInchMax;
    }

    public void setDiameterInchMax(Float diameterInchMax) {
        this.diameterInchMax = diameterInchMax;
    }

    public ThicknessUOM getThicknessUom() {
        return thicknessUom;
    }

    public void setThicknessUom(ThicknessUOM thicknessUom) {
        this.thicknessUom = thicknessUom;
    }

    public Float getThicknessMmMin() {
        return thicknessMmMin;
    }

    public void setThicknessMmMin(Float thicknessMmMin) {
        this.thicknessMmMin = thicknessMmMin;
    }

    public Float getThicknessMmMax() {
        return thicknessMmMax;
    }

    public void setThicknessMmMax(Float thicknessMmMax) {
        this.thicknessMmMax = thicknessMmMax;
    }

    @Override
    public String toString() {
        return "ProcessSpecificationProcedure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", procedureFile=" + Arrays.toString(procedureFile) +
                ", processQualificationRecordFile=" + Arrays.toString(processQualificationRecordFile) +
                ", jointDesign='" + jointDesign + '\'' +
                ", baseMaterial1='" + baseMaterial1 + '\'' +
                ", baseMaterial2='" + baseMaterial2 + '\'' +
                ", fusionProcess='" + fusionProcess + '\'' +
                ", fillerMaterial1='" + fillerMaterial1 + '\'' +
                ", fillerMaterial2='" + fillerMaterial2 + '\'' +
                ", standardCode='" + standardCode + '\'' +
                ", isPreheatRequired=" + isPreheatRequired +
                ", isPostWeldHeatTreatmentRequired=" + isPostWeldHeatTreatmentRequired +
                ", diameterMmMin=" + diameterMmMin +
                ", diameterMmMax=" + diameterMmMax +
                ", diameterInchMin=" + diameterInchMin +
                ", diameterInchMax=" + diameterInchMax +
                ", thicknessUom=" + thicknessUom +
                ", thicknessMmMin=" + thicknessMmMin +
                ", thicknessMmMax=" + thicknessMmMax +
                '}';
    }
}
