package com.verapipe.dto;

import com.verapipe.entities.PostWeldHeatTreatmentEntity;

import java.util.Arrays;
import java.util.Date;

public class PostWeldHeatTreatment {
    private int id;
    private String name;
    private String processSpecificationProcedureName;
    private byte[] file;
    private Date date;

    public PostWeldHeatTreatment() {
    }

    public PostWeldHeatTreatment(String name, String processSpecificationProcedureName, byte[] file, Date date) {
        this.name = name;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.file = file;
        this.date = date;
    }

    public PostWeldHeatTreatment(int id, String name, String processSpecificationProcedureName, byte[] file, Date date) {
        this.id = id;
        this.name = name;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.file = file;
        this.date = date;
    }

    public PostWeldHeatTreatment(PostWeldHeatTreatmentEntity postWeldHeatTreatmentEntity) {
        this.id = postWeldHeatTreatmentEntity.getId();
        this.name = postWeldHeatTreatmentEntity.getName();
        this.processSpecificationProcedureName = postWeldHeatTreatmentEntity.getProcessSpecificationProcedure().getName();
        this.file = postWeldHeatTreatmentEntity.getFile();
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
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
                ", file=" + Arrays.toString(file) +
                ", date=" + date +
                '}';
    }
}
