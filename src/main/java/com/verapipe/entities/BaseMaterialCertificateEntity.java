package com.verapipe.entities;

import com.verapipe.dto.BaseMaterialCertificate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "base_material_certificate")
public class BaseMaterialCertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "heat_number", unique = true, nullable = false)
    private String heatNum;
    @Column(name = "lot_number", unique = true, nullable = false)
    private String lotNum;
    @ManyToOne(fetch = FetchType.EAGER)
    private BaseMaterialTypeEntity baseMaterialType;
    @ManyToMany(mappedBy = "baseMaterialCertificateList",  fetch = FetchType.LAZY)
    private Set<JointEntity> jointsList;

    public BaseMaterialCertificateEntity() {
    }

    public BaseMaterialCertificateEntity(BaseMaterialCertificate baseMaterialCertificate) {
        this.id = baseMaterialCertificate.getId();
        this.name = baseMaterialCertificate.getName();
        this.heatNum = baseMaterialCertificate.getHeatNum();
        this.lotNum = baseMaterialCertificate.getLotNum();
        this.baseMaterialType = new BaseMaterialTypeEntity(baseMaterialCertificate.getBaseMaterialType());
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

    public String getHeatNum() {
        return heatNum;
    }

    public void setHeatNum(String heatNum) {
        this.heatNum = heatNum;
    }

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    public BaseMaterialTypeEntity getBaseMaterialType() {
        return baseMaterialType;
    }

    public void setBaseMaterialType(BaseMaterialTypeEntity baseMaterialType) {
        this.baseMaterialType = baseMaterialType;
    }

    public Set<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(Set<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }
}
