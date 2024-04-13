package com.verapipe.dto;

import com.verapipe.entities.FillerMaterialTypeEntity;

public class FillerMaterialType {
    private int id;
    private String name;

    public FillerMaterialType() {
    }

    public FillerMaterialType(String name) {
        this.name = name;
    }

    public FillerMaterialType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FillerMaterialType(FillerMaterialTypeEntity fillerMaterialTypeEntity) {
        this.id = fillerMaterialTypeEntity.getId();
        this.name = fillerMaterialTypeEntity.getName();
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
        return "FillerMaterialType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
