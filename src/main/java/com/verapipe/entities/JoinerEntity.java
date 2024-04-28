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
    @Column(name = "tag_id", unique = false, nullable = false)
    private String tagId;
    @Lob
    @Column(name = "certificate", unique = false, nullable = false)
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
    // TODO to make validation that only 2 objects in baseMaterialTypeList
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialTypeEntity> baseMaterialTypeList;
    @ManyToOne(fetch = FetchType.EAGER)
    private JointDesignEntity jointDesign;
    @ManyToOne(fetch = FetchType.EAGER)
    private FusionProcessEntity fusionProcess;
    @ManyToMany
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
        this.baseMaterialTypeList = new HashSet<>();
        initializeBaseMaterialTypeListWithValues(joiner);
        this.jointDesign = new JointDesignEntity();
        String jointDesignName = joiner.getJointDesignName();
        this.jointDesign.setName(jointDesignName);
        this.fusionProcess = new FusionProcessEntity();
        String fusionProcessName = joiner.getFusionProcessName();
        this.fusionProcess.setName(fusionProcessName);
        this.jointsList = new HashSet<>();
    }

    private void initializeBaseMaterialTypeListWithValues(Joiner joiner) {
        BaseMaterialTypeEntity baseMaterialType1 = new BaseMaterialTypeEntity();
        BaseMaterialTypeEntity baseMaterialType2 = new BaseMaterialTypeEntity();
        String baseMaterialTypeName1 = joiner.getBaseMaterialTypeName1();
        String baseMaterialTypeName2 = joiner.getBaseMaterialTypeName2();
        baseMaterialType1.setName(baseMaterialTypeName1);
        baseMaterialType2.setName(baseMaterialTypeName2);
        this.baseMaterialTypeList.add(baseMaterialType1);
        this.baseMaterialTypeList.add(baseMaterialType2);
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

    public Set<BaseMaterialTypeEntity> getBaseMaterialTypeList() {
        return baseMaterialTypeList;
    }

    public void setBaseMaterialTypeList(Set<BaseMaterialTypeEntity> baseMaterialTypeList) {
        this.baseMaterialTypeList = baseMaterialTypeList;
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
