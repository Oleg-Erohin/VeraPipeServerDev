package com.verapipe.entities;

import com.verapipe.dto.Joiner;
import com.verapipe.enums.UnitOfMeasure;

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
    @Column(name = "unit_of_measure", unique = false, nullable = true)
    private UnitOfMeasure unitOfMeasure;
    @Column(name = "certified_diameter_min", unique = false, nullable = true)
    private Float certifiedDiameterMin;
    @Column(name = "certified_diameter_max", unique = false, nullable = true)
    private Float certifiedDiameterMax;
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
        this.unitOfMeasure = joiner.getUnitOfMeasure();
        this.certifiedDiameterMin = joiner.getCertifiedDiameterMin();
        this.certifiedDiameterMax = joiner.getCertifiedDiameterMax();
        this.maxDepositedMaterial = joiner.getMaxDepositedMaterial();
        this.baseMaterialTypeList = new HashSet<>();
        initializeBaseMaterialTypeListWithValues(joiner);
        this.jointDesign = new JointDesignEntity(joiner.getJointDesign());
        this.fusionProcess = new FusionProcessEntity();
        String fusionProcessName = joiner.getFusionProcessName();
        this.fusionProcess.setName(fusionProcessName);
        this.jointsList = new HashSet<>();
    }

    private void initializeBaseMaterialTypeListWithValues(Joiner joiner) {
        BaseMaterialTypeEntity baseMaterialType1 = new BaseMaterialTypeEntity(joiner.getBaseMaterialType1());
        BaseMaterialTypeEntity baseMaterialType2 = new BaseMaterialTypeEntity(joiner.getBaseMaterialType2());
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

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getCertifiedDiameterMin() {
        return certifiedDiameterMin;
    }

    public void setCertifiedDiameterMin(Float certifiedDiameterMin) {
        this.certifiedDiameterMin = certifiedDiameterMin;
    }

    public Float getCertifiedDiameterMax() {
        return certifiedDiameterMax;
    }

    public void setCertifiedDiameterMax(Float certifiedDiameterMax) {
        this.certifiedDiameterMax = certifiedDiameterMax;
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
