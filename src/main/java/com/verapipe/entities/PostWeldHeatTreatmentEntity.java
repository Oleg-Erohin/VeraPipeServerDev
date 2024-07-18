package com.verapipe.entities;

import com.verapipe.dto.PostWeldHeatTreatment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post_weld_heat_treatment")
public class PostWeldHeatTreatmentEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "date", unique = false, nullable = false)
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProcessSpecificationProcedureEntity processSpecificationProcedure;
    @OneToMany(mappedBy = "postWeldHeatTreatment", fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    public PostWeldHeatTreatmentEntity() {
    }

    public PostWeldHeatTreatmentEntity(PostWeldHeatTreatment postWeldHeatTreatment) {
        this.id = postWeldHeatTreatment.getId();
        this.name = postWeldHeatTreatment.getName();
        this.date = postWeldHeatTreatment.getDate();
        this.processSpecificationProcedure = new ProcessSpecificationProcedureEntity(postWeldHeatTreatment.getProcessSpecificationProcedure());
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProcessSpecificationProcedureEntity getProcessSpecificationProcedure() {
        return processSpecificationProcedure;
    }

    public void setProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedure) {
        this.processSpecificationProcedure = processSpecificationProcedure;
    }

    public List<JointEntity> getJointsList() {
        return jointsList;
    }

    public void setJointsList(List<JointEntity> jointsList) {
        this.jointsList = jointsList;
    }
}
