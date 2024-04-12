package com.verapipe.entities;

import com.verapipe.dto.Joiner;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "joiner")
public class JoinerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tag_id", unique = true, nullable = false)
    private String tagId;
    @Lob
    @Column(name = "certificate", nullable = false)
    private byte[] certificate;
    @Column(name = "certified_diameter_min_mm", unique = false, nullable = true)
    private Float certifiedDiameterMinMm;
    @Column(name = "certified_diameter_max_mm", unique = false, nullable = true)
    private Float certifiedDiameterMaxMm;
    @Column(name = "certified_diameter_min_inch", unique = false, nullable = true)
    private Float certifiedDiameterMinInch;
    @Column(name = "certified_diameter_max_inch", unique = false, nullable = true)
    private Float certifiedDiameterMaxInch;
    @Column(name = "max_deposited_material", unique = false, nullable = true)
    private Float maxDepositedMaterial;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_type_1")
    private BaseMaterialTypeEntity baseMaterialType1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_material_type_2")
    private BaseMaterialTypeEntity baseMaterialType2;
    @ManyToOne(fetch = FetchType.EAGER)
    private JointDesignEntity jointDesign;
    @ManyToOne(fetch = FetchType.EAGER)
    private FusionProcessEntity fusionProcess;
    @ManyToMany(mappedBy = "joinersList")
    private Set<JointEntity> jointsList;

    public JoinerEntity() {
    }

    public JoinerEntity(Joiner joiner) {
        this.id = joiner.getId();
        this.tagId = joiner.getTagId();
        this.certificate = joiner.getCertificate();
        this.certifiedDiameterMinMm = joiner.getCertifiedDiameterMinMm();
        this.certifiedDiameterMaxMm = joiner.getCertifiedDiameterMaxMm();
        this.certifiedDiameterMinInch = joiner.getCertifiedDiameterMinInch();
        this.certifiedDiameterMaxInch = joiner.getCertifiedDiameterMaxInch();
        this.maxDepositedMaterial = joiner.getMaxDepositedMaterial();
        this.baseMaterialType1 = new BaseMaterialTypeEntity();
        String baseMaterialTypeName1 = joiner.getBaseMaterialTypeName1();
        this.baseMaterialType1.setName(baseMaterialTypeName1);
        this.baseMaterialType2 = new BaseMaterialTypeEntity();
        String baseMaterialTypeName2 = joiner.getBaseMaterialTypeName2();
        this.baseMaterialType2.setName(baseMaterialTypeName2);
        this.jointDesign = new JointDesignEntity();
        String jointDesignName = joiner.getJointDesignName();
        this.jointDesign.setName(jointDesignName);
        this.fusionProcess = new FusionProcessEntity();
        String fusionProcessName = joiner.getFusionProcessName();
        this.fusionProcess.setName(fusionProcessName);
//        this.jointsList = new ArrayList<>();
        this.jointsList = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public Float getCertifiedDiameterMinMm() {
        return certifiedDiameterMinMm;
    }

    public void setCertifiedDiameterMinMm(Float certifiedDiameterMinMm) {
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
    }

    public Float getCertifiedDiameterMaxMm() {
        return certifiedDiameterMaxMm;
    }

    public void setCertifiedDiameterMaxMm(Float certifiedDiameterMaxMm) {
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
    }

    public Float getCertifiedDiameterMinInch() {
        return certifiedDiameterMinInch;
    }

    public void setCertifiedDiameterMinInch(Float certifiedDiameterMinInch) {
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
    }

    public Float getCertifiedDiameterMaxInch() {
        return certifiedDiameterMaxInch;
    }

    public void setCertifiedDiameterMaxInch(Float certifiedDiameterMaxInch) {
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
    }

    public Float getMaxDepositedMaterial() {
        return maxDepositedMaterial;
    }

    public void setMaxDepositedMaterial(Float maxDepositedMaterial) {
        this.maxDepositedMaterial = maxDepositedMaterial;
    }

    public BaseMaterialTypeEntity getBaseMaterialType1() {
        return baseMaterialType1;
    }

    public void setBaseMaterialType1(BaseMaterialTypeEntity baseMaterialType1) {
        this.baseMaterialType1 = baseMaterialType1;
    }

    public BaseMaterialTypeEntity getBaseMaterialType2() {
        return baseMaterialType2;
    }

    public void setBaseMaterialType2(BaseMaterialTypeEntity baseMaterialType2) {
        this.baseMaterialType2 = baseMaterialType2;
    }

    public JointDesignEntity getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(JointDesignEntity jointDesign) {
        this.jointDesign = jointDesign;
    }

    public FusionProcessEntity getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(FusionProcessEntity fusionProcess) {
        this.fusionProcess = fusionProcess;
    }

    public Set<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(Set<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }
}
