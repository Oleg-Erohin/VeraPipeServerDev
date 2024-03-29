package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ndt_type")
public class NdtTypeEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "ndt_type", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<NdtReportEntity> ndtReportsList;

}
