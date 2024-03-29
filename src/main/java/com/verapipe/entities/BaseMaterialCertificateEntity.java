package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "base_material_certificate")
public class BaseMaterialCertificateEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "heat_number", unique = true, nullable = false)
    private String heatNum;
    @Column(name = "lot_number", unique = true, nullable = false)
    private String lotNum;
    @Column(name = "certificate_file")
    private byte[] certificateFile;
    @ManyToOne(fetch = FetchType.EAGER)
    private String materialName;
    @ManyToMany(mappedBy = "base_material_certificate", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

}
