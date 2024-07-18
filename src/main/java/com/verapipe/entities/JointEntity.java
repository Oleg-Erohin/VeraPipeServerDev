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
    @Column(name = "comments", unique = false, nullable = true, columnDefinition = "TEXT")
    private String comments;
    @Column(name = "fitting_description_2", unique = false, nullable = false)
    private String fittingDescription2;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialTypeEntity> baseMaterialTypeList;
    // TODO to make validation that only 2 objects in baseMaterialCertificateList
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialCertificateEntity> baseMaterialCertificateList;
    @Column(name = "thickness", unique = false, nullable = false)
    private Float thickness;
    // TODO to make validation that only 2 objects in fillerMaterialTypeList
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<FillerMaterialTypeEntity> fillerMaterialTypeList;
    // TODO to make validation that only 2 objects in fillerMaterialCertificateList
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
        this.baseMaterialTypeList = new HashSet<>();
        initializeBaseMaterialTypeListWithValues(joint);
        this.baseMaterialCertificateList = new HashSet<>();
        initializeBaseMaterialCertificateListWithValues(joint);
        this.thickness = joint.getThickness();
        this.fittingDescription2 = joint.getFittingDescription2();
        this.fillerMaterialTypeList = new HashSet<>();
        initializeFillerMaterialTypeListWithValues(joint);
        this.fillerMaterialCertificateList = new HashSet<>();
        initializeFillerMaterialCertificateListWithValues(joint);
        this.processSpecificationProcedure = new ProcessSpecificationProcedureEntity(joint.getProcessSpecificationProcedure());
        this.joinersList = new HashSet<>();
        initializeJoinersList(joint.getJoinerTagId1(), joint.getJoinerTagId2());
        this.date = joint.getDate();
        this.isFitUpDone = joint.isFitUpDone();
        this.isVisualInspectionDone = joint.isVisualInspectionDone();
        this.ndtReport = new NdtReportEntity();
        String ndtReportName = joint.getNdtReportName();
        this.ndtReport.setName(ndtReportName);
        this.isNdtPassed = joint.isNdtPassed();
        this.preheat = new PreheatEntity();
        String preheatName = joint.getPreheatName();
        this.preheat.setName(preheatName);
        this.postWeldHeatTreatment = new PostWeldHeatTreatmentEntity();
        String postWeldHeatTreatmentName = joint.getPostWeldHeatTreatmentName();
        this.postWeldHeatTreatment.setName(postWeldHeatTreatmentName);
        this.comments = joint.getComments();
    }

    private void initializeBaseMaterialCertificateListWithValues(Joint joint) {
        BaseMaterialCertificateEntity baseMaterialCertificate1 = new BaseMaterialCertificateEntity();
        BaseMaterialCertificateEntity baseMaterialCertificate2 = new BaseMaterialCertificateEntity();
        String baseMaterialHeatNum1 = joint.getBaseMaterialHeatNum1();
        String baseMaterialHeatNum2 = joint.getBaseMaterialHeatNum2();
        baseMaterialCertificate1.setHeatNum(baseMaterialHeatNum1);
        baseMaterialCertificate2.setHeatNum(baseMaterialHeatNum2);
        this.baseMaterialCertificateList.add(baseMaterialCertificate1);
        this.baseMaterialCertificateList.add(baseMaterialCertificate2);
    }

    private void initializeFillerMaterialCertificateListWithValues(Joint joint) {
        FillerMaterialCertificateEntity fillerMaterialCertificate1 = new FillerMaterialCertificateEntity();
        FillerMaterialCertificateEntity fillerMaterialCertificate2 = new FillerMaterialCertificateEntity();
        String fillerMaterialHeatNum1 = joint.getFillerMaterialHeatNum1();
        String fillerMaterialHeatNum2 = joint.getFillerMaterialHeatNum2();
        fillerMaterialCertificate1.setHeatNum(fillerMaterialHeatNum1);
        fillerMaterialCertificate2.setHeatNum(fillerMaterialHeatNum2);
        this.fillerMaterialCertificateList.add(fillerMaterialCertificate1);
        this.fillerMaterialCertificateList.add(fillerMaterialCertificate2);
    }

    private void initializeBaseMaterialTypeListWithValues(Joint joint) {
        BaseMaterialTypeEntity baseMaterialType1 = new BaseMaterialTypeEntity(joint.getBaseMaterialType1());
        BaseMaterialTypeEntity baseMaterialType2 = new BaseMaterialTypeEntity(joint.getBaseMaterialType2());
        this.baseMaterialTypeList.add(baseMaterialType1);
        this.baseMaterialTypeList.add(baseMaterialType2);
    }

    private void initializeFillerMaterialTypeListWithValues(Joint joint) {
        FillerMaterialTypeEntity fillerMaterialType1 = new FillerMaterialTypeEntity(joint.getFillerMaterialType1());
        FillerMaterialTypeEntity fillerMaterialType2 = new FillerMaterialTypeEntity(joint.getFillerMaterialType2());
        this.fillerMaterialTypeList.add(fillerMaterialType1);
        this.fillerMaterialTypeList.add(fillerMaterialType2);
    }

    private void initializeJoinersList(String joinerTagId1, String joinerTagId2) {
        JoinerEntity joiner1 = new JoinerEntity();
        joiner1.setTagId(joinerTagId1);
        this.joinersList.add(joiner1);

        JoinerEntity joiner2 = new JoinerEntity();
        joiner2.setTagId(joinerTagId2);
        this.joinersList.add(joiner2);
    }

//    private void initializeJoinersList(List<String> joinersTagIdList) {
//        if (!joinersTagIdList.isEmpty()) {
//        JoinerEntity joiner1 = new JoinerEntity();
//        String joiner1TagId = joinersTagIdList.get(0);
//        joiner1.setTagId(joiner1TagId);
//        this.joinersList.set(0, joiner1);
//        // TODO verify if joiner2 is null ??
//        JoinerEntity joiner2 = new JoinerEntity();
//        String joiner2TagId = joinersTagIdList.get(1);
//        joiner2.setTagId(joiner2TagId);
//        this.joinersList.set(1, joiner2);
//        }
//    }


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
