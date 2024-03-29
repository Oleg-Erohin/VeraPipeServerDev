package com.verapipe.dto;

import java.util.Date;

public class Joint {
    private int id;
    private int number;
    private Coordinates coordinatesOnIsometric;
    private String pidName;
    private String isometricName;
    private int sheetOnIsometric;
    private Float diameterMm;
    private Float diameterInch;
    private String fittingDescription1;
    private String baseMaterialType1;
    private String baseMaterialHeatNum1;
    private String fittingDescription2;
    private String baseMaterialType2;
    private String baseMaterialHeatNum2;
    private String fillerMaterialType1;
    private String fillerMaterialHeatNum1;
    private String fillerMaterialType2;
    private String fillerMaterialHeatNum2;
    private String processSpecificationProcedureName;
    private String joinerTagId1;
    private String joinerTagId2;
    private Date date;
    private boolean isFitUpDone;
    private boolean isVisualInspectionDone;
    private String ndtReportName;
    private boolean isNdtPassed;
    private String preheatName;
    private String postWeldHeatTreatmentName;

    public Joint() {
    }

    public Joint(int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, Float diameterMm, Float diameterInch, String fittingDescription1, String baseMaterialType1, String baseMaterialHeatNum1, String fittingDescription2, String baseMaterialType2, String baseMaterialHeatNum2, String fillerMaterialType1, String fillerMaterialHeatNum1, String fillerMaterialType2, String fillerMaterialHeatNum2, String processSpecificationProcedureName, String joinerTagId1, String joinerTagId2, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName) {
        this.number = number;
        this.coordinatesOnIsometric = coordinatesOnIsometric;
        this.pidName = pidName;
        this.isometricName = isometricName;
        this.sheetOnIsometric = sheetOnIsometric;
        this.diameterMm = diameterMm;
        this.diameterInch = diameterInch;
        this.fittingDescription1 = fittingDescription1;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialType2 = baseMaterialType2;
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
        this.fillerMaterialType1 = fillerMaterialType1;
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
        this.fillerMaterialType2 = fillerMaterialType2;
        this.fillerMaterialHeatNum2 = fillerMaterialHeatNum2;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.joinerTagId1 = joinerTagId1;
        this.joinerTagId2 = joinerTagId2;
        this.date = date;
        this.isFitUpDone = isFitUpDone;
        this.isVisualInspectionDone = isVisualInspectionDone;
        this.ndtReportName = ndtReportName;
        this.isNdtPassed = isNdtPassed;
        this.preheatName = preheatName;
        this.postWeldHeatTreatmentName = postWeldHeatTreatmentName;
    }

