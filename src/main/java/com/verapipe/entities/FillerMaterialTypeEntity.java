package com.verapipe.entities;

import com.verapipe.dto.FillerMaterialType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filler_material_type")
public class FillerMaterialTypeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "filler_material_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @OneToMany(mappedBy = "filler_material_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FillerMaterialCertificateEntity> fillerMaterialCertificatesList;
    @OneToMany(mappedBy = "filler_material_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;

    public FillerMaterialTypeEntity() {
    }

    public FillerMaterialTypeEntity(FillerMaterialType fillerMaterialType) {
        this.id = fillerMaterialType.getId();
        this.name = fillerMaterialType.getName();
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

    public List<ProcessSpecificationProcedureEntity> getProcessSpecificationProceduresList() {
        return processSpecificationProceduresList;
    }

    public void setProcessSpecificationProceduresList(List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList) {
        this.processSpecificationProceduresList = processSpecificationProceduresList;
    }

    public List<FillerMaterialCertificateEntity> getFillerMaterialCertificatesList() {
        return fillerMaterialCertificatesList;
    }

    public void setFillerMaterialCertificatesList(List<FillerMaterialCertificateEntity> fillerMaterialCertificatesList) {
        this.fillerMaterialCertificatesList = fillerMaterialCertificatesList;
    }

    public List<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        JointsList = jointsList;
    }
}
