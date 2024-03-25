package com.verapipe.dto;

public class FusionProcess {
    private int id;
    private String name;

    public FusionProcess() {
    }

    public FusionProcess(String name) {
        this.name = name;
    }

    public FusionProcess(int id, String name) {
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
        return "FusionProcess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
