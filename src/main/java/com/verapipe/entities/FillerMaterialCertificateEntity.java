package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filler_material_certificate")
public class FillerMaterialCertificateEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "heat_number", unique = true, nullable = false)
    private String heatNum;
    @Column(name = "certificate_file")
    private byte[] certificateFile;
    @ManyToOne(fetch = FetchType.EAGER)
    private String materialName;
    @ManyToMany(mappedBy = "filler_material_certificate", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;

}
