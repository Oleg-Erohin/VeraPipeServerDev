package com.verapipe.entities;

import com.verapipe.dto.BaseMaterialType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "base_material_type")
public class BaseMaterialTypeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "baseMaterialTypeList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @ManyToMany(mappedBy = "baseMaterialTypeList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinerEntity> joinerList;
    @OneToMany(mappedBy = "baseMaterialType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BaseMaterialCertificateEntity> baseMaterialCertificatesList;
    @ManyToMany(mappedBy = "baseMaterialTypeList",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JointEntity> JointsList;

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

    public Set<ProcessSpecificationProcedureEntity> getProcessSpecificationProceduresList() {
        return processSpecificationProceduresList;
    }

    public void setProcessSpecificationProceduresList(Set<ProcessSpecificationProcedureEntity> processSpecificationProceduresList) {
        this.processSpecificationProceduresList = processSpecificationProceduresList;
    }

    public Set<JoinerEntity> getJoinerList() {
        return joinerList;
    }

    public void setJoinerList(Set<JoinerEntity> joinerList) {
        this.joinerList = joinerList;
    }

    public List<BaseMaterialCertificateEntity> getBaseMaterialCertificatesList() {
        return baseMaterialCertificatesList;
    }

    public void setBaseMaterialCertificatesList(List<BaseMaterialCertificateEntity> baseMaterialCertificatesList) {
        this.baseMaterialCertificatesList = baseMaterialCertificatesList;
    }

    public Set<JointEntity> getJointsList() {
        return JointsList;
    }

    public void setJointsList(Set<JointEntity> jointsList) {
        JointsList = jointsList;
    }
}
