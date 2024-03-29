package com.verapipe.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ndt_report")
public class NdtReportEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "file")
    private byte[] file;
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne
    private NdtTypeEntity ndtType;
    @OneToMany(mappedBy = "ndt_report")
    private List<JointEntity> jointsList;

}
