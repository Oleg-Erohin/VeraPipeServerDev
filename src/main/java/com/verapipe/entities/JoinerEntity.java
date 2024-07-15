package com.verapipe.entities;

import com.verapipe.dto.Joiner;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "joiner")
public class JoinerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tag_id", unique = false, nullable = false)
    private String tagId;
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
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BaseMaterialTypeEntity> baseMaterialTypeList;
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
        this.certifiedDiameterMinMm = joiner.getCertifiedDiameterMin();
        this.certifiedDiameterMaxMm = joiner.getCertifiedDiameterMax();
        this.maxDepositedMaterial = joiner.getMaxDepositedMaterial();

        // Convert BaseMaterialType DTOs to Entities
        if (joiner.getBaseMaterialType1() != null) {
            this.baseMaterialTypeList.add(new BaseMaterialTypeEntity(joiner.getBaseMaterialType1()));
        }
        if (joiner.getBaseMaterialType2() != null) {
            this.baseMaterialTypeList.add(new BaseMaterialTypeEntity(joiner.getBaseMaterialType2()));
        }

        // Convert JointDesign DTO to Entity
        if (joiner.getJointDesign() != null) {
            this.jointDesign = new JointDesignEntity(joiner.getJointDesign());
        }

        // Convert FusionProcess DTO to Entity
        if (joiner.getFusionProcess() != null) {
            this.fusionProcess = new FusionProcessEntity(joiner.getFusionProcess());
        }
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
