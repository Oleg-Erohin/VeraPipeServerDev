package com.verapipe.entities;

import com.verapipe.enums.ThicknessUOM;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "process_specification_procedure")
public class ProcessSpecificationProcedureEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Lob
    @Column(name = "procedure_file")
    private Byte[] procedureFile;

    @Lob
    @Column(name = "procedure_file")
    private Byte[] processQualificationRecordFile;

    @Column(name = "is_preheat_required", nullable = false)
    private boolean isPreheatRequired;

    @Column(name = "is_post_weld_heat_treatment_required", nullable = false)
    private boolean isPostWeldHeatTreatmentRequired;

    @Column(name = "diameter_mm_min")
    private Float diameterMmMin;

    @Column(name = "diameter_mm_max")
    private Float diameterMmMax;

    @Column(name = "diameter_inch_min")
    private Float diameterInchMin;

    @Column(name = "diameter_inch_max")
    private Float diameterInchMax;

    @Column(name = "thickness_uom", nullable = false)
    private ThicknessUOM thicknessUom;

    @Column(name = "thickness_mm_min")
    private Float thicknessMmMin;

    @Column(name = "thickness_mm_max")
    private Float thicknessMmMax;

    @ManyToOne(fetch = FetchType.EAGER)
    private List<JointDesignEntity> jointDesignsList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<BaseMaterialTypeEntity> baseMaterials1List;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<BaseMaterialTypeEntity> baseMaterials2List;

    @ManyToOne(fetch = FetchType.EAGER)
    private List<FusionProcessEntity> fusionProcessesList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<FillerMaterialTypeEntity> fillerMaterials1List;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<FillerMaterialTypeEntity> fillerMaterials2List;

    @ManyToOne(fetch = FetchType.EAGER)
    private String standardCode;

    @OneToMany(mappedBy = "process_specification_procedure", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;

    @OneToMany(mappedBy = "process_specification_procedure", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<PreheatEntity> PreheatReportsList;

    @OneToMany(mappedBy = "process_specification_procedure", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<PostWeldHeatTreatmentEntity> PostWeldHeatTreatmentsList;

}
