package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.entities.*;
import com.verapipe.enums.UnitOfMeasure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Joint {
    private int id;
    private int number;
    private Coordinates coordinatesOnIsometric;
    private String pidName;
    private String isometricName;
    private int sheetOnIsometric;
    private UnitOfMeasure uom;
    private String schedule;
    private Float diameter;
    private String fittingDescription1;
    private BaseMaterialType baseMaterialType1;
    private String baseMaterialHeatNum1;
    private String fittingDescription2;
    private BaseMaterialType baseMaterialType2;
    private String baseMaterialHeatNum2;
    private Float thickness;
    private FillerMaterialType fillerMaterialType1;
    private String fillerMaterialHeatNum1;
    private FillerMaterialType fillerMaterialType2;
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
    private String comments;

    public Joint() {
    }

    public Joint(int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, UnitOfMeasure uom, String schedule, Float diameter, String fittingDescription1, BaseMaterialType baseMaterialType1, String baseMaterialHeatNum1, String fittingDescription2, BaseMaterialType baseMaterialType2, String baseMaterialHeatNum2, Float thickness, FillerMaterialType fillerMaterialType1, String fillerMaterialHeatNum1, FillerMaterialType fillerMaterialType2, String fillerMaterialHeatNum2, String processSpecificationProcedureName, String joinerTagId1, String joinerTagId2, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName, String comments) {
        this.number = number;
        this.coordinatesOnIsometric = coordinatesOnIsometric;
        this.pidName = pidName;
        this.isometricName = isometricName;
        this.sheetOnIsometric = sheetOnIsometric;
        this.uom = uom;
        this.schedule = schedule;
        this.diameter = diameter;
        this.fittingDescription1 = fittingDescription1;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialType2 = baseMaterialType2;
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
        this.thickness = thickness;
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
        this.comments = comments;
    }

    public Joint(int id, int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, UnitOfMeasure uom, String schedule, Float diameter, String fittingDescription1, BaseMaterialType baseMaterialType1, String baseMaterialHeatNum1, String fittingDescription2, BaseMaterialType baseMaterialType2, String baseMaterialHeatNum2, Float thickness, FillerMaterialType fillerMaterialType1, String fillerMaterialHeatNum1, FillerMaterialType fillerMaterialType2, String fillerMaterialHeatNum2, String processSpecificationProcedureName, String joinerTagId1, String joinerTagId2, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName, String comments) {
        this.id = id;
        this.number = number;
        this.coordinatesOnIsometric = coordinatesOnIsometric;
        this.pidName = pidName;
        this.isometricName = isometricName;
        this.sheetOnIsometric = sheetOnIsometric;
        this.uom = uom;
        this.schedule = schedule;
        this.diameter = diameter;
        this.fittingDescription1 = fittingDescription1;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialHeatNum1 = baseMaterialHeatNum1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialType2 = baseMaterialType2;
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
        this.thickness = thickness;
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
        this.comments = comments;
    }

    public Joint(JointEntity jointEntity) throws JsonProcessingException {
        this.id = jointEntity.getId();
        this.number = jointEntity.getNumber();

        ObjectMapper objectMapper = new ObjectMapper();
        this.coordinatesOnIsometric = objectMapper.readValue(jointEntity.getCoordinatesOnIsometric(), new TypeReference<Coordinates>() {
        });

        this.pidName = jointEntity.getPid().getName();
        this.isometricName = jointEntity.getIsometric().getName();
        this.sheetOnIsometric = jointEntity.getSheetOnIsometric();
        this.uom = jointEntity.getUom();
        this.schedule = jointEntity.getSchedule();
        this.diameter = jointEntity.getDiameter();
        this.fittingDescription1 = jointEntity.getFittingDescription1();
        this.fittingDescription2 = jointEntity.getFittingDescription2();

        List<BaseMaterialTypeEntity> baseMaterialTypesEntityList = new ArrayList<>();
        baseMaterialTypesEntityList.addAll(jointEntity.getBaseMaterialTypeList());
        this.baseMaterialType1 = new BaseMaterialType(baseMaterialTypesEntityList.get(0));
        this.baseMaterialType2 = new BaseMaterialType(baseMaterialTypesEntityList.get(1));

        List<BaseMaterialCertificateEntity> baseMaterialCertificatesEntityList = new ArrayList<>();
        baseMaterialCertificatesEntityList.addAll(jointEntity.getBaseMaterialCertificateList());
        this.baseMaterialHeatNum1 = baseMaterialCertificatesEntityList.get(0).getHeatNum();
        this.baseMaterialHeatNum2 = baseMaterialCertificatesEntityList.get(1).getHeatNum();

        this.thickness = jointEntity.getThickness();

        List<FillerMaterialTypeEntity> fillerMaterialTypeEntityList = new ArrayList<>();
        fillerMaterialTypeEntityList.addAll(jointEntity.getFillerMaterialTypeList());
        this.fillerMaterialType1 = new FillerMaterialType(fillerMaterialTypeEntityList.get(0));
        this.fillerMaterialType2 = new FillerMaterialType(fillerMaterialTypeEntityList.get(1));

        List<FillerMaterialCertificateEntity> fillerMaterialCertificateEntityList = new ArrayList<>();
        fillerMaterialCertificateEntityList.addAll(jointEntity.getFillerMaterialCertificateList());
        this.fillerMaterialHeatNum1 = fillerMaterialCertificateEntityList.get(0).getHeatNum();
        this.fillerMaterialHeatNum2 = fillerMaterialCertificateEntityList.get(1).getHeatNum();

        this.processSpecificationProcedureName = jointEntity.getProcessSpecificationProcedure().getName();

        List<JoinerEntity> joinerEntityList = new ArrayList<>();
        joinerEntityList.addAll(jointEntity.getJoinersList());

        List<String> joinersTagIdList = new ArrayList<>();
        for (JoinerEntity joinerEntity : joinerEntityList) {
            joinersTagIdList.add(joinerEntity.getTagId());
        }
        this.joinerTagId1 = joinersTagIdList.get(0);
        this.joinerTagId2 = joinersTagIdList.get(1);

        this.date = jointEntity.getDate();
        this.isFitUpDone = jointEntity.isFitUpDone();
        this.isVisualInspectionDone = jointEntity.isVisualInspectionDone();
        this.ndtReportName = jointEntity.getNdtReport().getName();
        this.isNdtPassed = jointEntity.getNdtPassed();
        this.preheatName = jointEntity.getPreheat().getName();
        this.postWeldHeatTreatmentName = jointEntity.getPostWeldHeatTreatment().getName();
        this.comments = jointEntity.getComments();
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

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public String getFittingDescription1() {
        return fittingDescription1;
    }

    public void setFittingDescription1(String fittingDescription1) {
        this.fittingDescription1 = fittingDescription1;
    }

    public BaseMaterialType getBaseMaterialType1() {
        return baseMaterialType1;
    }

    public void setBaseMaterialType1(BaseMaterialType baseMaterialType1) {
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

    public BaseMaterialType getBaseMaterialType2() {
        return baseMaterialType2;
    }

    public void setBaseMaterialType2(BaseMaterialType baseMaterialType2) {
        this.baseMaterialType2 = baseMaterialType2;
    }

    public String getBaseMaterialHeatNum2() {
        return baseMaterialHeatNum2;
    }

    public void setBaseMaterialHeatNum2(String baseMaterialHeatNum2) {
        this.baseMaterialHeatNum2 = baseMaterialHeatNum2;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public FillerMaterialType getFillerMaterialType1() {
        return fillerMaterialType1;
    }

    public void setFillerMaterialType1(FillerMaterialType fillerMaterialType1) {
        this.fillerMaterialType1 = fillerMaterialType1;
    }

    public String getFillerMaterialHeatNum1() {
        return fillerMaterialHeatNum1;
    }

    public void setFillerMaterialHeatNum1(String fillerMaterialHeatNum1) {
        this.fillerMaterialHeatNum1 = fillerMaterialHeatNum1;
    }

    public FillerMaterialType getFillerMaterialType2() {
        return fillerMaterialType2;
    }

    public void setFillerMaterialType2(FillerMaterialType fillerMaterialType2) {
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
        isNdtPassed = ndtPassed;
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
                ", uom=" + uom +
                ", schedule='" + schedule + '\'' +
                ", diameter=" + diameter +
                ", fittingDescription1='" + fittingDescription1 + '\'' +
                ", baseMaterialType1=" + baseMaterialType1 +
                ", baseMaterialHeatNum1='" + baseMaterialHeatNum1 + '\'' +
                ", fittingDescription2='" + fittingDescription2 + '\'' +
                ", baseMaterialType2=" + baseMaterialType2 +
                ", baseMaterialHeatNum2='" + baseMaterialHeatNum2 + '\'' +
                ", thickness=" + thickness +
                ", fillerMaterialType1=" + fillerMaterialType1 +
                ", fillerMaterialHeatNum1='" + fillerMaterialHeatNum1 + '\'' +
                ", fillerMaterialType2=" + fillerMaterialType2 +
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
                ", comments='" + comments + '\'' +
                '}';
    }
}
