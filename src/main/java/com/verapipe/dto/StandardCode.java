package com.verapipe.dto;

import com.verapipe.entities.StandardCodeEntity;

public class StandardCode {
    private int id;
    private String name;

    public StandardCode() {
    }

    public StandardCode(String name) {
        this.name = name;
    }

    public StandardCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StandardCode(StandardCodeEntity standardCodeEntity) {
        this.id = standardCodeEntity.getId();
        this.name = standardCodeEntity.getName();
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
        return "StandardCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
