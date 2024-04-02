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
    @OneToMany(mappedBy = "joint_design", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
    @ManyToOne(fetch = FetchType.EAGER)
    private List<JoinerEntity> joinerList;

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

    public List<ProcessSpecificationProcedureEntity> getProcessSpecificationProceduresList() {
        return processSpecificationProceduresList;
    }

    public void setProcessSpecificationProceduresList(List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList) {
        this.processSpecificationProceduresList = processSpecificationProceduresList;
    }

    public List<JoinerEntity> getJoinerList() {
        return joinerList;
    }

    public void setJoinerList(List<JoinerEntity> joinerList) {
        this.joinerList = joinerList;
    }
}
