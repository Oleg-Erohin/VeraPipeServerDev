package com.verapipe.entities;

import com.verapipe.dto.Coordinates;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "joint")
public class JointEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "number", nullable = false)
    private int number;
    @Column(name = "coordinates", nullable = false)
    private Coordinates coordinatesOnIsometric;
    @ManyToOne
    private PidEntity pid;
    @ManyToOne
    private IsometricEntity isometric;
    @Column(name = "sheet_on_isometric", nullable = false)
    private int sheetOnIsometric;
    @Column(name = "diameter_mm")
    private Float diameterMm;
    @Column(name = "diameter_inch")
    private Float diameterInch;
    @Column(name = "fitting_description_1", nullable = false)
    private String fittingDescription1;
    @ManyToMany
    private BaseMaterialTypeEntity baseMaterialType1;
    @ManyToMany
    private BaseMaterialCertificateEntity baseMaterialCertificate1;
    @Column(name = "fitting_description_1", nullable = false)
    private String fittingDescription2;
    @ManyToMany
    private BaseMaterialTypeEntity baseMaterialType2;
    @ManyToMany
    private BaseMaterialCertificateEntity baseMaterialCertificate2;
    @ManyToMany
    private FillerMaterialTypeEntity fillerMaterialType1;
    @ManyToMany
    private FillerMaterialCertificateEntity fillerMaterialCertificate1;
    @ManyToMany
    private FillerMaterialTypeEntity fillerMaterialType2;
    @ManyToMany
    private FillerMaterialCertificateEntity fillerMaterialCertificate2;
    @ManyToOne
    private ProcessSpecificationProcedureEntity processSpecificationProcedure;
    @ManyToMany
    private String joinerTagId1;
    @ManyToMany
    private String joinerTagId2;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "is_fit-up_done", nullable = false)
    private boolean isFitUpDone;
    @Column(name = "is_visual_inspection_done", nullable = false)
    private boolean isVisualInspectionDone;
    @ManyToOne
    private NdtReportEntity ndtReport;
    @Column(name = "is_ndt_passed", nullable = false)
    private boolean isNdtPassed;
    @ManyToOne
    private PreheatEntity preheat;
    @ManyToOne
    private PostWeldHeatTreatmentEntity postWeldHeatTreatment;
}
