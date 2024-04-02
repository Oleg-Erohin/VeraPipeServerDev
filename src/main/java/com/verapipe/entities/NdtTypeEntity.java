package com.verapipe.entities;

import com.verapipe.dto.NdtType;

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
    @OneToMany(mappedBy = "ndtType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NdtReportEntity> ndtReportsList;

    public NdtTypeEntity() {
    }

    public NdtTypeEntity(NdtType ndtType) {
        this.id = ndtType.getId();
        this.name = ndtType.getName();
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

    public List<NdtReportEntity> getNdtReportsList() {
        return ndtReportsList;
    }

    public void setNdtReportsList(List<NdtReportEntity> ndtReportsList) {
        this.ndtReportsList = ndtReportsList;
    }
}
