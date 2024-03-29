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

}
