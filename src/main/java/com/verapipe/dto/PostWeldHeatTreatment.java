package com.verapipe.dto;

import com.verapipe.entities.PostWeldHeatTreatmentEntity;

import java.util.Date;

public class PostWeldHeatTreatment {
    private int id;
    private String name;
    private String processSpecificationProcedureName;
    private Date date;

    public PostWeldHeatTreatment() {
    }

    public PostWeldHeatTreatment(String name, String processSpecificationProcedureName, Date date) {
        this.name = name;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.date = date;
    }

    public PostWeldHeatTreatment(int id, String name, String processSpecificationProcedureName, Date date) {
        this.id = id;
        this.name = name;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.date = date;
    }

    public PostWeldHeatTreatment(PostWeldHeatTreatmentEntity postWeldHeatTreatmentEntity) {
        this.id = postWeldHeatTreatmentEntity.getId();
        this.name = postWeldHeatTreatmentEntity.getName();
        this.processSpecificationProcedureName = postWeldHeatTreatmentEntity.getProcessSpecificationProcedure().getName();
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

    public String getProcessSpecificationProcedureName() {
        return processSpecificationProcedureName;
    }

    public void setProcessSpecificationProcedureName(String processSpecificationProcedureName) {
        this.processSpecificationProcedureName = processSpecificationProcedureName;
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
                ", processSpecificationProcedureName='" + processSpecificationProcedureName + '\'' +
                ", date=" + date +
                '}';
    }
}
