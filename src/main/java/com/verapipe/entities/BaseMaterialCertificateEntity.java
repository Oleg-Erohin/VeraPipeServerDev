package com.verapipe.entities;

import javax.persistence.*;

@Entity
@Table(name = "base_material_certificate")
public class BaseMaterialCertificateEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "heat_number", unique = true, nullable = false)
    private String heatNum;
    @Column(name = "heat_number", unique = true, nullable = false)
    private String lotNum;
    @Column(name = "certificate_file")
    private byte[] certificateFile;
    @ManyToOne(fetch = FetchType.EAGER)
    private String materialName;

}
