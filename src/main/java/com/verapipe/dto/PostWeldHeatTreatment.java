package com.verapipe.dto;

import com.verapipe.entities.PostWeldHeatTreatmentEntity;

import java.util.Date;

public class PostWeldHeatTreatment {
    private int id;
    private String name;
    private ProcessSpecificationProcedure processSpecificationProcedure;
    private Date date;

    public PostWeldHeatTreatment() {
    }

    public PostWeldHeatTreatment(String name, ProcessSpecificationProcedure processSpecificationProcedure, Date date) {
        this.name = name;
        this.processSpecificationProcedure = processSpecificationProcedure;
        this.date = date;
    }

    public PostWeldHeatTreatment(int id, String name, ProcessSpecificationProcedure processSpecificationProcedure, Date date) {
        this.id = id;
        this.name = name;
        this.processSpecificationProcedure = processSpecificationProcedure;
        this.date = date;
    }

    public PostWeldHeatTreatment(PostWeldHeatTreatmentEntity postWeldHeatTreatmentEntity) {
        this.id = postWeldHeatTreatmentEntity.getId();
        this.name = postWeldHeatTreatmentEntity.getName();
        this.processSpecificationProcedure = new ProcessSpecificationProcedure(postWeldHeatTreatmentEntity.getProcessSpecificationProcedure());
        this.date = postWeldHeatTreatmentEntity.getDate();
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

    public ProcessSpecificationProcedure getProcessSpecificationProcedure() {
        return processSpecificationProcedure;
    }

    public void setProcessSpecificationProcedure(ProcessSpecificationProcedure processSpecificationProcedure) {
        this.processSpecificationProcedure = processSpecificationProcedure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PostWeldHeatTreatment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", processSpecificationProcedure=" + processSpecificationProcedure +
                ", date=" + date +
                '}';
    }
}
