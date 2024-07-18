package com.verapipe.entities;

import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.enums.UnitOfMeasure;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "process_specification_procedure")
public class ProcessSpecificationProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "is_preheat_required", unique = false, nullable = false)
    private boolean isPreheatRequired;
    @Column(name = "is_post_weld_heat_treatment_required", unique = false, nullable = false)
    private boolean isPostWeldHeatTreatmentRequired;
    @Column(name = "diameter_mm_min", unique = false, nullable = true)
    private Float diameterMmMin;
    @Column(name = "diameter_mm_max", unique = false, nullable = true)
    private Float diameterMmMax;
    @Column(name = "diameter_inch_min", unique = false, nullable = true)
    private Float diameterInchMin;
    @Column(name = "diameter_inch_max", unique = false, nullable = true)
    private Float diameterInchMax;
    @Column(name = "thickness_uom", unique = false, nullable = false)
    private UnitOfMeasure unitOfMeasure;
    @Column(name = "thickness_mm_min", unique = false, nullable = true)
    private Float thicknessMmMin;
    @Column(name = "thickness_mm_max", unique = false, nullable = true)
    private Float thicknessMmMax;
    @ManyToOne(fetch = FetchType.EAGER)
    private JointDesignEntity jointDesign;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialTypeEntity> baseMaterialTypeList;
    @ManyToOne(fetch = FetchType.EAGER)
    private FusionProcessEntity fusionProcess;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<FillerMaterialTypeEntity> fillerMaterialTypeList;
    @ManyToOne(fetch = FetchType.EAGER)
    private StandardCodeEntity standardCode;
    @OneToMany(mappedBy = "processSpecificationProcedure", fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;
    @OneToMany(mappedBy = "processSpecificationProcedure", fetch = FetchType.LAZY)
    private List<PreheatEntity> PreheatReportsList;
    @OneToMany(mappedBy = "processSpecificationProcedure", fetch = FetchType.LAZY)
    private List<PostWeldHeatTreatmentEntity> PostWeldHeatTreatmentsList;

    public ProcessSpecificationProcedureEntity() {
    }

    public ProcessSpecificationProcedureEntity(ProcessSpecificationProcedure processSpecificationProcedure) {
        this.id = processSpecificationProcedure.getId();
        this.name = processSpecificationProcedure.getName();
        this.isPreheatRequired = processSpecificationProcedure.isPreheatRequired();
        this.isPostWeldHeatTreatmentRequired = processSpecificationProcedure.isPostWeldHeatTreatmentRequired();
        this.diameterMmMin = processSpecificationProcedure.getDiameterMinMm();
        this.diameterMmMax = processSpecificationProcedure.getDiameterMaxMm();
        this.diameterInchMin = processSpecificationProcedure.getDiameterMinInch();
        this.diameterInchMax = processSpecificationProcedure.getDiameterMaxInch();
        this.unitOfMeasure = processSpecificationProcedure.getUnitOfMeasure();
        this.thicknessMmMin = processSpecificationProcedure.getThicknessMinMm();
        this.thicknessMmMax = processSpecificationProcedure.getThicknessMaxMm();
        this.jointDesign = new JointDesignEntity();
        String jointDesignName = processSpecificationProcedure.getJointDesignName();
        this.jointDesign.setName(jointDesignName);
        this.baseMaterialTypeList = new HashSet<>();
        initializeBaseMaterialListWithValues(processSpecificationProcedure);
        this.fusionProcess = new FusionProcessEntity();
        String fusionProcessName = processSpecificationProcedure.getFusionProcessName();
        this.fusionProcess.setName(fusionProcessName);
        this.fillerMaterialTypeList = new HashSet<>();
        initializeFillerMaterialTypeListWithValues(processSpecificationProcedure);
        this.standardCode = new StandardCodeEntity();
        String standardCodeName = processSpecificationProcedure.getStandardCodeName();
        this.standardCode.setName(standardCodeName);
    }

    private void initializeFillerMaterialTypeListWithValues(ProcessSpecificationProcedure processSpecificationProcedure) {
        FillerMaterialTypeEntity fillerMaterial1 = new FillerMaterialTypeEntity(processSpecificationProcedure.getFillerMaterial1());
        FillerMaterialTypeEntity fillerMaterial2 = new FillerMaterialTypeEntity(processSpecificationProcedure.getFillerMaterial2());
        this.fillerMaterialTypeList.add(fillerMaterial1);
        this.fillerMaterialTypeList.add(fillerMaterial2);
    }

    private void initializeBaseMaterialListWithValues(ProcessSpecificationProcedure processSpecificationProcedure) {
        BaseMaterialTypeEntity baseMaterial1 = new BaseMaterialTypeEntity(processSpecificationProcedure.getBaseMaterial1());
        BaseMaterialTypeEntity baseMaterial2 = new BaseMaterialTypeEntity(processSpecificationProcedure.getBaseMaterial2());
        this.baseMaterialTypeList.add(baseMaterial1);
        this.baseMaterialTypeList.add(baseMaterial2);
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

    public UnitOfMeasure getThicknessUom() {
        return unitOfMeasure;
    }

    public void setThicknessUom(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
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

    public JointDesignEntity getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(JointDesignEntity jointDesign) {
        this.jointDesign = jointDesign;
    }

    public Set<BaseMaterialTypeEntity> getBaseMaterialTypeList() {
        return baseMaterialTypeList;
    }

    public void setBaseMaterialTypeList(Set<BaseMaterialTypeEntity> baseMaterialTypeList) {
        this.baseMaterialTypeList = baseMaterialTypeList;
    }

    public FusionProcessEntity getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(FusionProcessEntity fusionProcess) {
        this.fusionProcess = fusionProcess;
    }

    public Set<FillerMaterialTypeEntity> getFillerMaterialTypeList() {
        return fillerMaterialTypeList;
    }

    public void setFillerMaterialTypeList(Set<FillerMaterialTypeEntity> fillerMaterialTypeList) {
        this.fillerMaterialTypeList = fillerMaterialTypeList;
    }

    public StandardCodeEntity getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(StandardCodeEntity standardCode) {
        this.standardCode = standardCode;
    }

    public List<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        JointsList = jointsList;
    }

    public List<PreheatEntity> getPreheatReportsList() {
        return PreheatReportsList;
    }

    public void setPreheatReportsList(List<PreheatEntity> preheatReportsList) {
        PreheatReportsList = preheatReportsList;
    }

    public List<PostWeldHeatTreatmentEntity> getPostWeldHeatTreatmentsList() {
        return PostWeldHeatTreatmentsList;
    }

    public void setPostWeldHeatTreatmentsList(List<PostWeldHeatTreatmentEntity> postWeldHeatTreatmentsList) {
        PostWeldHeatTreatmentsList = postWeldHeatTreatmentsList;
    }
}
