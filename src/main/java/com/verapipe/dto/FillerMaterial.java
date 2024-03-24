package com.verapipe.dto;

public class FillerMaterial {
    private int id;
    private String name;

    public FillerMaterial() {
    }

    public FillerMaterial(String name) {
        this.name = name;
    }

    public FillerMaterial(int id, String name) {
        this.id = id;
        this.name = name;
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
        return "FillerMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
