package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "joint_design")
public class JointDesignEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "joint_design", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @OneToMany(mappedBy = "joint_design", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<JoinerEntity> joinerList;

}
