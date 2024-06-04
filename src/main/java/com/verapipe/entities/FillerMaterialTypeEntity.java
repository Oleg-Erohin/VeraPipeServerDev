package com.verapipe.entities;

import com.verapipe.dto.FillerMaterialType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "filler_material_type")
public class FillerMaterialTypeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "fillerMaterialTypeList", fetch = FetchType.LAZY)
    private Set<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @OneToMany(mappedBy = "fillerMaterialType", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FillerMaterialCertificateEntity> fillerMaterialCertificatesList;
    @ManyToMany(mappedBy = "fillerMaterialTypeList", fetch = FetchType.LAZY)
    private Set<JointEntity> JointsList;

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

    public Set<ProcessSpecificationProcedureEntity> getProcessSpecificationProceduresList() {
        return processSpecificationProceduresList;
    }

    public void setProcessSpecificationProceduresList(Set<ProcessSpecificationProcedureEntity> processSpecificationProceduresList) {
        this.processSpecificationProceduresList = processSpecificationProceduresList;
    }

    public List<FillerMaterialCertificateEntity> getFillerMaterialCertificatesList() {
        return fillerMaterialCertificatesList;
    }

    public void setFillerMaterialCertificatesList(List<FillerMaterialCertificateEntity> fillerMaterialCertificatesList) {
        this.fillerMaterialCertificatesList = fillerMaterialCertificatesList;
    }

    public Set<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(Set<JointEntity> jointsList) {
        JointsList = jointsList;
    }
}
