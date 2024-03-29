package com.verapipe.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "p&id")
public class PidEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Lob
    @Column(name = "file", unique = true, nullable = false)
    private byte[] file;
    @Column(name = "revision", nullable = false)
    private String revision;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "sheets", nullable = false)
    private int sheets;
    @ManyToMany(mappedBy = "p&id", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<IsometricEntity> isometricDrawingsList;
    @OneToMany(mappedBy = "p&id", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JointEntity> JointsList;
    @ManyToMany(mappedBy = "p&id", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<PressureTestPackageEntity> pressureTestPackagesList;

}
