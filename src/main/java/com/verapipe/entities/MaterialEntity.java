package com.verapipe.entities;

import com.verapipe.dto.Material;

import javax.persistence.*;

@Entity
@Table(name = "material")
public class MaterialEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

//    @ManyToMany(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
//
//    @ManyToMany(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointerEntity> jointerList;
//
//    @OneToMany(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<MaterialMillCertificateEntity> materialMillCertificatesList;
//
//    @ManyToMany(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointEntity> JointsList;

    public MaterialEntity() {
    }

    public MaterialEntity(Material material) {
        this.id = material.getId();
        this.name = material.getName();
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
