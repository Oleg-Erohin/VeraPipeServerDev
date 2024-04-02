package com.verapipe.entities;

import com.verapipe.dto.BaseMaterialType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "base_material_type")
public class BaseMaterialTypeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JoinerEntity> joinerList;
    @OneToMany(mappedBy = "baseMaterialType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BaseMaterialCertificateEntity> baseMaterialCertificatesList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;

    public BaseMaterialTypeEntity() {
    }

    public BaseMaterialTypeEntity(BaseMaterialType baseMaterialType) {
        this.id = baseMaterialType.getId();
        this.name = baseMaterialType.getName();
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

    public List<JoinerEntity> getJoinerList() {
        return joinerList;
    }

    public void setJoinerList(List<JoinerEntity> joinerList) {
        this.joinerList = joinerList;
    }

    public List<BaseMaterialCertificateEntity> getBaseMaterialCertificatesList() {
        return baseMaterialCertificatesList;
    }

    public void setBaseMaterialCertificatesList(List<BaseMaterialCertificateEntity> baseMaterialCertificatesList) {
        this.baseMaterialCertificatesList = baseMaterialCertificatesList;
    }

    public List<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        JointsList = jointsList;
    }
}
