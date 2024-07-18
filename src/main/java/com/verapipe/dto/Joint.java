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
    private BaseMaterialCertificate baseMaterial1;
    private String fittingDescription2;
    private BaseMaterialType baseMaterialType2;
    private BaseMaterialCertificate baseMaterial2;
    private Float thickness;
    private FillerMaterialType fillerMaterialType1;
    private FillerMaterialCertificate fillerMaterial1;
    private FillerMaterialType fillerMaterialType2;
    private FillerMaterialCertificate fillerMaterial2;
    private ProcessSpecificationProcedure processSpecificationProcedure;
    private Joiner joiner1;
    private Joiner joiner2;
    private Date date;
    private boolean isFitUpDone;
    private boolean isVisualInspectionDone;
    private String ndtReportName;
    private boolean isNdtPassed;
    private Preheat preheat;
    private PostWeldHeatTreatment postWeldHeatTreatment;
    private String comments;

    public Joint() {
    }

    public Joint(int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, UnitOfMeasure uom, String schedule, Float diameter, String fittingDescription1, BaseMaterialType baseMaterialType1, BaseMaterialCertificate baseMaterial1, String fittingDescription2, BaseMaterialType baseMaterialType2, BaseMaterialCertificate baseMaterial2, Float thickness, FillerMaterialType fillerMaterialType1, FillerMaterialCertificate fillerMaterial1, FillerMaterialType fillerMaterialType2, FillerMaterialCertificate fillerMaterial2, ProcessSpecificationProcedure processSpecificationProcedure, Joiner joiner1, Joiner joiner2, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, Preheat preheat, PostWeldHeatTreatment postWeldHeatTreatment, String comments) {
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
        this.baseMaterial1 = baseMaterial1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialType2 = baseMaterialType2;
        this.baseMaterial2 = baseMaterial2;
        this.thickness = thickness;
        this.fillerMaterialType1 = fillerMaterialType1;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterialType2 = fillerMaterialType2;
        this.fillerMaterial2 = fillerMaterial2;
        this.processSpecificationProcedure = processSpecificationProcedure;
        this.joiner1 = joiner1;
        this.joiner2 = joiner2;
        this.date = date;
        this.isFitUpDone = isFitUpDone;
        this.isVisualInspectionDone = isVisualInspectionDone;
        this.ndtReportName = ndtReportName;
        this.isNdtPassed = isNdtPassed;
        this.preheat = preheat;
        this.postWeldHeatTreatment = postWeldHeatTreatment;
        this.comments = comments;
    }

    public Joint(int id, int number, Coordinates coordinatesOnIsometric, String pidName, String isometricName, int sheetOnIsometric, UnitOfMeasure uom, String schedule, Float diameter, String fittingDescription1, BaseMaterialType baseMaterialType1, BaseMaterialCertificate baseMaterial1, String fittingDescription2, BaseMaterialType baseMaterialType2, BaseMaterialCertificate baseMaterial2, Float thickness, FillerMaterialType fillerMaterialType1, FillerMaterialCertificate fillerMaterial1, FillerMaterialType fillerMaterialType2, FillerMaterialCertificate fillerMaterial2, ProcessSpecificationProcedure processSpecificationProcedure, Joiner joiner1, Joiner joiner2, Date date, boolean isFitUpDone, boolean isVisualInspectionDone, String ndtReportName, boolean isNdtPassed, String preheatName, String postWeldHeatTreatmentName, String comments) {
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
        this.baseMaterial1 = baseMaterial1;
        this.fittingDescription2 = fittingDescription2;
        this.baseMaterialType2 = baseMaterialType2;
        this.baseMaterial2 = baseMaterial2;
        this.thickness = thickness;
        this.fillerMaterialType1 = fillerMaterialType1;
        this.fillerMaterial1 = fillerMaterial1;
        this.fillerMaterialType2 = fillerMaterialType2;
        this.fillerMaterial2 = fillerMaterial2;
        this.processSpecificationProcedure = processSpecificationProcedure;
        this.joiner1 = joiner1;
        this.joiner2 = joiner2;
        this.date = date;
        this.isFitUpDone = isFitUpDone;
        this.isVisualInspectionDone = isVisualInspectionDone;
        this.ndtReportName = ndtReportName;
        this.isNdtPassed = isNdtPassed;
        this.preheat = preheat;
        this.postWeldHeatTreatment = postWeldHeatTreatment;
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
        this.baseMaterial1 = new BaseMaterialCertificate(baseMaterialCertificatesEntityList.get(0));
        this.baseMaterial2 = new BaseMaterialCertificate(baseMaterialCertificatesEntityList.get(1));

        this.thickness = jointEntity.getThickness();

        List<FillerMaterialTypeEntity> fillerMaterialTypeEntityList = new ArrayList<>();
        fillerMaterialTypeEntityList.addAll(jointEntity.getFillerMaterialTypeList());
        this.fillerMaterialType1 = new FillerMaterialType(fillerMaterialTypeEntityList.get(0));
        this.fillerMaterialType2 = new FillerMaterialType(fillerMaterialTypeEntityList.get(1));

        List<FillerMaterialCertificateEntity> fillerMaterialCertificateEntityList = new ArrayList<>();
        fillerMaterialCertificateEntityList.addAll(jointEntity.getFillerMaterialCertificateList());
        this.fillerMaterial1 = new FillerMaterialCertificate(fillerMaterialCertificateEntityList.get(0));
        this.fillerMaterial2 = new FillerMaterialCertificate(fillerMaterialCertificateEntityList.get(1));

        this.processSpecificationProcedure = new ProcessSpecificationProcedure(jointEntity.getProcessSpecificationProcedure());

        List<JoinerEntity> joinerEntityList = new ArrayList<>();
        joinerEntityList.addAll(jointEntity.getJoinersList());
        this.joiner1 = new Joiner(joinerEntityList.get(0));
        this.joiner2 = new Joiner(joinerEntityList.get(1));

        this.date = jointEntity.getDate();
        this.isFitUpDone = jointEntity.isFitUpDone();
        this.isVisualInspectionDone = jointEntity.isVisualInspectionDone();
        this.ndtReportName = jointEntity.getNdtReport().getName();
        this.isNdtPassed = jointEntity.getNdtPassed();
        this.preheat = new Preheat(jointEntity.getPreheat());
        this.postWeldHeatTreatment = new PostWeldHeatTreatment(jointEntity.getPostWeldHeatTreatment());
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

    public BaseMaterialCertificate getBaseMaterial1() {
        return baseMaterial1;
    }

    public void setBaseMaterial1(BaseMaterialCertificate baseMaterial1) {
        this.baseMaterial1 = baseMaterial1;
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

    public BaseMaterialCertificate getBaseMaterial2() {
        return baseMaterial2;
    }

    public void setBaseMaterial2(BaseMaterialCertificate baseMaterial2) {
        this.baseMaterial2 = baseMaterial2;
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

    public FillerMaterialCertificate getFillerMaterial1() {
        return fillerMaterial1;
    }

    public void setFillerMaterial1(FillerMaterialCertificate fillerMaterial1) {
        this.fillerMaterial1 = fillerMaterial1;
    }

    public FillerMaterialType getFillerMaterialType2() {
        return fillerMaterialType2;
    }

    public void setFillerMaterialType2(FillerMaterialType fillerMaterialType2) {
        this.fillerMaterialType2 = fillerMaterialType2;
    }

    public FillerMaterialCertificate getFillerMaterial2() {
        return fillerMaterial2;
    }

    public void setFillerMaterial2(FillerMaterialCertificate fillerMaterial2) {
        this.fillerMaterial2 = fillerMaterial2;
    }

    public ProcessSpecificationProcedure getProcessSpecificationProcedure() {
        return processSpecificationProcedure;
    }

    public void setProcessSpecificationProcedure(ProcessSpecificationProcedure processSpecificationProcedure) {
        this.processSpecificationProcedure = processSpecificationProcedure;
    }

    public Joiner getJoiner1() {
        return joiner1;
    }

    public void setJoiner1(Joiner joiner1) {
        this.joiner1 = joiner1;
    }

    public Joiner getJoiner2() {
        return joiner2;
    }

    public void setJoiner2(Joiner joiner2) {
        this.joiner2 = joiner2;
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

    public Preheat getPreheat() {
        return preheat;
    }

    public void setPreheat(Preheat preheat) {
        this.preheat = preheat;
    }

    public PostWeldHeatTreatment getPostWeldHeatTreatment() {
        return postWeldHeatTreatment;
    }

    public void setPostWeldHeatTreatment(PostWeldHeatTreatment postWeldHeatTreatment) {
        this.postWeldHeatTreatment = postWeldHeatTreatment;
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
                ", baseMaterial1=" + baseMaterial1 +
                ", fittingDescription2='" + fittingDescription2 + '\'' +
                ", baseMaterialType2=" + baseMaterialType2 +
                ", baseMaterial2=" + baseMaterial2 +
                ", thickness=" + thickness +
                ", fillerMaterialType1=" + fillerMaterialType1 +
                ", fillerMaterial1=" + fillerMaterial1 +
                ", fillerMaterialType2=" + fillerMaterialType2 +
                ", fillerMaterial2=" + fillerMaterial2 +
                ", processSpecificationProcedure=" + processSpecificationProcedure +
                ", joiner1=" + joiner1 +
                ", joiner2=" + joiner2 +
                ", date=" + date +
                ", isFitUpDone=" + isFitUpDone +
                ", isVisualInspectionDone=" + isVisualInspectionDone +
                ", ndtReportName='" + ndtReportName + '\'' +
                ", isNdtPassed=" + isNdtPassed +
                ", preheat=" + preheat +
                ", postWeldHeatTreatment=" + postWeldHeatTreatment +
                ", comments='" + comments + '\'' +
                '}';
    }
}
