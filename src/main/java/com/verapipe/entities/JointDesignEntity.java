package com.verapipe.entities;

import com.verapipe.dto.JointDesign;

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

//    @OneToMany(mappedBy = "joint_design", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private List<JointerEntity> jointerList;

    public JointDesignEntity() {
    }

    public JointDesignEntity(JointDesign jointDesign) {
        this.id = jointDesign.getId();
        this.name = jointDesign.getName();
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
