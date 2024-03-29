package com.verapipe.entities;

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
    @ManyToMany(mappedBy = "base_material_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;
}
