package com.verapipe.entities;

import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.enums.ThicknessUOM;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "process_specification_procedure")
public class ProcessSpecificationProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Lob
    @Column(name = "procedure_file", unique = true, nullable = true)
    private byte[] procedureFile;
    @Lob
    @Column(name = "procedure_qualification_record_file", unique = false, nullable = true)
    private byte[] processQualificationRecordFile;
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
    private ThicknessUOM thicknessUom;
    @Column(name = "thickness_mm_min", unique = false, nullable = true)
    private Float thicknessMmMin;
    @Column(name = "thickness_mm_max", unique = false, nullable = true)
    private Float thicknessMmMax;
    @ManyToOne(fetch = FetchType.EAGER)
    private JointDesignEntity jointDesign;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_type_1")
    private BaseMaterialTypeEntity baseMaterial1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_type_2")
    private BaseMaterialTypeEntity baseMaterial2;
    @ManyToOne(fetch = FetchType.EAGER)
    private FusionProcessEntity fusionProcess;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filler_material_type_1")
    private FillerMaterialTypeEntity fillerMaterial1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filler_material_type_2")
    private FillerMaterialTypeEntity fillerMaterial2;
    @ManyToOne(fetch = FetchType.EAGER)
    private StandardCodeEntity standardCode;
    @OneToMany(mappedBy = "processSpecificationProcedure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;
    @OneToMany(mappedBy = "processSpecificationProcedure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PreheatEntity> PreheatReportsList;
    @OneToMany(mappedBy = "processSpecificationProcedure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostWeldHeatTreatmentEntity> PostWeldHeatTreatmentsList;

    public ProcessSpecificationProcedureEntity() {
    }

    public ProcessSpecificationProcedureEntity(ProcessSpecificationProcedure processSpecificationProcedure) {
        this.id = processSpecificationProcedure.getId();
        this.name = processSpecificationProcedure.getName();
        this.procedureFile = processSpecificationProcedure.getProcedureFile();
        this.processQualificationRecordFile = processSpecificationProcedure.getProcessQualificationRecordFile();
        this.isPreheatRequired = processSpecificationProcedure.isPreheatRequired();
        this.isPostWeldHeatTreatmentRequired = processSpecificationProcedure.isPostWeldHeatTreatmentRequired();
        this.diameterMmMin = processSpecificationProcedure.getDiameterMmMin();
        this.diameterMmMax = processSpecificationProcedure.getDiameterMmMax();
        this.diameterInchMin = processSpecificationProcedure.getDiameterInchMin();
        this.diameterInchMax = processSpecificationProcedure.getDiameterInchMax();
        this.thicknessUom = processSpecificationProcedure.getThicknessUom();
        this.thicknessMmMin = processSpecificationProcedure.getThicknessMmMin();
        this.thicknessMmMax = processSpecificationProcedure.getThicknessMmMax();
        this.jointDesign = new JointDesignEntity();
        String jointDesignName = processSpecificationProcedure.getJointDesign();
        this.jointDesign.setName(jointDesignName);
        this.baseMaterial1 = new BaseMaterialTypeEntity();
        String baseMaterialName1 = processSpecificationProcedure.getBaseMaterial1();
        this.baseMaterial1.setName(baseMaterialName1);
        this.baseMaterial2 = new BaseMaterialTypeEntity();
        String baseMaterialName2 = processSpecificationProcedure.getBaseMaterial2();
        this.baseMaterial2.setName(baseMaterialName2);
        this.fusionProcess = new FusionProcessEntity();
        String fusionProcessName = processSpecificationProcedure.getFusionProcess();
        this.fusionProcess.setName(fusionProcessName);
        this.fillerMaterial1 = new FillerMaterialTypeEntity();
        String fillerMaterialName1 = processSpecificationProcedure.getFillerMaterial1();
        this.fillerMaterial1.setName(fillerMaterialName1);
        this.fillerMaterial2 = new FillerMaterialTypeEntity();
        String fillerMaterialName2 = processSpecificationProcedure.getFillerMaterial2();
        this.fillerMaterial2.setName(fillerMaterialName2);
        this.standardCode = new StandardCodeEntity();
        String standardCodeName = processSpecificationProcedure.getStandardCode();
        this.standardCode.setName(standardCodeName);
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

    public JointDesignEntity getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(JointDesignEntity jointDesign) {
        this.jointDesign = jointDesign;
    }

    public BaseMaterialTypeEntity getBaseMaterial1() {
        return baseMaterial1;
    }

    public void setBaseMaterial1(BaseMaterialTypeEntity baseMaterial1) {
        this.baseMaterial1 = baseMaterial1;
    }

    public BaseMaterialTypeEntity getBaseMaterial2() {
        return baseMaterial2;
    }

    public void setBaseMaterial2(BaseMaterialTypeEntity baseMaterial2) {
        this.baseMaterial2 = baseMaterial2;
    }

    public FusionProcessEntity getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(FusionProcessEntity fusionProcess) {
        this.fusionProcess = fusionProcess;
    }

    public FillerMaterialTypeEntity getFillerMaterial1() {
        return fillerMaterial1;
    }

    public void setFillerMaterial1(FillerMaterialTypeEntity fillerMaterial1) {
        this.fillerMaterial1 = fillerMaterial1;
    }

    public FillerMaterialTypeEntity getFillerMaterial2() {
        return fillerMaterial2;
    }

    public void setFillerMaterial2(FillerMaterialTypeEntity fillerMaterial2) {
        this.fillerMaterial2 = fillerMaterial2;
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
