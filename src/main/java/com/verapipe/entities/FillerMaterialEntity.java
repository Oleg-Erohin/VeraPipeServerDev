package com.verapipe.entities;

import com.verapipe.dto.FillerMaterial;
import com.verapipe.dto.JointDesign;

import javax.persistence.*;

@Entity
@Table(name = "filler_material")
public class FillerMaterialEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

//    @ManyToMany(mappedBy = "filler_material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
//
//    @OneToMany(mappedBy = "material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<FillerMaterialMillCertificateEntity> fillerMaterialMillCertificatesList;
//
//    @ManyToMany(mappedBy = "filler_material", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointEntity> JointsList;

    public FillerMaterialEntity() {
    }

    public FillerMaterialEntity(FillerMaterial fillerMaterial) {
        this.id = fillerMaterial.getId();
        this.name = fillerMaterial.getName();
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
