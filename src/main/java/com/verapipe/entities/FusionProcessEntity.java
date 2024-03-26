package com.verapipe.entities;

import com.verapipe.dto.FusionProcess;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fusion_process")
public class FusionProcessEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "fusion_process", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @OneToMany(mappedBy = "fusion_process", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JoinerEntity> joinerList;

    public FusionProcessEntity() {
    }

    public FusionProcessEntity(FusionProcess fusionProcess) {
        this.id = fusionProcess.getId();
        this.name = fusionProcess.getName();
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
}
