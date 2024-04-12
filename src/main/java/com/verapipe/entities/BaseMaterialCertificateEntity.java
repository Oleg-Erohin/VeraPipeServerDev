package com.verapipe.entities;

import com.verapipe.dto.BaseMaterialCertificate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "base_material_certificate")
public class BaseMaterialCertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "heat_number", unique = true, nullable = false)
    private String heatNum;
    @Column(name = "lot_number", unique = true, nullable = false)
    private String lotNum;
    @Lob
    @Column(name = "certificate_file", unique = false, nullable = true)
    private byte[] certificateFile;
    @ManyToOne(fetch = FetchType.EAGER)
    private BaseMaterialTypeEntity baseMaterialType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    public BaseMaterialCertificateEntity() {
    }

    public BaseMaterialCertificateEntity(BaseMaterialCertificate baseMaterialCertificate) {
        this.id = baseMaterialCertificate.getId();
        this.heatNum = baseMaterialCertificate.getHeatNum();
        this.lotNum = baseMaterialCertificate.getLotNum();
        this.certificateFile = baseMaterialCertificate.getFile();
        this.baseMaterialType = new BaseMaterialTypeEntity();
        String baseMaterialTypeName = baseMaterialCertificate.getMaterialTypeName();
        this.baseMaterialType.setName(baseMaterialTypeName);
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

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    public byte[] getCertificateFile() {
        return certificateFile;
    }

    public void setCertificateFile(byte[] certificateFile) {
        this.certificateFile = certificateFile;
    }

    public BaseMaterialTypeEntity getBaseMaterialType() {
        return baseMaterialType;
    }

    public void setBaseMaterialType(BaseMaterialTypeEntity baseMaterialType) {
        this.baseMaterialType = baseMaterialType;
    }

    public List<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }
}
