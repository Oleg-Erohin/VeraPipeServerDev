package com.verapipe.entities;

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

    @ManyToMany(mappedBy = "filler_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;

    @OneToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FillerMaterialCertificateEntity> fillerMaterialCertificatesList;

    @ManyToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;

}
