package com.verapipe.dto;

public class JointDesign {
    private int id;
    private String name;

    public JointDesign() {
    }

    public JointDesign(String name) {
        this.name = name;
    }

    public JointDesign(int id, String name) {
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
        return "JointDesign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
