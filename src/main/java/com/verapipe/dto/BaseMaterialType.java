package com.verapipe.dto;

import com.verapipe.entities.BaseMaterialTypeEntity;

public class BaseMaterialType {
    private int id;
    private String name;

    public BaseMaterialType() {
    }

    public BaseMaterialType(String name) {
        this.name = name;
    }

    public BaseMaterialType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BaseMaterialType(BaseMaterialTypeEntity baseMaterialTypeEntity) {
        this.id = baseMaterialTypeEntity.getId();
        this.name = baseMaterialTypeEntity.getName();
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
        return "BaseMaterialType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
