package com.verapipe.entities;

import com.verapipe.dto.FillerMaterialCertificate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filler_material_certificate")
public class FillerMaterialCertificateEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "heat_number", unique = true, nullable = false)
    private String heatNum;
    @ManyToOne(fetch = FetchType.EAGER)
    private FillerMaterialTypeEntity fillerMaterialType;
    @OneToMany(mappedBy = "fillerMaterialCertificateList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;

    public FillerMaterialCertificateEntity() {
    }

    public FillerMaterialCertificateEntity(FillerMaterialCertificate fillerMaterialCertificate) {
        this.id = fillerMaterialCertificate.getId();
        this.heatNum = fillerMaterialCertificate.getHeatNum();
        this.fillerMaterialType = new FillerMaterialTypeEntity();
        String fillerMaterialTypeName = fillerMaterialCertificate.getMaterialTypeName();
        this.fillerMaterialType.setName(fillerMaterialTypeName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeatNum() {
        return heatNum;
    }

    public void setHeatNum(String heatNum) {
        this.heatNum = heatNum;
    }

    public FillerMaterialTypeEntity getFillerMaterialType() {
        return fillerMaterialType;
    }

    public void setFillerMaterialType(FillerMaterialTypeEntity fillerMaterialType) {
        this.fillerMaterialType = fillerMaterialType;
    }

    public List<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        JointsList = jointsList;
    }
}
