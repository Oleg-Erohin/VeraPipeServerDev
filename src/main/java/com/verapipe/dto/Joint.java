package com.verapipe.dto;

import java.util.Date;
import java.util.List;

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
    private String baseMaterialTypeName1;
    private String baseMaterialHeatNum1;
    private String fittingDescription2;
    private String baseMaterialTypeName2;
    private String baseMaterialHeatNum2;
    private String fillerMaterialTypeName1;
    private String fillerMaterialHeatNum1;
    private String fillerMaterialTypeName2;
    private String fillerMaterialHeatNum2;
    private String processSpecificationProcedureName;
//    private String joinerTagId1;
//    private String joinerTagId2;
    private List<String> joinersTagIdList;
    private Date date;
    private boolean isFitUpDone;
    private boolean isVisualInspectionDone;
    private String ndtReportName;
    private boolean isNdtPassed;
    private String preheatName;
    private String postWeldHeatTreatmentName;
    private String comments;

    public Joint() {
    }

    public Joint(int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, Float diameterMm, Float diameterInch, String fittingDescription1, String baseMaterialTypeName1, String baseMaterialHeatNum1, String fittingDescription2, String baseMaterialTypeName2, String baseMaterialHeatNum2, String fillerMaterialTypeName1, String fillerMaterialHeatNum1, String fillerMaterialTypeName2, String fillerMaterialHeatNum2, String processSpecificationProcedureName,List<String> joinersTagIdList, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName, String comments) {
        this.number = number;
        this.coordinatesOnIsometric = coordinatesOnIsometric;
        this.pidName = pidName;
        this.isometricName = isometricName;
        this.sheetOnIsometric = sheetOnIsometric;
        this.diameterMm = diameterMm;
        this.diameterInch = diameterInch;
        this.fittingDescription1 = fittingDescription1;
        this.baseMaterialTypeName1 = baseMaterialTypeName1;
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialTypeName2 = baseMaterialTypeName2;
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
        this.fillerMaterialTypeName1 = fillerMaterialTypeName1;
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
        this.fillerMaterialTypeName2 = fillerMaterialTypeName2;
        this.fillerMaterialHeatNum2 = fillerMaterialHeatNum2;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.joinersTagIdList = joinersTagIdList;
        this.date = date;
        this.isFitUpDone = isFitUpDone;
        this.isVisualInspectionDone = isVisualInspectionDone;
        this.ndtReportName = ndtReportName;
        this.isNdtPassed = isNdtPassed;
        this.preheatName = preheatName;
        this.postWeldHeatTreatmentName = postWeldHeatTreatmentName;
        this.comments = comments;
    }

    public Joint(int id, int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, Float diameterMm, Float diameterInch, String fittingDescription1, String baseMaterialTypeName1, String baseMaterialHeatNum1, String fittingDescription2, String baseMaterialTypeName2, String baseMaterialHeatNum2, String fillerMaterialTypeName1, String fillerMaterialHeatNum1, String fillerMaterialTypeName2, String fillerMaterialHeatNum2, String processSpecificationProcedureName, List<String> joinersTagIdList, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName, String comments) {
        this.id = id;
        this.number = number;
        this.coordinatesOnIsometric = coordinatesOnIsometric;
        this.pidName = pidName;
        this.isometricName = isometricName;
        this.sheetOnIsometric = sheetOnIsometric;
        this.diameterMm = diameterMm;
        this.diameterInch = diameterInch;
        this.fittingDescription1 = fittingDescription1;
        this.baseMaterialTypeName1 = baseMaterialTypeName1;
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialTypeName2 = baseMaterialTypeName2;
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
        this.fillerMaterialTypeName1 = fillerMaterialTypeName1;
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
        this.fillerMaterialTypeName2 = fillerMaterialTypeName2;
        this.fillerMaterialHeatNum2 = fillerMaterialHeatNum2;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.joinersTagIdList = joinersTagIdList;
        this.date = date;
        this.isFitUpDone = isFitUpDone;
        this.isVisualInspectionDone = isVisualInspectionDone;
        this.ndtReportName = ndtReportName;
        this.isNdtPassed = isNdtPassed;
        this.preheatName = preheatName;
        this.postWeldHeatTreatmentName = postWeldHeatTreatmentName;
        this.comments = comments;
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

    public String getBaseMaterialTypeName1() {
        return baseMaterialTypeName1;
    }

    public void setBaseMaterialTypeName1(String baseMaterialTypeName1) {
        this.baseMaterialTypeName1 = baseMaterialTypeName1;
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

    public String getBaseMaterialTypeName2() {
        return baseMaterialTypeName2;
    }

    public void setBaseMaterialTypeName2(String baseMaterialTypeName2) {
        this.baseMaterialTypeName2 = baseMaterialTypeName2;
    }

    public String getBaseMaterialHeatNum2() {
        return baseMaterialHeatNum2;
    }

    public void setBaseMaterialHeatNum2(String baseMaterialHeatNum2) {
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
    }

    public String getFillerMaterialTypeName1() {
        return fillerMaterialTypeName1;
    }

    public void setFillerMaterialTypeName1(String fillerMaterialTypeName1) {
        this.fillerMaterialTypeName1 = fillerMaterialTypeName1;
    }

    public String getFillerMaterialHeatNum1() {
        return fillerMaterialHeatNum1;
    }

    public void setFillerMaterialHeatNum1(String fillerMaterialHeatNum1) {
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
    }

    public String getFillerMaterialTypeName2() {
        return fillerMaterialTypeName2;
    }

    public void setFillerMaterialTypeName2(String fillerMaterialTypeName2) {
        this.fillerMaterialTypeName2 = fillerMaterialTypeName2;
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

    public List<String> getJoinersTagIdList() {
        return joinersTagIdList;
    }

    public void setJoinersTagIdList(List<String> joinersTagIdList) {
        this.joinersTagIdList = joinersTagIdList;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
                ", baseMaterialTypeName1='" + baseMaterialTypeName1 + '\'' +
                ", baseMaterialHeatNum1='" + baseMaterialHeatNum1 + '\'' +
                ", fittingDescription2='" + fittingDescription2 + '\'' +
                ", baseMaterialTypeName2='" + baseMaterialTypeName2 + '\'' +
                ", baseMaterialHeatNum2='" + baseMaterialHeatNum2 + '\'' +
                ", fillerMaterialTypeName1='" + fillerMaterialTypeName1 + '\'' +
                ", fillerMaterialHeatNum1='" + fillerMaterialHeatNum1 + '\'' +
                ", fillerMaterialTypeName2='" + fillerMaterialTypeName2 + '\'' +
                ", fillerMaterialHeatNum2='" + fillerMaterialHeatNum2 + '\'' +
                ", processSpecificationProcedureName='" + processSpecificationProcedureName + '\'' +
                ", joinersTagIdList=" + joinersTagIdList +
                ", date=" + date +
                ", isFitUpDone=" + isFitUpDone +
                ", isVisualInspectionDone=" + isVisualInspectionDone +
                ", ndtReportName='" + ndtReportName + '\'' +
                ", isNdtPassed=" + isNdtPassed +
                ", preheatName='" + preheatName + '\'' +
                ", postWeldHeatTreatmentName='" + postWeldHeatTreatmentName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
