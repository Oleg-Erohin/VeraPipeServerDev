package com.verapipe.entities;

import com.verapipe.dto.FillerMaterialType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filler_material_type")
public class FillerMaterialEntityType {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "filler_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;

//    @OneToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<FillerMaterialMillCertificateEntity> fillerMaterialMillCertificatesList;
//
//    @ManyToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointEntity> JointsList;

    public FillerMaterialEntityType() {
    }

    public FillerMaterialEntityType(FillerMaterialType fillerMaterialType) {
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
}
