package com.verapipe.entities;

import com.verapipe.dto.StandardCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "standard_code")
public class StandardCodeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "standard_code", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;

    public StandardCodeEntity() {
    }

    public StandardCodeEntity(StandardCode standardCode) {
        this.id = standardCode.getId();
        this.name = standardCode.getName();
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

    public List<ProcessSpecificationProcedureEntity> getProcessSpecificationProceduresList() {
        return processSpecificationProceduresList;
    }

    public void setProcessSpecificationProceduresList(List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList) {
        this.processSpecificationProceduresList = processSpecificationProceduresList;
    }
}
