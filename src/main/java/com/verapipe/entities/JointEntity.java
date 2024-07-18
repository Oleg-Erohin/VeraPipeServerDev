package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.dto.Joint;
import com.verapipe.enums.UnitOfMeasure;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "joint")
public class JointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "number", unique = false, nullable = false)
    private int number;
    @Column(name = "coordinates", unique = true, nullable = false)
    private String coordinatesOnIsometric;
    @ManyToOne(fetch = FetchType.EAGER)
    private PidEntity pid;
    @ManyToOne(fetch = FetchType.EAGER)
    private IsometricEntity isometric;
    @Column(name = "sheet_on_isometric", unique = false, nullable = false)
    private int sheetOnIsometric;
    @Column(name = "uom", unique = false, nullable = false)
    private UnitOfMeasure uom;
    @Column(name = "schedule", unique = false, nullable = true)
    private String schedule;
    @Column(name = "diameter", unique = false, nullable = false)
    private Float diameter;
    @Column(name = "fitting_description_1", unique = false, nullable = false)
    private String fittingDescription1;
    @Column(name = "fitting_description_2", unique = false, nullable = false)
    private String fittingDescription2;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialTypeEntity> baseMaterialTypeList;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialCertificateEntity> baseMaterialCertificateList;
    @Column(name = "thickness", unique = false, nullable = false)
    private Float thickness;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<FillerMaterialTypeEntity> fillerMaterialTypeList;
    @ManyToMany
    private Set<FillerMaterialCertificateEntity> fillerMaterialCertificateList;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProcessSpecificationProcedureEntity processSpecificationProcedure;
    @ManyToMany(mappedBy = "jointsList")
    private Set<JoinerEntity> joinersList;
    @Column(name = "date", unique = false, nullable = true)
    private Date date;
    @Column(name = "is_fitup_done", unique = false, nullable = true)
    private boolean isFitUpDone;
    @Column(name = "is_visual_inspection_done", unique = false, nullable = true)
    private boolean isVisualInspectionDone;
    @ManyToOne(fetch = FetchType.EAGER)
    private NdtReportEntity ndtReport;
    @Column(name = "is_ndt_passed", unique = false, nullable = true)
    private Boolean isNdtPassed;
    @ManyToOne(fetch = FetchType.EAGER)
    private PreheatEntity preheat;
    @ManyToOne(fetch = FetchType.EAGER)
    private PostWeldHeatTreatmentEntity postWeldHeatTreatment;
    @Column(name = "comments", unique = false, nullable = true, columnDefinition = "TEXT")
    private String comments;

    public JointEntity() {
    }

    public JointEntity(Joint joint) throws JsonProcessingException {
        this.id = joint.getId();
        this.number = joint.getNumber();
        ObjectMapper objectMapper = new ObjectMapper();
        this.coordinatesOnIsometric = objectMapper.writeValueAsString(joint.getCoordinatesOnIsometric());
        this.pid = new PidEntity();
        String pidName = joint.getPidName();
        this.pid.setName(pidName);
        this.isometric = new IsometricEntity();
        String isometricName = joint.getIsometricName();
        this.isometric.setName(isometricName);
        this.sheetOnIsometric = joint.getSheetOnIsometric();
        this.uom = joint.getUom();
        this.schedule = joint.getSchedule();
        this.diameter = joint.getDiameter();
        this.fittingDescription1 = joint.getFittingDescription1();
        initializeBaseMaterialTypeList(joint);
        this.baseMaterialCertificateList = new HashSet<>();
        initializeBaseMaterialCertificateListWithValues(joint);
        this.thickness = joint.getThickness();
        this.fittingDescription2 = joint.getFittingDescription2();
        initializeFillerMaterialTypeList(joint);
        this.fillerMaterialCertificateList = new HashSet<>();
        initializeFillerMaterialCertificateListWithValues(joint);
        this.processSpecificationProcedure = new ProcessSpecificationProcedureEntity(joint.getProcessSpecificationProcedure());
        initializeJoinersList(joint);
        this.date = joint.getDate();
        this.isFitUpDone = joint.isFitUpDone();
        this.isVisualInspectionDone = joint.isVisualInspectionDone();
        this.ndtReport = new NdtReportEntity();
        String ndtReportName = joint.getNdtReportName();
        this.ndtReport.setName(ndtReportName);
        this.isNdtPassed = joint.isNdtPassed();
        this.preheat = new PreheatEntity(joint.getPreheat());
        this.postWeldHeatTreatment = new PostWeldHeatTreatmentEntity(joint.getPostWeldHeatTreatment());
        this.comments = joint.getComments();
    }

    private void initializeBaseMaterialCertificateListWithValues(Joint joint) {
        BaseMaterialCertificateEntity baseMaterialCertificate1 = new BaseMaterialCertificateEntity(joint.getBaseMaterial1());
        BaseMaterialCertificateEntity baseMaterialCertificate2 = new BaseMaterialCertificateEntity(joint.getBaseMaterial2());
        this.baseMaterialCertificateList.add(baseMaterialCertificate1);
        this.baseMaterialCertificateList.add(baseMaterialCertificate2);
    }

    private void initializeFillerMaterialCertificateListWithValues(Joint joint) {
        FillerMaterialCertificateEntity fillerMaterialCertificate1 = new FillerMaterialCertificateEntity(joint.getFillerMaterial1());
        FillerMaterialCertificateEntity fillerMaterialCertificate2 = new FillerMaterialCertificateEntity(joint.getFillerMaterial2());
        this.fillerMaterialCertificateList.add(fillerMaterialCertificate1);
        this.fillerMaterialCertificateList.add(fillerMaterialCertificate2);
    }

    private void initializeBaseMaterialTypeList(Joint joint) {
        this.baseMaterialTypeList = new HashSet<>();
        BaseMaterialTypeEntity baseMaterialType1 = new BaseMaterialTypeEntity(joint.getBaseMaterialType1());
        BaseMaterialTypeEntity baseMaterialType2 = new BaseMaterialTypeEntity(joint.getBaseMaterialType2());
        this.baseMaterialTypeList.add(baseMaterialType1);
        this.baseMaterialTypeList.add(baseMaterialType2);
    }

    private void initializeFillerMaterialTypeList(Joint joint) {
        this.fillerMaterialTypeList = new HashSet<>();
        FillerMaterialTypeEntity fillerMaterialType1 = new FillerMaterialTypeEntity(joint.getFillerMaterialType1());
        FillerMaterialTypeEntity fillerMaterialType2 = new FillerMaterialTypeEntity(joint.getFillerMaterialType2());
        this.fillerMaterialTypeList.add(fillerMaterialType1);
        this.fillerMaterialTypeList.add(fillerMaterialType2);
    }

    private void initializeJoinersList(Joint joint) {
        this.joinersList = new HashSet<>();
        JoinerEntity joinerEntity1 = new JoinerEntity(joint.getJoiner1());
        JoinerEntity joinerEntity2 = new JoinerEntity(joint.getJoiner2());
        this.joinersList.add(joinerEntity1);
        this.joinersList.add(joinerEntity2);
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

    public String getCoordinatesOnIsometric() {
        return coordinatesOnIsometric;
    }

    public void setCoordinatesOnIsometric(String coordinatesOnIsometric) {
        this.coordinatesOnIsometric = coordinatesOnIsometric;
    }

    public PidEntity getPid() {
        return pid;
    }

    public void setPid(PidEntity pid) {
        this.pid = pid;
    }

    public IsometricEntity getIsometric() {
        return isometric;
    }

    public void setIsometric(IsometricEntity isometric) {
        this.isometric = isometric;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFittingDescription2() {
        return fittingDescription2;
    }

    public void setFittingDescription2(String fittingDescription2) {
        this.fittingDescription2 = fittingDescription2;
    }

    public Set<BaseMaterialTypeEntity> getBaseMaterialTypeList() {
        return baseMaterialTypeList;
    }

    public void setBaseMaterialTypeList(Set<BaseMaterialTypeEntity> baseMaterialTypeList) {
        this.baseMaterialTypeList = baseMaterialTypeList;
    }

    public Set<BaseMaterialCertificateEntity> getBaseMaterialCertificateList() {
        return baseMaterialCertificateList;
    }

    public void setBaseMaterialCertificateList(Set<BaseMaterialCertificateEntity> baseMaterialCertificateList) {
        this.baseMaterialCertificateList = baseMaterialCertificateList;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Set<FillerMaterialTypeEntity> getFillerMaterialTypeList() {
        return fillerMaterialTypeList;
    }

    public void setFillerMaterialTypeList(Set<FillerMaterialTypeEntity> fillerMaterialTypeList) {
        this.fillerMaterialTypeList = fillerMaterialTypeList;
    }

    public Set<FillerMaterialCertificateEntity> getFillerMaterialCertificateList() {
        return fillerMaterialCertificateList;
    }

    public void setFillerMaterialCertificateList(Set<FillerMaterialCertificateEntity> fillerMaterialCertificateList) {
        this.fillerMaterialCertificateList = fillerMaterialCertificateList;
    }

    public ProcessSpecificationProcedureEntity getProcessSpecificationProcedure() {
        return processSpecificationProcedure;
    }

    public void setProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedure) {
        this.processSpecificationProcedure = processSpecificationProcedure;
    }

    public Set<JoinerEntity> getJoinersList() {
        return joinersList;
    }

    public void setJoinersList(Set<JoinerEntity> joinersList) {
        this.joinersList = joinersList;
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

    public NdtReportEntity getNdtReport() {
        return ndtReport;
    }

    public void setNdtReport(NdtReportEntity ndtReport) {
        this.ndtReport = ndtReport;
    }

    public Boolean getNdtPassed() {
        return isNdtPassed;
    }

    public void setNdtPassed(Boolean ndtPassed) {
        isNdtPassed = ndtPassed;
    }

    public PreheatEntity getPreheat() {
        return preheat;
    }

    public void setPreheat(PreheatEntity preheat) {
        this.preheat = preheat;
    }

    public PostWeldHeatTreatmentEntity getPostWeldHeatTreatment() {
        return postWeldHeatTreatment;
    }

    public void setPostWeldHeatTreatment(PostWeldHeatTreatmentEntity postWeldHeatTreatment) {
        this.postWeldHeatTreatment = postWeldHeatTreatment;
    }
}
