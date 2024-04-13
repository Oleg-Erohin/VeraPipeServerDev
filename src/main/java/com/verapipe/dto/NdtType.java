package com.verapipe.dto;

import com.verapipe.entities.NdtTypeEntity;

public class NdtType {
    private int id;
    private String name;

    public NdtType() {
    }

    public NdtType(String name) {
        this.name = name;
    }

    public NdtType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public NdtType(NdtTypeEntity ndtTypeEntity) {
        this.id = ndtTypeEntity.getId();
        this.name = ndtTypeEntity.getName();
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

    @Override
    public String toString() {
        return "NdtType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
