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

    @ManyToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;

    @ManyToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JoinerEntity> joinerList;

    @OneToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BaseMaterialCertificateEntity> baseMaterialCertificatesList;

//    @ManyToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointEntity> JointsList;

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
}