    public Joint(int id, int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, Float diameterMm, Float diameterInch, String fittingDescription1, String baseMaterialType1, String baseMaterialHeatNum1, String fittingDescription2, String baseMaterialType2, String baseMaterialHeatNum2, String fillerMaterialType1, String fillerMaterialHeatNum1, String fillerMaterialType2, String fillerMaterialHeatNum2, String processSpecificationProcedureName, String joinerTagId1, String joinerTagId2, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName) {
        this.id = id;
        this.number = number;
        this.coordinatesOnIsometric = coordinatesOnIsometric;
        this.pidName = pidName;
        this.isometricName = isometricName;
        this.sheetOnIsometric = sheetOnIsometric;
        this.diameterMm = diameterMm;
        this.diameterInch = diameterInch;
        this.fittingDescription1 = fittingDescription1;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialType2 = baseMaterialType2;
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
        this.fillerMaterialType1 = fillerMaterialType1;
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
        this.fillerMaterialType2 = fillerMaterialType2;
        this.fillerMaterialHeatNum2 = fillerMaterialHeatNum2;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.joinerTagId1 = joinerTagId1;
        this.joinerTagId2 = joinerTagId2;
        this.date = date;
        this.isFitUpDone = isFitUpDone;
        this.isVisualInspectionDone = isVisualInspectionDone;
        this.ndtReportName = ndtReportName;
        this.isNdtPassed = isNdtPassed;
        this.preheatName = preheatName;
        this.postWeldHeatTreatmentName = postWeldHeatTreatmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Coordinates getCoordinatesOnIsometric() {
        return coordinatesOnIsometric;
    }

    public void setCoordinatesOnIsometric(Coordinates coordinatesOnIsometric) {
        this.coordinatesOnIsometric = coordinatesOnIsometric;
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
    }

    public String getIsometricName() {
        return isometricName;
    }

    public void setIsometricName(String isometricName) {
        this.isometricName = isometricName;
    }

    public int getSheetOnIsometric() {
        return sheetOnIsometric;
    }

    public void setSheetOnIsometric(int sheetOnIsometric) {
        this.sheetOnIsometric = sheetOnIsometric;
    }

    public Float getDiameterMm() {
        return diameterMm;
    }

    public void setDiameterMm(Float diameterMm) {
        this.diameterMm = diameterMm;
    }

    public Float getDiameterInch() {
        return diameterInch;
    }

    public void setDiameterInch(Float diameterInch) {
        this.diameterInch = diameterInch;
    }

    public String getFittingDescription1() {
        return fittingDescription1;
    }

    public void setFittingDescription1(String fittingDescription1) {
        this.fittingDescription1 = fittingDescription1;
    }

    public String getBaseMaterialType1() {
        return baseMaterialType1;
    }

    public void setBaseMaterialType1(String baseMaterialType1) {
        this.baseMaterialType1 = baseMaterialType1;
    }

    public String getBaseMaterialHeatNum1() {
        return baseMaterialHeatNum1;
    }

    public void setBaseMaterialHeatNum1(String baseMaterialHeatNum1) {
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
    }

    public String getFittingDescription2() {
        return fittingDescription2;
    }

    public void setFittingDescription2(String fittingDescription2) {
        this.fittingDescription2 = fittingDescription2;
    }

    public String getBaseMaterialType2() {
        return baseMaterialType2;
    }

    public void setBaseMaterialType2(String baseMaterialType2) {
        this.baseMaterialType2 = baseMaterialType2;
    }

    public String getBaseMaterialHeatNum2() {
        return baseMaterialHeatNum2;
    }

    public void setBaseMaterialHeatNum2(String baseMaterialHeatNum2) {
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
    }

    public String getFillerMaterialType1() {
        return fillerMaterialType1;
    }

    public void setFillerMaterialType1(String fillerMaterialType1) {
        this.fillerMaterialType1 = fillerMaterialType1;
    }

    public String getFillerMaterialHeatNum1() {
        return fillerMaterialHeatNum1;
    }

    public void setFillerMaterialHeatNum1(String fillerMaterialHeatNum1) {
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
    }

    public String getFillerMaterialType2() {
        return fillerMaterialType2;
    }

    public void setFillerMaterialType2(String fillerMaterialType2) {
        this.fillerMaterialType2 = fillerMaterialType2;
    }

    public String getFillerMaterialHeatNum2() {
        return fillerMaterialHeatNum2;
    }

    public void setFillerMaterialHeatNum2(String fillerMaterialHeatNum2) {
        this.fillerMaterialHeatNum2 = fillerMaterialHeatNum2;
    }

    public String getProcessSpecificationProcedureName() {
        return processSpecificationProcedureName;
    }

    public void setProcessSpecificationProcedureName(String processSpecificationProcedureName) {
        this.processSpecificationProcedureName = processSpecificationProcedureName;
    }

    public String getJoinerTagId1() {
        return joinerTagId1;
    }

    public void setJoinerTagId1(String joinerTagId1) {
        this.joinerTagId1 = joinerTagId1;
    }

    public String getJoinerTagId2() {
        return joinerTagId2;
    }

    public void setJoinerTagId2(String joinerTagId2) {
        this.joinerTagId2 = joinerTagId2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isFitUpDone() {
        return isFitUpDone;
    }

    public void setFitUpDone(boolean fitUpDone) {
        isFitUpDone = fitUpDone;
    }

    public boolean isVisualInspectionDone() {
        return isVisualInspectionDone;
    }

    public void setVisualInspectionDone(boolean visualInspectionDone) {
        isVisualInspectionDone = visualInspectionDone;
    }

    public String getNdtReportName() {
        return ndtReportName;
    }

    public void setNdtReportName(String ndtReportName) {
        this.ndtReportName = ndtReportName;
    }

    public boolean isNdtPassed() {
        return isNdtPassed;
    }

    public void setNdtPassed(boolean ndtPassed) {
        this.isNdtPassed = ndtPassed;
    }

    public String getPreheatName() {
        return preheatName;
    }

    public void setPreheatName(String preheatName) {
        this.preheatName = preheatName;
    }

    public String getPostWeldHeatTreatmentName() {
        return postWeldHeatTreatmentName;
    }

    public void setPostWeldHeatTreatmentName(String postWeldHeatTreatmentName) {
        this.postWeldHeatTreatmentName = postWeldHeatTreatmentName;
    }

    @Override
    public String toString() {
        return "Joint{" +
                "id=" + id +
                ", number=" + number +
                ", coordinatesOnIsometric=" + coordinatesOnIsometric +
                ", pidName='" + pidName + '\'' +
                ", isometricName='" + isometricName + '\'' +
                ", sheetOnIsometric=" + sheetOnIsometric +
                ", diameterMm=" + diameterMm +
                ", diameterInch=" + diameterInch +
                ", fittingDescription1='" + fittingDescription1 + '\'' +
                ", baseMaterialType1='" + baseMaterialType1 + '\'' +
                ", baseMaterialHeatNum1='" + baseMaterialHeatNum1 + '\'' +
                ", fittingDescription2='" + fittingDescription2 + '\'' +
                ", baseMaterialType2='" + baseMaterialType2 + '\'' +
                ", baseMaterialHeatNum2='" + baseMaterialHeatNum2 + '\'' +
                ", fillerMaterialType1='" + fillerMaterialType1 + '\'' +
                ", fillerMaterialHeatNum1='" + fillerMaterialHeatNum1 + '\'' +
                ", fillerMaterialType2='" + fillerMaterialType2 + '\'' +
                ", fillerMaterialHeatNum2='" + fillerMaterialHeatNum2 + '\'' +
                ", processSpecificationProcedureName='" + processSpecificationProcedureName + '\'' +
                ", joinerTagId1='" + joinerTagId1 + '\'' +
                ", joinerTagId2='" + joinerTagId2 + '\'' +
                ", date=" + date +
                ", isFitUpDone=" + isFitUpDone +
                ", isVisualInspectionDone=" + isVisualInspectionDone +
                ", ndtReportName='" + ndtReportName + '\'' +
                ", isNdtPassed=" + isNdtPassed +
                ", preheatName='" + preheatName + '\'' +
                ", postWeldHeatTreatmentName='" + postWeldHeatTreatmentName + '\'' +
                '}';
    }
}
