package com.verapipe.dto;

import com.verapipe.entities.PreheatEntity;

import java.util.Date;

public class Preheat {
    private int id;
    private String name;
    private ProcessSpecificationProcedure processSpecificationProcedure;
    private Date date;

    public Preheat() {
    }

    public Preheat(String name, ProcessSpecificationProcedure processSpecificationProcedure, Date date) {
        this.name = name;
        this.processSpecificationProcedure = processSpecificationProcedure;
        this.date = date;
    }

    public Preheat(int id, String name, ProcessSpecificationProcedure processSpecificationProcedure, Date date) {
        this.id = id;
        this.name = name;
        this.processSpecificationProcedure = processSpecificationProcedure;
        this.date = date;
    }

    public Preheat(PreheatEntity preheatEntity) {
        this.id = preheatEntity.getId();
        this.name = preheatEntity.getName();
        this.processSpecificationProcedure = new ProcessSpecificationProcedure(preheatEntity.getProcessSpecificationProcedure());
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
        return "Preheat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", processSpecificationProcedure=" + processSpecificationProcedure +
                ", date=" + date +
                '}';
    }
}
