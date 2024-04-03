package com.verapipe.entities;

import com.verapipe.dto.Joint;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "diameter_mm", unique = false, nullable = true)
    private Float diameterMm;
    @Column(name = "diameter_inch", unique = false, nullable = true)
    private Float diameterInch;
    @Column(name = "fitting_description_1", unique = false, nullable = false)
    private String fittingDescription1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_type_1")
    private BaseMaterialTypeEntity baseMaterialType1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_certificate_1")
    private BaseMaterialCertificateEntity baseMaterialCertificate1;
    @Column(name = "fitting_description_2", unique = false, nullable = false)
    private String fittingDescription2;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_type_2")
    private BaseMaterialTypeEntity baseMaterialType2;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_certificate_2")
    private BaseMaterialCertificateEntity baseMaterialCertificate2;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filler_material_type_1")
    private FillerMaterialTypeEntity fillerMaterialType1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filler_material_certificate_1")
    private FillerMaterialCertificateEntity fillerMaterialCertificate1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filler_material_type_2")
    private FillerMaterialTypeEntity fillerMaterialType2;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filler_material_certificate_2")
    private FillerMaterialCertificateEntity fillerMaterialCertificate2;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProcessSpecificationProcedureEntity processSpecificationProcedure;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "joiner_1")
    private JoinerEntity joiner1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "joiner_2")
    private JoinerEntity joiner2;
    @Column(name = "date", unique = false, nullable = false)
    private Date date;
    @Column(name = "is_fitup_done", unique = false, nullable = false)
    private boolean isFitUpDone;
    @Column(name = "is_visual_inspection_done", unique = false, nullable = false)
    private boolean isVisualInspectionDone;
    @ManyToOne(fetch = FetchType.EAGER)
    private NdtReportEntity ndtReport;
    @Column(name = "is_ndt_passed", unique = false, nullable = false)
    private boolean isNdtPassed;
    @ManyToOne(fetch = FetchType.EAGER)
    private PreheatEntity preheat;
    @ManyToOne(fetch = FetchType.EAGER)
    private PostWeldHeatTreatmentEntity postWeldHeatTreatment;

    public JointEntity() {
    }

    public JointEntity(Joint joint) {
        this.id = joint.getId();
        this.number = joint.getNumber();
        this.coordinatesOnIsometric = joint.getCoordinatesOnIsometric().toString();
        this.pid = new PidEntity();
        String pidName = joint.getPidName();
        this.pid.setName(pidName);
        this.isometric = new IsometricEntity();
        String isometricName = joint.getIsometricName();
        this.isometric.setName(isometricName);
        this.sheetOnIsometric = joint.getSheetOnIsometric();
        this.diameterMm = joint.getDiameterMm();
        this.diameterInch = joint.getDiameterInch();
        this.fittingDescription1 = joint.getFittingDescription1();
        this.baseMaterialType1 = new BaseMaterialTypeEntity();
        String baseMaterialTypeName1 = joint.getBaseMaterialTypeName1();
        this.baseMaterialType1.setName(baseMaterialTypeName1);
        this.baseMaterialCertificate1 = new BaseMaterialCertificateEntity();
        String baseMaterialHeatNum1 = joint.getBaseMaterialHeatNum1();
        this.baseMaterialCertificate1.setHeatNum(baseMaterialHeatNum1);
        this.fittingDescription2 = joint.getFittingDescription2();
        this.baseMaterialType2 = new BaseMaterialTypeEntity();
        String baseMaterialTypeName2 = joint.getBaseMaterialTypeName2();
        this.baseMaterialType2.setName(baseMaterialTypeName2);
        this.baseMaterialCertificate2 = new BaseMaterialCertificateEntity();
        String baseMaterialHeatNum2 = joint.getBaseMaterialHeatNum2();
        this.baseMaterialCertificate2.setHeatNum(baseMaterialHeatNum2);
        this.fillerMaterialType1 = new FillerMaterialTypeEntity();
        String fillerMaterialTypeName1 = joint.getFillerMaterialTypeName1();
        this.fillerMaterialType1.setName(fillerMaterialTypeName1);
        this.fillerMaterialCertificate1 = new FillerMaterialCertificateEntity();
        String fillerMaterialHeatNum1 = joint.getFillerMaterialHeatNum1();
        this.fillerMaterialCertificate1.setHeatNum(fillerMaterialHeatNum1);
        this.fillerMaterialType2 = new FillerMaterialTypeEntity();
        String fillerMaterialTypeName2 = joint.getFillerMaterialTypeName2();
        this.fillerMaterialType2.setName(fillerMaterialTypeName2);
        this.fillerMaterialCertificate2 = new FillerMaterialCertificateEntity();
        String fillerMaterialHeatNum2 = joint.getFillerMaterialHeatNum2();
        this.fillerMaterialCertificate2.setHeatNum(fillerMaterialHeatNum2);
        this.processSpecificationProcedure = new ProcessSpecificationProcedureEntity();
        String processSpecificationProcedureName = joint.getProcessSpecificationProcedureName();
        this.processSpecificationProcedure.setName(processSpecificationProcedureName);
        this.joiner1 = new JoinerEntity();
        String joinerTagId1 = joint.getJoinerTagId1();
        this.joiner1.setTagId(joinerTagId1);
        this.joiner2 = new JoinerEntity();
        String joinerTagId2 = joint.getJoinerTagId2();
        this.joiner2.setTagId(joinerTagId2);
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

    public Float getDiameterMm() {
        return diameterMm;
    }

    public void setDiameterMm(Float diameterMm) {
        this.diameterMm = diameterMm;
    }

    public Float getDiameterInch() {
        return diameterInch;
    }

    public void setDiameterInch(Float diameterInch) {
        this.diameterInch = diameterInch;
    }

    public String getFittingDescription1() {
        return fittingDescription1;
    }

    public void setFittingDescription1(String fittingDescription1) {
        this.fittingDescription1 = fittingDescription1;
    }

    public BaseMaterialTypeEntity getBaseMaterialType1() {
        return baseMaterialType1;
    }

    public void setBaseMaterialType1(BaseMaterialTypeEntity baseMaterialType1) {
        this.baseMaterialType1 = baseMaterialType1;
    }

    public BaseMaterialCertificateEntity getBaseMaterialCertificate1() {
        return baseMaterialCertificate1;
    }

    public void setBaseMaterialCertificate1(BaseMaterialCertificateEntity baseMaterialCertificate1) {
        this.baseMaterialCertificate1 = baseMaterialCertificate1;
    }

    public String getFittingDescription2() {
        return fittingDescription2;
    }

    public void setFittingDescription2(String fittingDescription2) {
        this.fittingDescription2 = fittingDescription2;
    }

    public BaseMaterialTypeEntity getBaseMaterialType2() {
        return baseMaterialType2;
    }

    public void setBaseMaterialType2(BaseMaterialTypeEntity baseMaterialType2) {
        this.baseMaterialType2 = baseMaterialType2;
    }

    public BaseMaterialCertificateEntity getBaseMaterialCertificate2() {
        return baseMaterialCertificate2;
    }

    public void setBaseMaterialCertificate2(BaseMaterialCertificateEntity baseMaterialCertificate2) {
        this.baseMaterialCertificate2 = baseMaterialCertificate2;
    }

    public FillerMaterialTypeEntity getFillerMaterialType1() {
        return fillerMaterialType1;
    }

    public void setFillerMaterialType1(FillerMaterialTypeEntity fillerMaterialType1) {
        this.fillerMaterialType1 = fillerMaterialType1;
    }

    public FillerMaterialCertificateEntity getFillerMaterialCertificate1() {
        return fillerMaterialCertificate1;
    }

    public void setFillerMaterialCertificate1(FillerMaterialCertificateEntity fillerMaterialCertificate1) {
        this.fillerMaterialCertificate1 = fillerMaterialCertificate1;
    }

    public FillerMaterialTypeEntity getFillerMaterialType2() {
        return fillerMaterialType2;
    }

    public void setFillerMaterialType2(FillerMaterialTypeEntity fillerMaterialType2) {
        this.fillerMaterialType2 = fillerMaterialType2;
    }

    public FillerMaterialCertificateEntity getFillerMaterialCertificate2() {
        return fillerMaterialCertificate2;
    }

    public void setFillerMaterialCertificate2(FillerMaterialCertificateEntity fillerMaterialCertificate2) {
        this.fillerMaterialCertificate2 = fillerMaterialCertificate2;
    }

    public ProcessSpecificationProcedureEntity getProcessSpecificationProcedure() {
        return processSpecificationProcedure;
    }

    public void setProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedure) {
        this.processSpecificationProcedure = processSpecificationProcedure;
    }

    public JoinerEntity getJoiner1() {
        return joiner1;
    }

    public void setJoiner1(JoinerEntity joiner1) {
        this.joiner1 = joiner1;
    }

    public JoinerEntity getJoiner2() {
        return joiner2;
    }

    public void setJoiner2(JoinerEntity joiner2) {
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

    public NdtReportEntity getNdtReport() {
        return ndtReport;
    }

    public void setNdtReport(NdtReportEntity ndtReport) {
        this.ndtReport = ndtReport;
    }

    public boolean isNdtPassed() {
        return isNdtPassed;
    }

    public void setNdtPassed(boolean ndtPassed) {
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
