package com.verapipe.entities;

import com.verapipe.dto.Preheat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "preheat")
public class PreheatEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "date", unique = false, nullable = false)
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProcessSpecificationProcedureEntity processSpecificationProcedure;
    @OneToMany(mappedBy = "preheat", fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;

    public PreheatEntity() {
    }

    public PreheatEntity(Preheat preheat) {
        this.id = preheat.getId();
        this.name = preheat.getName();
        this.date = preheat.getDate();
        this.processSpecificationProcedure = new ProcessSpecificationProcedureEntity(preheat.getProcessSpecificationProcedure());
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
