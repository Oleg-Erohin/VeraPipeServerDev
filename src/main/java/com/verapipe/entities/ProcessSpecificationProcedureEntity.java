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
    @Column(name = "thickness_uom", unique = false, nullable = false)
    private UnitOfMeasure unitOfMeasure;
    @Column(name = "diameter_min", unique = false, nullable = true)
    private Float diameterMin;
    @Column(name = "diameter_max", unique = false, nullable = true)
    private Float diameterMax;
    @Column(name = "thickness_min", unique = false, nullable = true)
    private Float thicknessMin;
    @Column(name = "thickness_max", unique = false, nullable = true)
    private Float thicknessMax;
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
        this.unitOfMeasure = processSpecificationProcedure.getUnitOfMeasure();
        this.diameterMin = processSpecificationProcedure.getDiameterMin();
        this.diameterMax = processSpecificationProcedure.getDiameterMax();
        this.thicknessMin = processSpecificationProcedure.getThicknessMin();
        this.thicknessMax = processSpecificationProcedure.getThicknessMax();
        this.jointDesign = new JointDesignEntity(processSpecificationProcedure.getJointDesign());
        this.baseMaterialTypeList = new HashSet<>();
        initializeBaseMaterialListWithValues(processSpecificationProcedure);
        this.fusionProcess = new FusionProcessEntity(processSpecificationProcedure.getFusionProcess());
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

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getDiameterMin() {
        return diameterMin;
    }

    public void setDiameterMin(Float diameterMin) {
        this.diameterMin = diameterMin;
    }

    public Float getDiameterMax() {
        return diameterMax;
    }

    public void setDiameterMax(Float diameterMax) {
        this.diameterMax = diameterMax;
    }

    public Float getThicknessMin() {
        return thicknessMin;
    }

    public void setThicknessMin(Float thicknessMin) {
        this.thicknessMin = thicknessMin;
    }

    public Float getThicknessMax() {
        return thicknessMax;
    }

    public void setThicknessMax(Float thicknessMax) {
        this.thicknessMax = thicknessMax;
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
