package com.verapipe.entities;

import com.verapipe.dto.Coordinates;
import com.verapipe.dto.Joint;
import com.verapipe.dto.NdtReport;
import com.verapipe.enums.UnitOfMeasure;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "joint")
public class JointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "number", unique = false, nullable = false)
    private int number;
    @Column(name = "coordinates", unique = true, nullable = false)
    private Coordinates coordinatesOnIsometric;
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
    @ManyToMany(mappedBy = "jointEntity")
    @MapKeyJoinColumn(name = "ndt_report_id")
    private Map<NdtReportEntity, Boolean> ndtReports;
    @ManyToOne(fetch = FetchType.EAGER)
    private PreheatEntity preheat;
    @ManyToOne(fetch = FetchType.EAGER)
    private PostWeldHeatTreatmentEntity postWeldHeatTreatment;

    public JointEntity() {
    }

    public JointEntity(Joint joint) {
        this.id = joint.getId();
        this.number = joint.getNumber();
        this.coordinatesOnIsometric = joint.getCoordinatesOnIsometric();
        this.pid = new PidEntity(joint.getPid());
        this.isometric = new IsometricEntity(joint.getIsometric());
        this.sheetOnIsometric = joint.getSheetOnIsometric();
        this.uom = joint.getUom();
        this.schedule = joint.getSchedule();
        this.diameter = joint.getDiameter();
        this.fittingDescription1 = joint.getFittingDescription1();
        this.fittingDescription2 = joint.getFittingDescription2();
        this.thickness = joint.getThickness();
        this.processSpecificationProcedure = new ProcessSpecificationProcedureEntity(joint.getProcessSpecificationProcedure());
        this.date = joint.getDate();
        this.isFitUpDone = joint.isFitUpDone();
        this.isVisualInspectionDone = joint.isVisualInspectionDone();
        this.ndtReports = convertNdtReportsDTOsToEntities(joint.getNdtReports());
        this.preheat = new PreheatEntity(joint.getPreheat());
        this.postWeldHeatTreatment = new PostWeldHeatTreatmentEntity(joint.getPostWeldHeatTreatment());
        this.comments = joint.getComments();

        // Base Material Type List
        if (joint.getBaseMaterialType1() != null) {
            this.baseMaterialTypeList = new HashSet<>();
            this.baseMaterialTypeList.add(new BaseMaterialTypeEntity(joint.getBaseMaterialType1()));
            if (joint.getBaseMaterialType2() != null) {
                this.baseMaterialTypeList.add(new BaseMaterialTypeEntity(joint.getBaseMaterialType2()));
            }
        }

        // Base Material Certificate List
        if (joint.getBaseMaterial1() != null) {
            this.baseMaterialCertificateList = new HashSet<>();
            this.baseMaterialCertificateList.add(new BaseMaterialCertificateEntity(joint.getBaseMaterial1()));
            if (joint.getBaseMaterial2() != null) {
                this.baseMaterialCertificateList.add(new BaseMaterialCertificateEntity(joint.getBaseMaterial2()));
            }
        }

        // Filler Material Type List
        if (joint.getFillerMaterialType1() != null) {
            this.fillerMaterialTypeList = new HashSet<>();
            this.fillerMaterialTypeList.add(new FillerMaterialTypeEntity(joint.getFillerMaterialType1()));
            if (joint.getFillerMaterialType2() != null) {
                this.fillerMaterialTypeList.add(new FillerMaterialTypeEntity(joint.getFillerMaterialType2()));
            }
        }

        // Filler Material Certificate List
        if (joint.getFillerMaterial1() != null) {
            this.fillerMaterialCertificateList = new HashSet<>();
            this.fillerMaterialCertificateList.add(new FillerMaterialCertificateEntity(joint.getFillerMaterial1()));
            if (joint.getFillerMaterial2() != null) {
                this.fillerMaterialCertificateList.add(new FillerMaterialCertificateEntity(joint.getFillerMaterial2()));
            }
        }

        // Joiners List
        if (joint.getJoiner1() != null) {
            this.joinersList = new HashSet<>();
            this.joinersList.add(new JoinerEntity(joint.getJoiner1()));
            if (joint.getJoiner2() != null) {
                this.joinersList.add(new JoinerEntity(joint.getJoiner2()));
            }
        }
    }

    private Map<NdtReportEntity, Boolean> convertNdtReportsDTOsToEntities(Map<NdtReport, Boolean> ndtReportsDTOs) {
        Map<NdtReportEntity, Boolean> ndtReportsEntities = new HashMap<>();
        for (Map.Entry<NdtReport, Boolean> entry : ndtReportsDTOs.entrySet()) {
            NdtReport dto = entry.getKey();
            NdtReportEntity entity = new NdtReportEntity(dto);
            ndtReportsEntities.put(entity, entry.getValue());
        }
        return ndtReportsEntities;
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

    public Map<NdtReportEntity, Boolean> getNdtReports() {
        return ndtReports;
    }

    public void setNdtReports(Map<NdtReportEntity, Boolean> ndtReports) {
        this.ndtReports = ndtReports;
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
