package com.verapipe.dto;

import com.verapipe.entities.PreheatEntity;

import java.util.Date;

public class Preheat {
    private int id;
    private String name;
    private String processSpecificationProcedureName;
    private Date date;

    public Preheat() {
    }

    public Preheat(String name, String processSpecificationProcedureName, Date date) {
        this.name = name;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.date = date;
    }

    public Preheat(int id, String name, String processSpecificationProcedureName, Date date) {
        this.id = id;
        this.name = name;
        this.processSpecificationProcedureName = processSpecificationProcedureName;
        this.date = date;
    }

    public Preheat(PreheatEntity preheatEntity) {
        this.id = preheatEntity.getId();
        this.name = preheatEntity.getName();
        this.processSpecificationProcedureName = preheatEntity.getProcessSpecificationProcedure().getName();
        this.date = preheatEntity.getDate();
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
        return "Preheat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", processSpecificationProcedureName='" + processSpecificationProcedureName + '\'' +
                ", date=" + date +
                '}';
    }
}
